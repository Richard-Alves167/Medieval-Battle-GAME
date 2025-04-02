package Herois;

import Monstros.Kobold;
import Monstros.Monstro;
import Monstros.MortoVivo;
import Monstros.Orc;

import java.util.Scanner;

public class Heroi {
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
        return monstroSelecionado;
    }



    private int receberNumeroInt() {
        Scanner leitor;
        boolean pararLoop = false;
        int numero = 0;
        do {
            try {
                leitor = new Scanner(System.in);
                numero = leitor.nextInt();
                pararLoop = true;
            } catch (Exception ex) {
                System.out.println("Erro: Somente receber números!");
                System.out.print("Tente novamente: ");
            }
        } while (!pararLoop);
        return numero;
    }
}
