package Personagens.Monstros;

public class Kobold extends Monstro {
    public Kobold() {
        super.setClasse("Kobold");
        super.setPontosDeVida(20);
        super.setForca(4);
        super.setDefesa(2);
        super.setAgilidade(4);
        super.setFatorDeDano("3d2");
    }
}
