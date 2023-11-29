import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PooTrivia {
    public static void main(String[] args) {
       new PooTrivia();
    }
    public PooTrivia(){

        ArrayList<Jogador> jogadores= new ArrayList<>();
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        ArrayList<String> respostas = new ArrayList<>();
        GereFicheiro fich = new GereFicheiro();
        fich.readTextFile(new File("pootrivia.txt"), perguntas, respostas);
        Jogo jogo=new Jogo();
        jogo.menu(perguntas,jogadores);

        }

}