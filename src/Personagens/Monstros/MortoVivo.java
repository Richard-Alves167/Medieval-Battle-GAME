package Personagens.Monstros;

public class MortoVivo extends Monstro {
    public MortoVivo() {
        super.setClasse("Morto Vivo");
        super.setPontosDeVida(25);
        super.setForca(4);
        super.setDefesa(0);
        super.setAgilidade(1);
        super.setFatorDeDano("2d4");
    }
}
