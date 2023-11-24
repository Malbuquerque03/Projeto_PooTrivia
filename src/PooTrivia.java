import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PooTrivia {
    public static void main(String[] args) {
       new PooTrivia();
    }
    public PooTrivia(){

         ArrayList<Pergunta> perguntas = new ArrayList<>();
         ArrayList respostas =new ArrayList<>() ;

        System.out.println("---------------");
        GereFicheiro fich = new GereFicheiro();
        fich.readTextFile(new File("perguntas_poo.csv"), perguntas, respostas);


        System.out.println("---------------");


        Jogo jogo=new Jogo();
        jogo.menu(perguntas);

        }

}