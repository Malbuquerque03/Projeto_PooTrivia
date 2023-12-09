import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class PooTrivia {
    public static void main(String[] args) {
        new PooTrivia();
    }
    public PooTrivia(){

        GereGUI frame = getGereGUI();

        frame.setTitle("POO Trivia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250, 1000);
        // Impede que o utilizador redimensione a janela
        frame.setResizable(false);
        // Centraliza a janela no ecrã
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    private static GereGUI getGereGUI() {
        ArrayList<Jogador> jogadores= new ArrayList<>();
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        ArrayList<Pergunta> respostasCertas =new ArrayList<>() ;
        ArrayList<Pergunta> respostasErradas =new ArrayList<>() ;
        GereFicheiro fich = new GereFicheiro();
        fich.readTextFile(new File("perguntas_poo.csv"), perguntas);
        //Jogo jogo=new Jogo();
        //jogo.menu(perguntas,jogadores);


        return new GereGUI(perguntas,respostasCertas,respostasErradas,jogadores);
    }

}
