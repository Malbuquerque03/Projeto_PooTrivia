import java.util.ArrayList;

public class Ski extends Desporto{
    protected ArrayList respostas;
    protected String respostaCerta;


    public Ski(String pergunta, ArrayList respostas, String respostaCerta) {
        super(pergunta, 2);
        this.respostas = respostas;
        this.respostaCerta = respostaCerta;
    }

    //Setters
    public void setRespostas(ArrayList respostas) {
        this.respostas = respostas;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }


    //Getters
    public ArrayList getRespostas() {
        return respostas;
    }

    public String getespostaCerta() {return respostaCerta; }
}
