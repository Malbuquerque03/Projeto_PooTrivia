import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Natacao extends Desporto{
    protected ArrayList<String> respostas;
    protected String respostaCerta;


    public Natacao(String pergunta, ArrayList<String> respostas,String respostaCerta) {
        super(pergunta,10);
        this.respostas=respostas;
        this.respostaCerta = respostaCerta;
    }


    //Setters

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    //Getters

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    //Metodos


    @Override
    public boolean questionario(int jogada){
        Collections.shuffle(getRespostas());
        Scanner sc = new Scanner(System.in);
        for(int i=0;i< getRespostas().size();i++){
            // System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(i+"-->"+respostas.get(i));
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        int x = sc.nextInt();
        if(x>=getRespostas().size()){
            System.out.println("+++++++RESPOSTA INVALIDA++++++");
            return questionario(jogada);
        }
        else{
            if(respostas.get(x).equals(respostaCerta)){
                System.out.println("ACERTOU------ " +contas()+ " pontos");
                return true;
            }
            else{
                System.out.println("ERROU------ 0 pontos");
                return false;
            }
        }

    }
    @Override
    public ArrayList<String> getAnswers(int jogada){
        Collections.shuffle(getRespostas());
        return(getRespostas());
    }

    @Override
    public boolean checkAnswer(String respostaSelecionada,int jogada){
        if(getRespostas().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta())){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public int contas() {
        int pontos= super.valorBase+super.majoracao+getMajoracaoD();
        return pontos;
    }
}