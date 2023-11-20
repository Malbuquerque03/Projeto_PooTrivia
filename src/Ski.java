import java.util.ArrayList;

public class Ski extends Desporto{
    protected int majoracaoS;
    protected boolean respostaCerta;


    public Ski(String pergunta, boolean dificuldade, boolean respostaCerta) {
        super(pergunta, dificuldade);
        setMajoracaoS();
        this.respostaCerta = respostaCerta;
    }
jehgkjrdhnlkerjgekjr

    //Setters

    public void setMajoracaoS() {
        this.majoracaoS = 2;
    }

    public void setRespostaCerta(boolean respostaCerta) {
        this.respostaCerta = respostaCerta;
    }


    //Getters


    public int getMajoracaoS() {
        return majoracaoS;
    }

    public boolean isRespostaCerta() {
        return respostaCerta;
    }
}
