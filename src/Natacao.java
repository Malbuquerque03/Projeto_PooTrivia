import java.util.ArrayList;

public class Natacao extends Desporto{
    protected int majoracaoN;
    protected boolean respostaCerta;


    public Natacao(String pergunta, boolean dificuldade, boolean respostaCerta) {
        super(pergunta, dificuldade);
       setMajoracaoN();
        this.respostaCerta = respostaCerta;
    }


    //Setters

    public void setMajoracaoN() {
        this.majoracaoN = 10;
    }

    public void setRespostaCerta(boolean respostaCerta) {
        this.respostaCerta = respostaCerta;
    }
}
