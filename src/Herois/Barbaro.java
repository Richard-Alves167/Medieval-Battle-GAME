package Herois;

public class Barbaro extends Heroi {
    int pontosDeVida = 13;
    int forca = 6;
    int defesa = 1;
    int agilidade = 3;
    String fatorDeDano = "2d6";

    public Barbaro() {}

    @Override
    public String toString() {
        return "Barbaro{" +
                "pontosDeVida=" + pontosDeVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", fatorDeDano='" + fatorDeDano + '\'' +
                '}';
    }
}
