package Personagens.Herois;

public class Barbaro extends Heroi {
    public Barbaro() {
        super.setClasse("Bárbaro");
        super.setPontosDeVida(13);
        super.setForca(6);
        super.setDefesa(1);
        super.setAgilidade(3);
        super.setFatorDeDano("2d6");
    }
}
