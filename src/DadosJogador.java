import Personagens.Personagem;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DadosJogador {
    private Path caminhoDiretorio;
    private ArrayList<String> batalhas;
    private Personagem personagemMaisJogado;
    private Personagem monstroMaisEnfrentado;
    private int totalDePontos; //Sendo que a cada batalha a quantidade de pontos é dada por 100
    private int quantiadeDeRodadas;

    public DadosJogador(String nomeJogador) {
        this.caminhoDiretorio = Paths.get("src","Temp",nomeJogador+".csv");
        batalhas = new ArrayList<String>();
        verRelatorioBatalhas();
    }

    public void verRelatorioBatalhas() {
        try {
            String linha;
            InputStream inputStream = Files.newInputStream(caminhoDiretorio);
            InputStreamReader leitorArquivo = new InputStreamReader(inputStream);
            BufferedReader lerArquivo = new BufferedReader(leitorArquivo);
            linha = lerArquivo.readLine(); // Pular 1° linha
            linha = lerArquivo.readLine();
            while (linha != null) {
                batalhas.add(linha);
                linha = lerArquivo.readLine();
            }
        } catch (Exception ex) {
        }
    }


}
