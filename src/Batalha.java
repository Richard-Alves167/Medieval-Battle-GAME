import EstilizacaoTerminal.MudarCorTerminal;
import Personagens.Herois.Heroi;
import Personagens.Monstros.Monstro;
import Personagens.Personagem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    Dado dado = new Dado();
    MudarCorTerminal mudarCor = new MudarCorTerminal();
    private static void pausaNoCodigo(int tempoEscolhido) {
        try {
            Thread.sleep(tempoEscolhido);
        } catch (Exception e) {
        }
    }

    public int inicializacaoDeBatalha(int fatorAgiligade) {
        int calculoIniciativa = dado.rolarDado10Lados() + fatorAgiligade;
        return calculoIniciativa;
    }

    public boolean iniciarBatalha(Heroi heroiEscolhido, Monstro monstroEscolhido) {
        int valorHeroi;
        int valorMonstro;
        boolean valorResultante;
        System.out.println("\nPara iniciar a batalha, iremos ver quem terá o maior número, rolando o dado de inicialização (10 lados) com mais o número de agilidade do personagem.");
        do {
            mudarCor.
            System.out.println("Rolando os dados...");
            valorHeroi = inicializacaoDeBatalha(heroiEscolhido.getAgilidade());
            valorMonstro = inicializacaoDeBatalha(monstroEscolhido.getAgilidade());
            System.out.println("Valor do Herói: " + valorHeroi);
            System.out.println("Valor do Monstro: " + valorMonstro);
            if (valorHeroi == valorMonstro) {
                System.out.println("Ops, os valores de agilidade deram iguais, jogando novamente!");
            }
        } while (valorHeroi == valorMonstro);

        if (valorHeroi > valorMonstro) {
            valorResultante = true;
            System.out.println("Você começa a batalha!");
        } else {
            valorResultante = false;
            System.out.println("O inimigo começa a batalha!");
        }
        return valorResultante;
    }

    public int fatorDeAtaque(Personagem personagem) {
        int fatorDeAtaque = dado.rolarDado10Lados() + personagem.getAgilidade() + personagem.getForca();
        return fatorDeAtaque;
    }

    public int fatorDeDefesa(Personagem personagem) {
        int fatorDeAtaque = dado.rolarDado10Lados()  + personagem.getAgilidade() + personagem.getDefesa();
        return fatorDeAtaque;
    }

    public boolean verificarAtaque(Personagem personagem) {
        if (fatorDeAtaque(personagem) > fatorDeDefesa(personagem)) {
            System.out.println("O fator de ataque de "+ personagem.getClasse() + " foi superior ao de defesa!");
            return true;
        }
        System.out.println("O "+ personagem.getClasse() + " perdeu o ataque!");
        return false;
    }

    private static int calularDano(Personagem personagem) {
        System.out.println("Calculando dano...");
        int dano = personagem.getForca();
        String[] fatorDeDano = personagem.getFatorDeDano().split("d");
        int quantidadeVezesDado = Integer.parseInt(fatorDeDano[0]);
        int dadoLados = Integer.parseInt(fatorDeDano[1]);
        for (int i = 1; i <=quantidadeVezesDado;i++) {
            dano += Dado.rolarDado(dadoLados);
        }
        return dano;
    }

    public void ataqueAoAdversario(Personagem atacaAdversario,Personagem recebeOAtaque) {
        System.out.println(atacaAdversario.getClasse() + " atacou o " + recebeOAtaque.getClasse());
        int dano = calularDano(atacaAdversario);
        recebeOAtaque.receberAtaque(dano);
        System.out.println(atacaAdversario.getClasse() + " atacou com " + dano + " de dano ao " + recebeOAtaque.getClasse());
    }

    public void verificarResultadoRodada(Personagem heroi,Personagem monstro, int rodada) {
        System.out.println("\n========== Resultado da rodada " + rodada + " ==========");
        System.out.println(heroi.getClasse() + ": " + heroi.getPontosDeVida() + " pontos de vida restantes.");
        System.out.println(monstro.getClasse() + ": " + monstro.getPontosDeVida() + " pontos de vida restantes.");
        System.out.println("=========================================");
        pausaNoCodigo(3500);
    }

    public String resultadoBatalha(Personagem heroi, Personagem monstro) {
        String heroiVenceu;
        System.out.println("\n*===== Fim da batalha! =====*");
        if (heroi.getPontosDeVida() <= 0) {
            heroiVenceu = "PERDEU";
            System.out.println("Você perdeu! O " + monstro.getClasse() + " saiu vitorioso.");
        } else {
            heroiVenceu = "GANHOU";
            System.out.println("Você derrotou o " + monstro.getClasse() + ", Parabéns!");
        }
        return heroiVenceu;
    }

    public String gravarBatalha(String heroiEscolhido, String resultadoBatalha, String monstroEnfrentado, int quantidadeRodadas) {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoData.format(new Date()).toString();
        return String.format("\n%s,%s,%s,%s,%d",dataFormatada,heroiEscolhido,resultadoBatalha,monstroEnfrentado,quantidadeRodadas);
    }

    private Path caminhoJogador(String nicknameJogador) {
        String diretorioJogador = String.format("%s.csv",nicknameJogador);
        Path caminhoDiretorio = Paths.get("src","Temp",diretorioJogador);
        return caminhoDiretorio;
    }

    public void gravarBatalhaNoArquivo(String nicknameJogador, String resultadoBatalha) {
        try {
            Path caminhoDiretorio = caminhoJogador(nicknameJogador);
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Data da Partida;Herói escolhido;PERDEU[ou]GANHOU;Monstro enfrentado;Quantidade de Rodadas".getBytes());
            }
            escreverArquivo.write(resultadoBatalha.getBytes());
            System.out.println("Resultado da batalha salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }
    }

    private String buscarJogador() {
        Scanner leitor =  new Scanner(System.in);
        System.out.print("\nProcurar Jogador: ");
        String jogador = leitor.nextLine();
        return jogador;
    }

    private boolean verificarArquivoJogador(String nicknameJogador) {
        System.out.println("\nVerificando jogador...");
        Path diretorioJogador = caminhoJogador(nicknameJogador);
        try {
            InputStream inputStream = Files.newInputStream(diretorioJogador);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void buscarRelatorios() {
        String jogador = buscarJogador();
        if (verificarArquivoJogador(jogador)) {
            DadosJogador dadosDoJogador = new DadosJogador(jogador);
            dadosDoJogador.verStatusDeJogador();
        } else {
            System.out.println("Jogador não encontrado no sistema. :(");
        }
    }
}

