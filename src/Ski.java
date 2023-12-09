import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ski extends Desporto{
    private ArrayList<String> respostas;
    private String respostaCerta;


    public Ski(String pergunta, ArrayList<String> respostas, String respostaCerta) {
        super(pergunta, 2);
        this.respostas = respostas;
        this.respostaCerta = respostaCerta;
    }

    //Setters
    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }


    //Getters
    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public String getRespostaCerta() {return respostaCerta; }



    //Metodos

    @Override
    public boolean questionario(int jogada){
        Collections.shuffle(getRespostas());
        Scanner sc = new Scanner(System.in);
        for(int i=0;i< getRespostas().size();i++){
            // System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(i+"-->"+getRespostas().get(i));
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        int x = sc.nextInt();

        if(x>=getRespostas().size()){
            System.out.println("+++++++RESPOSTA INVALIDA++++++");
            return questionario(jogada);
        }
        else{
            if(getRespostas().get(x).equals(getRespostaCerta())){
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
        return getRespostas().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta());
    }

    @Override
    public int contas() {
        return super.getValorBase()+super.getMajoracao()*getMajoracaoD();
    }
}
