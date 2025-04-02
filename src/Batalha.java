import Personagens.Herois.Heroi;
import Personagens.Monstros.Monstro;

import java.util.Random;

public class Batalha {
    private int rolarDadoInicializacaoDeBatalha(int fatorAgiligade) {
        Random aleatorio = new Random();
        int dado10Lados = aleatorio.nextInt(1,10);
        int calculoIniciativa = dado10Lados + fatorAgiligade;
        return calculoIniciativa;
    }

    public boolean iniciarBatalha(Heroi heroiEscolhido, Monstro monstroEscolhido) {
        int valorHeroi;
        int valorMonstro;
        boolean valorResultante;

        do {
            System.out.println("Rolando os dados...");
            valorHeroi = rolarDadoInicializacaoDeBatalha(heroiEscolhido.getAgilidade());
            valorMonstro = rolarDadoInicializacaoDeBatalha(monstroEscolhido.getAgilidade());
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
}
