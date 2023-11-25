import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Artes extends Pergunta {
    protected ArrayList respostas;
    protected String respostaCerta;


    public Artes( String pergunta, ArrayList respostas, String respostaCerta) {
        super( pergunta,10);
        this.respostas = respostas;
        this.respostaCerta = respostaCerta;
    }


    //Setters


    public void setRespostas(ArrayList respostas) {
        this.respostas = respostas;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    //Getters




    public ArrayList getRespostas() {
        return respostas;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }


    //Metodos

    @Override
    public int respostaAte3(){
        Collections.shuffle(respostas);
        Scanner sc = new Scanner(System.in);
        for(int i=0;i< respostas.size();i++){
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(i+"-->"+respostas.get(i));
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        int x = sc.nextInt();

        if(respostas.get(x).equals(respostaCerta)){
            System.out.println("ACERTOU------ " +super.valorBase+super.majoracao+ " pontos");
            return 1;
        }
        else{
            System.out.println("ERROU------ 0 pontos");
            return 0;
        }
    }

}
