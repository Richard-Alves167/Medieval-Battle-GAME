package Personagens.Herois;

public class Paladino extends Heroi{
    public Paladino() {
        super.setClasse("Paladino");
        super.setPontosDeVida(15);
        super.setForca(2);
        super.setDefesa(5);
        super.setAgilidade(1);
        super.setFatorDeDano("2d4");
    }
}
