package Monstros;

public class Orc extends Monstro {
    int pontosDeVida = 20;
    int forca = 6;
    int defesa = 2;
    int agilidade = 2;
    String fatorDeDano = "1d8";

    public Orc() {}

    @Override
    public String toString() {
        return "Orc{" +
                "pontosDeVida=" + pontosDeVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", fatorDeDano='" + fatorDeDano + '\'' +
                '}';
    }
}
