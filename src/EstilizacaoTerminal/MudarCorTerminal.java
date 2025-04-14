package EstilizacaoTerminal;

public class MudarCorTerminal {
    CorTerminal cores;
    public void corVerde(String mensagem) {
        System.out.println(cores.VERDE+mensagem+cores.RESETAR);
    }
    public void corVermelha(String mensagem) {
        System.out.println(cores.VERMELHO+mensagem+cores.RESETAR);
    }
    public void corAmarelo(String mensagem) {
        System.out.println(cores.AZUL+mensagem+cores.RESETAR);
    }
    public void corAzul(String mensagem) {
        System.out.println(cores.AZUL+mensagem+cores.RESETAR);
    }
}
