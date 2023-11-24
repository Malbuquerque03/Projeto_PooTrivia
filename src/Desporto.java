public class Desporto extends Pergunta {
    protected int majoracao;

    public Desporto(String pergunta,int majoracao) {
        super(pergunta,3);
        this.majoracao=majoracao;
    }

    //Setter
    public void setMajoracao(int majoracao) { this.majoracao = majoracao; }


    //Getter
    public int getMajoracao() {
        return majoracao;
    }
}
