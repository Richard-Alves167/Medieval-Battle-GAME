import Personagens.Herois.Heroi;
import Personagens.Monstros.Monstro;
import Personagens.Personagem;

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

    public int ataquePersonagem(Personagem personagem) {
        if (verificarAtaque(personagem)) {
            System.out.println(personagem.getClass() + ": Pronto para atacar!");
            return calularDano(personagem);
        }
        return 0;
    }

    public void ataqueAoAdversario(Personagem atacaAdversario,Personagem recebeOAtaque) {
        System.out.println(atacaAdversario.getClasse() + " atacou o " + recebeOAtaque.getClasse());
        int dano = calularDano(atacaAdversario);
        recebeOAtaque.receberAtaque(dano);
        System.out.println(atacaAdversario.getClasse() + " atacou com " + dano + " de dano ao " + recebeOAtaque.getClasse());
    }
}

