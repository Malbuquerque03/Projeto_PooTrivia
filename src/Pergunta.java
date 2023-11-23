import java.util.ArrayList;

public class Pergunta {
    protected int valorBase;
    protected String pergunta;

    public Pergunta(String pergunta) {
        setValorBase();
        this.pergunta = pergunta;
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

}
