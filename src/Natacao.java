import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Natacao extends Desporto{
    protected ArrayList<String> respostas;
    protected String respostaCerta;


    public Natacao(String pergunta, ArrayList respostas,String respostaCerta) {
        super(pergunta,10);
        this.respostas=respostas;
        this.respostaCerta = respostaCerta;
    }


    //Setters

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public void setRespostas(ArrayList respostas) {
        this.respostas = respostas;
    }

    //Getters
    public String getespostaCerta() {return respostaCerta; }



    //Metodos
    @Override
    public ArrayList getEasyAnswer(){
        Collections.shuffle(respostas);
        return(respostas);
    }

    @Override
    public int respostaAte3(){
        Collections.shuffle(respostas);
        Scanner sc = new Scanner(System.in);
        for(int i=0;i< respostas.size();i++){
            // System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(i+"-->"+respostas.get(i));
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        int x = sc.nextInt();
        if(x>=respostas.size()){
            System.out.println("+++++++RESPOSTA INVALIDA++++++");
            return respostaAte3();
        }
        else{
            if(respostas.get(x).equals(respostaCerta)){
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
    public ArrayList getHardAnswer(){
        return getEasyAnswer();
    }
    @Override
    public int perguntaDificil(){
        return  respostaAte3();
    }

    @Override
    public int contas() {
        int pontos= super.valorBase+super.majoracao+getMajoracaoD();
        return pontos;
    }
    @Override
    public String respostaCerta(int jogador) {
        return getespostaCerta();
    }
}
