import java.util.ArrayList;

public class Artes extends Pergunta {
    protected int majoracaoA;
    protected ArrayList respostas;
    protected String respostaCerta;


    public Artes( String pergunta, boolean dificuldade, int majoracaoA, ArrayList respostas, String respostaCerta) {
        super( pergunta, dificuldade);
        this.majoracaoA = majoracaoA;
        this.respostas = respostas;
        this.respostaCerta = respostaCerta;
    }


    //Setters
    public void setMajoracaoA(int majoracaoA) {
        this.majoracaoA = 10;
    }

    public void setRespostas(ArrayList respostas) {
        this.respostas = respostas;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    //Getters


    public int getMajoracaoA() {
        return majoracaoA;
    }

    public ArrayList getRespostas() {
        return respostas;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }
}
