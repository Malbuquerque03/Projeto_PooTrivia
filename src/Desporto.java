import java.util.ArrayList;

public class Desporto extends Pergunta {
    protected int majoracaoD;

    public Desporto(String pergunta,int majoracaoD) {
        super(pergunta,3);
        this.majoracaoD=majoracaoD;
    }

    //Setter
    public void setMajoracaoD(int majoracaoD) { this.majoracaoD = majoracaoD; }


    //Getter
    public int getMajoracaoD() {
        return majoracaoD;
    }



    //Metodos

    public boolean checkAnswer(String respostaSelecionada,int jogada){return false;}

    @Override
    public boolean questionario(int jogada){ return false; }

    @Override
    public ArrayList<String> getAnswers(int jogada){return null;}
}