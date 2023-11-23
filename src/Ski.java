import java.util.ArrayList;

public class Ski extends Desporto{
    protected int majoracaoS;
    protected ArrayList respostas;
    protected String respostaCerta;


    public Ski(String pergunta, ArrayList respostas, String respostaCerta) {
        super(pergunta);
        setMajoracaoS();
        this.respostaCerta = respostaCerta;
    }



    //Setters

    public void setMajoracaoS() {
        this.majoracaoS = 2;
    }
    public void setRespostas(ArrayList respostas) {
        this.respostas = respostas;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }


    //Getters


    public int getMajoracaoS() {
        return majoracaoS;
    }
    public ArrayList getRespostas() {
        return respostas;
    }

    public String getespostaCerta() {return respostaCerta; }
}
