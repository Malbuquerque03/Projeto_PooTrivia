import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Artes extends Pergunta {
    protected ArrayList<String> respostas;
    protected String respostaCerta;


    public Artes( String pergunta, ArrayList<String> respostas, String respostaCerta) {
        super( pergunta,10);
        this.respostas = respostas;
        this.respostaCerta = respostaCerta;
    }


    //Setters


    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    //Getters




    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }


    //Metodos



    @Override
    public int questionario(int jogada){

        Scanner sc = new Scanner(System.in);

        if(jogada<3){
            ArrayList<String> resp= new ArrayList();
            for (String resposta : respostas.subList(1, respostas.size())) {
                resp.add(resposta);
            }

            Collections.shuffle(resp);

            resp = new ArrayList<>(resp.subList(0, resp.size() / 2));

            resp.add(getRespostas().get(0));
            Collections.shuffle(resp);

            for(Object r: resp){
                System.out.println(resp.indexOf(r)+"-->"+r);
                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }

            int x = sc.nextInt();

            if(x>=resp.size()){
                System.out.println("RESPOSTA INVALIDA");
                return questionario(jogada);
            }
            else{
                if(resp.get(x).equals(respostaCerta)){
                    System.out.println("ACERTOU------ " +contas()+ " pontos");
                    return 1;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return 0;
                }
            }

        }
        else {
            Collections.shuffle(respostas);
            for(int i=0;i< getRespostas().size();i++){
                //   System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(i+"-->"+respostas.get(i));
                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
            int x = sc.nextInt();

            if(x>=getRespostas().size()){
                System.out.println("RESPOSTA INVALIDA");
                return questionario(jogada);
            }
            else{
                if(getRespostas().get(x).equals(getRespostaCerta())){
                    System.out.println("ACERTOU------ " +contas()+ " pontos");
                    return 1;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return 0;
                }
            }

        }

    }

    @Override
    public ArrayList getAnswers(int jogada){
        if(jogada<3){
            ArrayList<String> resp= new ArrayList();
            for (String resposta : getRespostas().subList(1, getRespostas().size())) {
                resp.add(resposta);
            }
            Collections.shuffle(resp);
            resp = new ArrayList<>(resp.subList(0, 2));
            resp.add(getRespostas().get(0));
            Collections.shuffle(resp);
            return resp;

        }

        else{
            Collections.shuffle(getRespostas());
            return(getRespostas());
        }

    }

    @Override
    public boolean checkAnswer(String respostaSelecionada,int jogada){
        if(getRespostas().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta())){
            return true;
        }
        else{
            return false;
        }
    }



    @Override
    public int contas(){
        int pontos=super.valorBase*super.majoracao;
        return pontos;
    }
}
