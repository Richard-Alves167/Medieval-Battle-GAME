import Personagens.Herois.Heroi;
import Personagens.Monstros.Monstro;
import Personagens.Personagem;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolhaUsuario = 0;
        do {
            menuVideoGame();
            escolhaUsuario = escolherNumero();
            switch (escolhaUsuario) {
                case 1: {
                    System.out.println("Selecionado: Jogar Video Game");
                    System.out.println("Carregando...");
                    pausaNoCodigo(2000);
                    jogarVideoGame();
                    break;
                }
                case 2: {
                    System.out.println("Selecionado: Buscar relatório de Jogador");
                    System.out.println("Carregando...");
                    pausaNoCodigo(2000);
                    buscarRelatorioJogador();
                    break;
                }
            }
        } while (escolhaUsuario != 3);
        System.out.println("\n* ===== Game Over ===== *");
    }

    public static void pausaNoCodigo(int tempoEscolhido) {
        try {
            Thread.sleep(tempoEscolhido);
        } catch (Exception e) {
        }
    }
    public static int escolherNumero() {
        int numeroEscolhido = 0;
        boolean pararLoop = false;
        do {
            try {
                Scanner leitor = new Scanner(System.in);
                numeroEscolhido = leitor.nextInt();
                if (numeroEscolhido < 1 || numeroEscolhido > 3) {
                    throw new Exception();
                }
                pararLoop = true;
            } catch (Exception ex) {
                System.out.println("Valor inválido.");
                System.out.print("Tente novamente: ");
            }
        } while (!pararLoop);
        return numeroEscolhido;
    }

    public static void menuVideoGame() {
        System.out.println("\n============\u2694\uFE0F Medieval Battle VideoGame \u2694\uFE0F============");
        System.out.println("(1) -> Jogar Video Game");
        System.out.println("(2) -> Buscar relatório de Jogador");
        System.out.println("(3) -> Sair");
        System.out.println("=======================================================");
        System.out.print("Escolher opção: ");
    }
    public static String escolherNickname() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Nickname: ");
        String nomeDeJogador = leitor.nextLine();
        return nomeDeJogador;
    }
    public static void informacaoEscolherHeroi() {
        System.out.println("===== Heróis =====");
        System.out.println("(1) Herói -> Guerreiro");
        System.out.println("(2) Herói -> Bárbaro");
        System.out.println("(3) Herói -> Paladino");
        System.out.println("==================");
    }
    public static void jogarVideoGame() {
        Heroi metodoHeroi = new Heroi();
        Monstro metodoMonstro = new Monstro();
        Batalha metodoBatalha = new Batalha();

        System.out.println("Olá jogador, coloque o seu Nickname e qual classe de Héroi deseja escolher.");
        String nomeDeJogador = escolherNickname();
        informacaoEscolherHeroi();
        Heroi heroiDeJogador = metodoHeroi.selecionarPersonagem(metodoHeroi.escolherPersonagem());
        Monstro monstroDeBatalha = metodoMonstro.selecionarPersonagemAleatorio();

        System.out.println("Pronto jogador " + nomeDeJogador + ", sua batalha irá começar!");
        System.out.println("\nHerói escolhido: " + heroiDeJogador.toString());
        System.out.println("Monstro escolhido para a batalha: " + monstroDeBatalha.toString());
        boolean heroiAtaca = metodoBatalha.iniciarBatalha(heroiDeJogador, monstroDeBatalha);

        int rodadas = 0;
        do {
            rodadas++;
            System.out.println("\nRodada " + rodadas);
            if (heroiAtaca) {
                if (metodoBatalha.verificarAtaque(heroiDeJogador)) {
                    metodoBatalha.ataqueAoAdversario(heroiDeJogador,monstroDeBatalha);
                }
                heroiAtaca = false;
            } else {
                if (metodoBatalha.verificarAtaque(monstroDeBatalha)) {
                    metodoBatalha.ataqueAoAdversario(monstroDeBatalha,heroiDeJogador);
                }
                heroiAtaca = true;
            }
            metodoBatalha.verificarResultadoRodada(heroiDeJogador,monstroDeBatalha,rodadas);
        } while (heroiDeJogador.getPontosDeVida() > 0 && monstroDeBatalha.getPontosDeVida() > 0);
        String resultadoBatalha = metodoBatalha.resultadoBatalha(heroiDeJogador, monstroDeBatalha);
        String gravarResultado = metodoBatalha.gravarBatalha(heroiDeJogador.getClasse(),resultadoBatalha,monstroDeBatalha.getClasse(),rodadas);
        metodoBatalha.gravarBatalhaNoArquivo(nomeDeJogador,gravarResultado);
    }
    public static void buscarRelatorioJogador() {
        Batalha metodoBatalha = new Batalha();
        metodoBatalha.buscarRelatorios();
    }

}