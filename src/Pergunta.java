import java.util.ArrayList;

public class Pergunta {
    protected int valorBase;
    protected String pergunta;
    protected boolean dificuldade;

    public Pergunta(String pergunta, boolean dificuldade) {
        setValorBase();
        this.pergunta = pergunta;
        this.dificuldade = dificuldade;
    }


    //Setters
    public void setValorBase() {
        this.valorBase = 5;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setDificuldade(boolean dificuldade) {
        this.dificuldade = dificuldade;
    }



    //Getters
    public int getValorBase() {
        return valorBase;
    }

    public String getPergunta() {
        return pergunta;
    }

    public boolean isDificuldade() {
        return dificuldade;
    }
}
