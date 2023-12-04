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


    public void setRespostas(ArrayList respostas) {
        this.respostas = respostas;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    //Getters




    public ArrayList getRespostas() {
        return respostas;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }


    //Metodos
    @Override
    public ArrayList getEasyAnswer(){
        ArrayList<String> resp= new ArrayList();
        for (String resposta : respostas.subList(1, respostas.size())) {
            resp.add(resposta);
        }
        Collections.shuffle(resp);
        resp = new ArrayList<>(resp.subList(0,  resp.size() / 2));
        resp.add(respostas.get(0));
        Collections.shuffle(resp);
        return resp;
    }

    @Override
    public int respostaAte3(){
        ArrayList<String> resp= new ArrayList();
        Scanner sc = new Scanner(System.in);

        for (String resposta : respostas.subList(1, respostas.size())) {
            resp.add(resposta);
        }

        Collections.shuffle(resp);

        resp = new ArrayList<>(resp.subList(0, resp.size() / 2));

        resp.add(respostas.get(0));
        Collections.shuffle(resp);



        for(Object r: resp){
            System.out.println(resp.indexOf(r)+"-->"+r);
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }

        int x = sc.nextInt();

        if(x>=resp.size()){
            System.out.println("RESPOSTA INVALIDA");
            return respostaAte3();
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
    @Override
    public ArrayList getHardAnswer(){
        Collections.shuffle(respostas);
        return respostas;
    }
    @Override
    public int perguntaDificil() {
        Collections.shuffle(respostas);
        Scanner sc = new Scanner(System.in);
        for(int i=0;i< respostas.size();i++){
            //   System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(i+"-->"+respostas.get(i));
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        int x = sc.nextInt();

        if(x>=respostas.size()){
            System.out.println("RESPOSTA INVALIDA");
            return respostaAte3();
        }
        else{
            if(respostas.get(x).equals(respostaCerta)){
                System.out.println("ACERTOU------ " +contas()+ " pontos");
                return 1;
            }
            else{
                System.out.println("ERROU------ 0 pontos");
                return 0;
            }
        }

    }

    @Override
    public int contas(){
        int pontos=super.valorBase*super.majoracao;
        return pontos;
    }

    @Override
    public String respostaCerta(int jogada) {
        return getRespostaCerta();
    }

}
