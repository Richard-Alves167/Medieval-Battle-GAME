package EstilizacaoTerminal;

public enum CorTerminal {
    RESETAR("\u001B[0m"),
    VERMELHO("\u001B[31m"),
    VERDE("\u001B[32m"),
    AMARELO("\u001B[33m"),
    AZUL("\u001B[34m");

    CorTerminal (String codigo){
    }
}
