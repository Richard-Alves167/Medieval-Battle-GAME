import Personagens.Herois.Heroi;
import Personagens.Monstros.Monstro;
import Personagens.Personagem;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Random aleatorio = new Random();
        Heroi metodoHeroi = new Heroi();
        Monstro metodoMonstro = new Monstro();
        Batalha metodoBatalha = new Batalha();

        System.out.println("=============== Medieval Battle VideoGame ===============");
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
        metodoBatalha.gravarBatalha(heroiDeJogador.getClasse(),resultadoBatalha,monstroDeBatalha.getClasse(),rodadas);
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
}