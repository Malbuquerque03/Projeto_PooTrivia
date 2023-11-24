public class Desporto extends Pergunta {
    protected int majoracaoD;

    public Desporto(String pergunta,int majoracaoD) {
        super(pergunta,3);
        this.majoracaoD=majoracaoD;
    }

    //Setter
    public void setMajoracaoD(int majoracaoD) { this.majoracaoD = majoracaoD; }


    //Getter
    public int getMajoracaoD() {
        return majoracaoD;
    }



    //Metodos

    @Override
    public int respostaAte3(){
        return 3;
    }
}
