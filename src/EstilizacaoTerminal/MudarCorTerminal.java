package EstilizacaoTerminal;

public class MudarCorTerminal {
    CorTerminal cores;
    public String corVerde(String mensagem) {
        return cores.VERDE.codigo+mensagem+cores.RESETAR.codigo;
    }
    public String corVermelha(String mensagem) {
        return cores.VERMELHO.codigo+mensagem+cores.RESETAR.codigo;
    }
    public String corAmarelo(String mensagem) {
        return cores.AMARELO.codigo+mensagem+cores.RESETAR.codigo;
    }
    public String corAzul(String mensagem) {
        return cores.AZUL.codigo+mensagem+cores.RESETAR.codigo;
    }
}
