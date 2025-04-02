package Herois;

public class Guerreiro extends Heroi{
    int pontosDeVida = 12;
    int forca = 4;
    int defesa = 3;
    int agilidade = 3;
    String fatorDeDano = "2d4";

    public Guerreiro() {}

    @Override
    public String toString() {
        return "Guerreiro{" +
                "pontosDeVida=" + pontosDeVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", fatorDeDano='" + fatorDeDano + '\'' +
                '}';
    }
}
