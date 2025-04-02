package Herois;

public class Paladino extends Heroi{
    int pontosDeVida = 15;
    int forca = 2;
    int defesa = 5;
    int agilidade = 1;
    String fatorDeDano = "2d4";

    public Paladino() {}

    @Override
    public String toString() {
        return "Paladino{" +
                "pontosDeVida=" + pontosDeVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", fatorDeDano='" + fatorDeDano + '\'' +
                '}';
    }
}
