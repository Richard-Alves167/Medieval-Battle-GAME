package Monstros;

public class Kobold extends Monstro {
    int pontosDeVida = 20;
    int forca = 4;
    int defesa = 2;
    int agilidade = 4;
    String fatorDeDano = "3d2";

    public Kobold() {}

    @Override
    public String toString() {
        return "Kobold{" +
                "pontosDeVida=" + pontosDeVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", fatorDeDano='" + fatorDeDano + '\'' +
                '}';
    }
}
