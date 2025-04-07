import Personagens.Herois.Heroi;
import Personagens.Monstros.Monstro;
import Personagens.Personagem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Batalha {
    Dado dado = new Dado();

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

    public static int calularDano(Personagem personagem) {
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
    public void gravarBatalha(String heroiEscolhido, String resultadoBatalha, String monstroEnfrentado, int quantidadeRodadas) {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoData.format(new Date()).toString();
        System.out.println(String.format("%s,%s,%s,%s,%d",dataFormatada,heroiEscolhido,resultadoBatalha,monstroEnfrentado,quantidadeRodadas));

    }
}

