import java.util.ArrayList;

public class Futebol extends Desporto{
    protected int majoracaoF;
    protected ArrayList respostasFacil;
    protected ArrayList respostasDificil;
    protected String respostaCerta;

    public Futebol(String pergunta, boolean dificuldade, ArrayList respostasFacil, ArrayList respostasDificil, String respostaCerta) {
        super(pergunta, dificuldade);
       setMajoracaoF();
        this.respostasFacil = respostasFacil;
        this.respostasDificil = respostasDificil;
        this.respostaCerta = respostaCerta;
    }


    //Setters
    public void setMajoracaoF() {
        this.majoracaoF = 1;
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

    public int getMajoracaoF() {
        return majoracaoF;
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
