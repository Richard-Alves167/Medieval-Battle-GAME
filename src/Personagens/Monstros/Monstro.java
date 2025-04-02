package Personagens.Monstros;
import Personagens.Personagem;

import java.util.Random;
import java.util.Scanner;

public class Monstro extends Personagem {
    public int escolherPersonagem() {
        boolean pararLoop = false;
        int escolhaUsuario = 0;
        do {
            try {
                System.out.print("Classe de Herói: ");
                escolhaUsuario = receberNumeroInt();
                if (escolhaUsuario < 1 || escolhaUsuario > 3) {
                    throw new Exception("Opção inválida!");
                }
                pararLoop = true;
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
                System.out.println("Tente novamente...");
            }
        } while (!pararLoop);
        return 0;
    }
    public Monstro selecionarPersonagem(int numeroEscolhido) {
        Monstro monstroSelecionado = null;
        switch (numeroEscolhido) {
            case 1: {
                monstroSelecionado = new MortoVivo();
                break;
            }
            case 2: {
                    monstroSelecionado = new Orc();
                break;
            }
            case 3: {
                    monstroSelecionado = new Kobold();
                break;
            }
        }
        return monstroSelecionado;
    }
    public Monstro selecionarPersonagemAleatorio() {
        Random aleatorio = new Random();
        int numeroEscolhido = aleatorio.nextInt(1,3);
        Monstro monstroSelecionado = null;
        switch (numeroEscolhido) {
            case 1: {
                monstroSelecionado = new MortoVivo();
                break;
            }
            case 2: {
                monstroSelecionado = new Orc();
                break;
            }
            case 3: {
                monstroSelecionado = new Kobold();
                break;
            }
        }
        return monstroSelecionado;
    }
}
