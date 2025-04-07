import Personagens.Personagem;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DadosJogador {
    private String nomeJogador;
    private Path caminhoDiretorio;
    private ArrayList<String> batalhas;
    private Personagem personagemMaisJogado;
    private Personagem monstroMaisEnfrentado;
    private int totalDePontos; //Sendo que a cada batalha a quantidade de pontos é dada por 100
    private int quantidadeDeRodadas;

    public DadosJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        this.caminhoDiretorio = Paths.get("src","Temp",nomeJogador+".csv");
        batalhas = new ArrayList<String>();
        relatorioBatalhas();
        calcularQuantidadeDePontos();
    }

    public void verStatusDeJogador() {
        System.out.println("=============== "+nomeJogador+" ===============");
        System.out.println(String.format("* Heroi mais jogado: %s",personagemMaisJogado));
        System.out.println(String.format("* Monstro mais enfrentado: %s",monstroMaisEnfrentado));
        System.out.println(String.format("* Quantiadade total de Pontos: %d",totalDePontos));
        System.out.println(String.format("* Quantidade de Rodadas: %d",quantidadeDeRodadas));
        System.out.println("===============================================");
    }

    private void relatorioBatalhas() {
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

    private void calcularQuantidadeDePontos() {
        for (String batalha : batalhas) {
            String[] linha = batalha.split(",");
            if (linha[2].equals("GANHOU")) {
                totalDePontos += 100 - Integer.parseInt(linha[4]);
            }
        }
    }

}
