import Herois.Heroi;
import Monstros.Monstro;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Random aleatorio = new Random();
        Heroi metodoHeroi = new Heroi();
        Monstro metodoMonstro = new Monstro();
        System.out.println("=============== Medieval Battle VideoGame ===============");
        System.out.println("Olá jogador, coloque o seu Nickname e qual classe de Héroi deseja escolher.");

        System.out.print("Nickname: ");
        String nomeDeJogador = leitor.nextLine();

        System.out.println("===== Heróis =====");
        System.out.println("(1) Herói -> Guerreiro");
        System.out.println("(2) Herói -> Bárbaro");
        System.out.println("(3) Herói -> Paladino");
        System.out.println("==================");

        int classeHeroiDeJogador = metodoHeroi.escolherPersonagem();
        Heroi heroiDeJogador = metodoHeroi.selecionarPersonagem(classeHeroiDeJogador);
        System.out.println("Configurando Classe...");
        Monstro monstroDeBatalha = metodoMonstro.selecionarPersonagemAleatorio();
        System.out.println("Pronto jogador " + nomeDeJogador + ", sua batalha irá começar!");
        System.out.println("Herói escolhido: " + heroiDeJogador.toString());
        System.out.println("Monstro escolhido para a batalha: " + monstroDeBatalha.toString());
    }

    public int receberNumeroInt() {
        Scanner leitor;
        int numero = 0;
        do {
            try {
                leitor = new Scanner(System.in);
                numero = leitor.nextInt();
            } catch (Exception ex) {
                System.out.println("Somente receber números.");
            }
        } while (numero == 0);
        return numero;
    }

}