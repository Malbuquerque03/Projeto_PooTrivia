import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Artes extends Pergunta {
    private ArrayList<String> respostas;
    private String respostaCerta;


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
    public boolean questionario(int jogada){

        Scanner sc = new Scanner(System.in);

        if(jogada<3){
            ArrayList<String> resp= new ArrayList<>();
            for (String resposta : respostas.subList(1, respostas.size())) {
                resp.add(resposta);
            }

            Collections.shuffle(resp);

            resp = new ArrayList<>(resp.subList(0, 2));

            resp.add(getRespostas().get(0));
            Collections.shuffle(resp);

            for(String r: resp){
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
                    return true;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return false;
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
                    return true;
                }
                else{
                    System.out.println("ERROU------ 0 pontos");
                    return false;
                }
            }

        }

    }

    @Override
    public ArrayList<String> getAnswers(int jogada){
        if(jogada<3){
            ArrayList<String> resp= new ArrayList<>();
            for (String resposta : getRespostas().subList(1, getRespostas().size())) {
                resp.add(resposta);
            }
            Collections.shuffle(resp);
            resp = new ArrayList<>(resp.subList(0,2));
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
        return getRespostas().contains(respostaSelecionada) && respostaSelecionada.equals(getRespostaCerta());
    }



    @Override
    public int contas(){
        return super.getValorBase()*super.getMajoracao();
    }
}