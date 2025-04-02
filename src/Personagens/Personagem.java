package Personagens;

import java.util.Random;
import java.util.Scanner;

public class Personagem {
    String classe;
    int pontosDeVida;
    int forca;
    int defesa;
    int agilidade;
    String fatorDeDano;

    public String getClasse() {
        return classe;
    }

    protected void setClasse(String classe) {
        this.classe = classe;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    protected void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getForca() {
        return forca;
    }

    protected void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    protected void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    protected void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public String getFatorDeDano() {
        return fatorDeDano;
    }

    protected void setFatorDeDano(String fatorDeDano) {
        this.fatorDeDano = fatorDeDano;
    }

    @Override
    public String toString() {
        return classe + "{" +
                "pontosDeVida=" + pontosDeVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", fatorDeDano='" + fatorDeDano + '\'' +
                '}';
    }

    protected int receberNumeroInt() {
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
