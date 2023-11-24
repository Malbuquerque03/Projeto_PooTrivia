import java.util.ArrayList;

public class Artes extends Pergunta {
    protected ArrayList respostas;
    protected String respostaCerta;


    public Artes( String pergunta, ArrayList respostas, String respostaCerta) {
        super( pergunta,10);
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

    public String getRespostaCerta() {
        return respostaCerta;
    }

}
