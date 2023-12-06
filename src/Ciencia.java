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
    public int questionario(int jogada){
        Collections.shuffle(getRespostasFacil());
        Collections.shuffle(getRespostasDificil());
        Scanner sc = new Scanner(System.in);
        if(jogada<3){
            for(int i=0;i< getRespostasFacil().size();i++){
                //    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(i+"-->"+respostasFacil.get(i));
                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
            int x = sc.nextInt();

            if(x>=getRespostasFacil().size()){
                System.out.println("+++++++RESPOSTA INVALIDA++++++");
                return questionario(jogada);
            }
            else{
                if(getRespostasFacil().get(x).equals(getRespostaCerta())){
                    System.out.println("ACERTOU------ " +contas()+ " pontos");
                    return 1;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return 0;
                }
            }
        }

        else{
            for(int i=0;i< getRespostasDificil().size();i++){
                //  System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(i+"-->"+getRespostasDificil().get(i));
                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
            int x = sc.nextInt();

            if(x>=getRespostasDificil().size()){
                System.out.println("+++++++RESPOSTA INVALIDA++++++");
                return questionario(jogada);
            }
            else {
                if(getRespostasDificil().get(x).equals(getRespostaCerta())){
                    System.out.println("ACERTOU------ " +contas()+ " pontos");
                    return 1;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return 0;
                }
            }
        }

    }

    
    @Override
    public ArrayList getAnswers(int jogada){
        if(jogada<3){
            Collections.shuffle(getRespostasFacil());
            return getRespostasFacil();
        }
        else{
            Collections.shuffle(getRespostasDificil());
            return getRespostasDificil();
        }
    }

    @Override
    public boolean checkAnswer(String respostaSelecionada,int jogada){
        if (jogada < 3) {
            if(getRespostasFacil().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta())){
                return true;
            }
            else{
                return false;
            }

        } else {
            if (getRespostasDificil().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta())) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public int contas() {
        int pontos=super.valorBase+super.majoracao;
        return pontos;
    }
}
