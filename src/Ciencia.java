import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ciencia extends Pergunta{
    private ArrayList<String> respostasFacil;
    private ArrayList<String> respostasDificil;
    private String respostaCerta;


    public Ciencia(String pergunta, ArrayList<String> respostasFacil, ArrayList<String> respostasDificil, String respostaCerta) {
        super(pergunta,5);
        this.respostasFacil = respostasFacil;
        this.respostasDificil = respostasDificil;
        this.respostaCerta = respostaCerta;
    }


    //Setters
    public void setRespostasFacil(ArrayList<String> respostasFacil) {
        this.respostasFacil = respostasFacil;
    }

    public void setRespostasDificil(ArrayList<String> respostasDificil) {
        this.respostasDificil = respostasDificil;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    //Getters
    public ArrayList<String> getRespostasFacil() {
        return respostasFacil;
    }

    public ArrayList<String> getRespostasDificil() {
        return respostasDificil;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }


    //Metodos

    @Override
    public boolean questionario(int jogada){
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
                    return true;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return false;
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
                    return true;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return false;
                }
            }
        }

    }


    @Override
    public ArrayList<String> getAnswers(int jogada){
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
            return getRespostasFacil().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta());

        } else {
            return getRespostasDificil().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta());
        }

    }

    @Override
    public int contas() {
        return super.getValorBase()+super.getMajoracao();
    }
}