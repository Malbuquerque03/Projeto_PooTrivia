import java.util.ArrayList;

public class Pergunta {
    protected int valorBase;
    protected String pergunta;

    protected int majoracao;

    public Pergunta(String pergunta) {
        setValorBase();
        this.pergunta = pergunta;
    }

    public Pergunta( String pergunta, int majoracao) {
        setValorBase();
        this.pergunta = pergunta;
        this.majoracao = majoracao;
    }

    //Setters
    public void setValorBase() {
        this.valorBase = 5;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }




    //Getters
    public int getValorBase() {
        return valorBase;
    }

    public String getPergunta() {
        return pergunta;
    }



    //Metodos

    public ArrayList getEasyAnswer(){return null;}
    public ArrayList getHardAnswer(){return null;}

    public int respostaAte3(){ return 2; }

    public int perguntaDificil(){ return 2; }

    public int contas(){ return 2; }
    public String respostaCerta(int jogador){ return null; }
}
