import java.util.Random;

public class Dado {
    public int rolarDado(int quantidadeDeLados) {
        Random aleatorio = new Random();
        int dado = aleatorio.nextInt(1,quantidadeDeLados);
        return dado;
    }
    public int rolarDado10Lados() {
        Random aleatorio = new Random();
        int dado10Lados = aleatorio.nextInt(1,10);
        return dado10Lados;
    }
}
