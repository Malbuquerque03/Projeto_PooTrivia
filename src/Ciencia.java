import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ciencia extends Pergunta{
    protected ArrayList respostasFacil;
    protected ArrayList respostasDificil;
    protected String respostaCerta;


    public Ciencia(String pergunta, ArrayList respostasFacil, ArrayList respostasDificil, String respostaCerta) {
        super(pergunta,5);
        this.respostasFacil = respostasFacil;
        this.respostasDificil = respostasDificil;
        this.respostaCerta = respostaCerta;
    }


    //Setters
    public void setRespostasFacil(ArrayList respostasFacil) {
        this.respostasFacil = respostasFacil;
    }

    public void setRespostasDificil(ArrayList respostasDificil) {
        this.respostasDificil = respostasDificil;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    //Getters
    public ArrayList getRespostasFacil() {
        return respostasFacil;
    }

    public ArrayList getRespostasDificil() {
        return respostasDificil;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }


    //Metodos

@Override
    public int respostaAte3(){
        Collections.shuffle(respostasFacil);
        Scanner sc = new Scanner(System.in);
        for(int i=0;i< respostasFacil.size();i++){
        //    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(i+"-->"+respostasFacil.get(i));
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        int x = sc.nextInt();

        if(x>=respostasFacil.size()){
            System.out.println("+++++++RESPOSTA INVALIDA++++++");
          return respostaAte3();
        }
        else{
            if(respostasFacil.get(x).equals(respostaCerta)){
                System.out.println("ACERTOU------ " +contas()+ " pontos");
                return 1;
            }
            else{
                System.out.println("ERROU------ 0 pontos");
                return 0;
            }
        }

    }

    @Override
    public int perguntaDificil() {
        Collections.shuffle(respostasDificil);
        Scanner sc = new Scanner(System.in);
        for(int i=0;i< respostasDificil.size();i++){
          //  System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(i+"-->"+respostasDificil.get(i));
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        int x = sc.nextInt();

        if(x>=respostasDificil.size()){
            System.out.println("+++++++RESPOSTA INVALIDA++++++");
            return perguntaDificil();
        }
        else {
            if(respostasDificil.get(x).equals(respostaCerta)){
                System.out.println("ACERTOU------ " +contas()+ " pontos");
                return 1;
            }
            else{
                System.out.println("ERROU------ 0 pontos");
                return 0;
            }
        }

    }

    @Override
    public int contas() {
        int pontos=super.valorBase+super.majoracao;
        return pontos;
    }
}
