public class Desporto extends Pergunta {
    protected int majoracaoD;

    public Desporto(String pergunta, boolean dificuldade) {
        super(pergunta, dificuldade);
        setMajoracaoD();
    }

    //Setter
    public void setMajoracaoD() {
        this.majoracaoD = 3;
    }

    //Getter


    public int getMajoracaoD() {
        return majoracaoD;
    }
}
