package Monstros;

public class MortoVivo extends Monstro {
    int pontosDeVida = 25;
    int forca = 4;
    int defesa = 0;
    int agilidade = 1;
    String fatorDeDano = "2d4";

    public MortoVivo() {}

    @Override
    public String toString() {
        return "MortoVivo{" +
                "pontosDeVida=" + pontosDeVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", fatorDeDano='" + fatorDeDano + '\'' +
                '}';
    }
}
