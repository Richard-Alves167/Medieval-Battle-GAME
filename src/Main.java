import Personagens.Herois.Heroi;
import Personagens.Monstros.Monstro;
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
        System.out.println("\nHerói escolhido: " + heroiDeJogador.toString());
        System.out.println("Monstro escolhido para a batalha: " + monstroDeBatalha.toString());
        System.out.println("\nPara iniciar a batalha, iremos ver quem terá o maior número, rolando o dado de inicialização (10 lados) com mais o número de agilidade do personagem.");
        boolean heroiAtaca = metodoBatalha.iniciarBatalha(heroiDeJogador, monstroDeBatalha);

        int rodadas = 1;
        do {
            System.out.println("\nRodada " + rodadas);
            if (heroiAtaca) {
                if (metodoBatalha.verificarAtaque(heroiDeJogador)) {
                    System.out.println("Você atacou o " + monstroDeBatalha.getClasse());
                    int dano = metodoBatalha.calularDano(heroiDeJogador);
                    monstroDeBatalha.receberAtaque(dano);
                    System.out.println("Você atacou com " + dano + " de dano ao " + monstroDeBatalha.getClasse());

                } else {

                }
                heroiAtaca = false;
            } else {
                if (metodoBatalha.verificarAtaque(monstroDeBatalha)) {
                    System.out.println("O " + monstroDeBatalha.getClasse() + " inflingiu dano a você");
                    int dano = metodoBatalha.calularDano(monstroDeBatalha);
                    heroiDeJogador.receberAtaque(dano);
                    System.out.println("Você recebeu um ataque de " + dano + " dano de " + monstroDeBatalha.getClasse());
                }
                heroiAtaca = true;
            }
            rodadas++;
        } while (heroiDeJogador.getPontosDeVida() >= 0 && monstroDeBatalha.getPontosDeVida() >= 0);
        System.out.println("\nFim da batalha!");
        if (heroiDeJogador.getPontosDeVida() <= 0) {
            System.out.println("Você perdeu!");
        } else {
            System.out.println("Você derrotou o monstro! Parabéns!");
        }
    }
}