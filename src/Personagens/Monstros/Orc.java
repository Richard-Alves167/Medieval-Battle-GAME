package Personagens.Monstros;

public class Orc extends Monstro {
    public Orc() {
        super.setClasse("Orc");
        super.setPontosDeVida(20);
        super.setForca(6);
        super.setDefesa(2);
        super.setAgilidade(2);
        super.setFatorDeDano("1d8");
    }
}
