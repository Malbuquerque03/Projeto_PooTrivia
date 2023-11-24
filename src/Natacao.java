import java.util.ArrayList;

public class Natacao extends Desporto{
    protected ArrayList respostas;
    protected String respostaCerta;


    public Natacao(String pergunta, ArrayList respostas,String respostaCerta) {
        super(pergunta,10);
       this.respostas=respostas;
        this.respostaCerta = respostaCerta;
    }


    //Setters

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public void setRespostas(ArrayList respostas) {
        this.respostas = respostas;
    }

    //Getters
    public String getespostaCerta() {return respostaCerta; }
}
