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
    private String personagemMaisJogado;
    private String monstroMaisEnfrentado;
    private int totalDePontos; //Sendo que a cada batalha a quantidade de pontos é dada por 100
    private int quantidadeDeRodadas;

    public DadosJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        this.caminhoDiretorio = Paths.get("src","Temp",nomeJogador+".csv");
        batalhas = new ArrayList<String>();
        relatorioBatalhas();
        calcularPersonagemMaisJogado();
        calcularMonstroMaisEnfrentado();
        calcularQuantidadeDePontos();
        calcularQuantidadeDeRodadas();
    }

    public void verStatusDeJogador() {
        System.out.println("=============== "+nomeJogador+" ===============");
        System.out.println(String.format("* Heroi mais jogado: %s",personagemMaisJogado));
        System.out.println(String.format("* Monstro mais enfrentado: %s",monstroMaisEnfrentado));
        System.out.println(String.format("* Quantiadade total de Pontos: %d",totalDePontos));
        System.out.println(String.format("* Quantidade de Rodadas: %d",quantidadeDeRodadas));
        System.out.println("=======================================");
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

    private void calcularPersonagemMaisJogado() {
        ArrayList<String> heroisJogados = new ArrayList<String>();
        int contagemGuerreiro = 0;
        int contagemBarbaro = 0;
        int contagemPaladino = 0;
        int maiorNumeroHeroi = 0;
        for (String batalha : batalhas) {
            String[] linha = batalha.split(",");
            heroisJogados.add(linha[1]);
        }
        for (String heroi : heroisJogados) {
            switch (heroi) {
                case "Guerreiro": {
                    contagemGuerreiro++;
                    break;
                }
                case "Bárbaro": {
                    contagemBarbaro++;
                    break;
                }
                case "Paladino": {
                    contagemPaladino++;
                    break;
                }
            }
        }
        int[] contagemHerois = {contagemGuerreiro,contagemBarbaro,contagemPaladino};
        for (int contagemHeroi : contagemHerois) {
            if (contagemHeroi > maiorNumeroHeroi) {
                maiorNumeroHeroi = contagemHeroi;
            }
        }
        if (maiorNumeroHeroi == contagemGuerreiro) {
            personagemMaisJogado = "Guerreiro";
        } else if (maiorNumeroHeroi == contagemBarbaro) {
            personagemMaisJogado = "Bárbaro";
        } else if (maiorNumeroHeroi == contagemPaladino) {
            personagemMaisJogado = "Paladino";
        }
    }

    private void calcularMonstroMaisEnfrentado() {
        ArrayList<String> monstrosEnfrentados = new ArrayList<String>();
        int contagemMortoVivo = 0;
        int contagemOrc = 0;
        int contagemKobold = 0;
        int maiorNumeroMonstro = 0;
        for (String batalha : batalhas) {
            String[] linha = batalha.split(",");
            monstrosEnfrentados.add(linha[1]);
        }
        for (String monstro : monstrosEnfrentados) {
            switch (monstro) {
                case "Morto Vivo": {
                    contagemMortoVivo++;
                    break;
                }
                case "Orc": {
                    contagemOrc++;
                    break;
                }
                case "Kobold": {
                    contagemKobold++;
                    break;
                }
            }
        }
        int[] contagemMonstros = {contagemMortoVivo,contagemOrc,contagemKobold};
        for (int contagemMonstro : contagemMonstros) {
            if (contagemMonstro > maiorNumeroMonstro) {
                maiorNumeroMonstro = contagemMonstro;
            }
        }
        if (maiorNumeroMonstro == contagemMortoVivo) {
            monstroMaisEnfrentado = "Morto Vivo";
        } else if (maiorNumeroMonstro == contagemOrc) {
            monstroMaisEnfrentado = "Orc";
        } else if (maiorNumeroMonstro == contagemKobold) {
            monstroMaisEnfrentado = "Kobold";
        }
    }

    private void calcularQuantidadeDeRodadas() {
        for (String batalha : batalhas) {
            String[] linha = batalha.split(",");
            quantidadeDeRodadas += Integer.parseInt(linha[4]);
        }
    }
}
