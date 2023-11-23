import java.util.ArrayList;

public class Ciencia extends Pergunta{
    protected int majoracaoC;
    protected ArrayList respostasFacil;
    protected ArrayList respostasDificil;
    protected String respostaCerta;


    public Ciencia(String pergunta, ArrayList respostasFacil, ArrayList respostasDificil, String respostaCerta) {
        super(pergunta);
        setMajoracaoC();
        this.respostasFacil = respostasFacil;
        this.respostasDificil = respostasDificil;
        this.respostaCerta = respostaCerta;
    }


    //Setters


    public void setMajoracaoC() {
        this.majoracaoC = 5;
    }

    public void setRespostasFacil(ArrayList respostasFacil) {
        this.respostasFacil = respostasFacil;
    }

    public void setRespostasDificil(ArrayList respostasDificil) {
        this.respostasDificil = respostasDificil;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    //Getters

    public int getMajoracaoC() {
        return majoracaoC;
    }

    public ArrayList getRespostasFacil() {
        return respostasFacil;
    }

    public ArrayList getRespostasDificil() {
        return respostasDificil;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }
}
