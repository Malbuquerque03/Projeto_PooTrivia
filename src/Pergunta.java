import java.io.Serializable;
import java.util.ArrayList;

public class Pergunta implements Serializable {
    private int valorBase;
    private String pergunta;

    private int majoracao;

    public Pergunta( String pergunta, int majoracao) {
        setValorBase();
        this.pergunta = pergunta;
        this.majoracao = majoracao;
    }

    //Setters
    public void setValorBase() {
        this.valorBase = 5;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }




    //Getters
    public int getValorBase() {
        return valorBase;
    }

    public String getPergunta() {
        return pergunta;
    }

    public int getMajoracao() { return majoracao;}
    //Metodos

    public boolean checkAnswer(String respostaSelecionada,int jogada){return false;}

    public boolean questionario(int jogada){ return false; }

    public ArrayList<String> getAnswers(int jogada){return null;}

    public int contas(){ return 2; }
}