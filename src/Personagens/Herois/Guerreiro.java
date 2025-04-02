package Personagens.Herois;

public class Guerreiro extends Heroi{
    public Guerreiro() {
        super.setClasse("Guerreiro");
        super.setPontosDeVida(12);
        super.setForca(4);
        super.setDefesa(3);
        super.setAgilidade(3);
        super.setFatorDeDano("2d4");
    }
}
