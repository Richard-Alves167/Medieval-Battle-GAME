package Personagens.Herois;

import Personagens.Personagem;

import java.util.Scanner;

public class Heroi extends Personagem {
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
        return escolhaUsuario;
    }
    public Heroi selecionarPersonagem(int numeroEscolhido) {
        Heroi monstroSelecionado = null;
        switch (numeroEscolhido) {
            case 1: {
                monstroSelecionado = new Guerreiro();
                break;
            }
            case 2: {
                monstroSelecionado = new Barbaro();
                break;
            }
            case 3: {
                monstroSelecionado = new Paladino();
                break;
            }
        }
        System.out.println("Configurando Classe...");
        return monstroSelecionado;
    }
}
