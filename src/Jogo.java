import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

    ArrayList<String> respostasCertas =new ArrayList<>() ;
    ArrayList<String> respostasErradas =new ArrayList<>() ;
    ArrayList<Integer> tdsrespostas =new ArrayList<>() ;

    GereFicheiro f = new GereFicheiro();
    Scanner sc = new Scanner(System.in);

    String resultadoELugar;

    public void menu(ArrayList<Pergunta> perguntas,ArrayList<Jogador> jogadores){
        Scanner sc = new Scanner(System.in);
        String response;
        while (true){
            System.out.println("\t\t\tVAMOS JOGAR??(S/N)");
            response = sc.nextLine();
            if (response.equalsIgnoreCase("sim") || response.equalsIgnoreCase("s")){
                tdsrespostas.clear();
                respostasCertas.clear();
                respostasErradas.clear();
                lig(perguntas);
            }


            else if(response.equalsIgnoreCase("nao") || response.equalsIgnoreCase("n")){
                System.out.println("CLOSING");
                break;
            }

            else{
                System.out.println("--------------------------RESPOSTA INVALIDA--------------------------");
            }
        }
    }



    public void lig(ArrayList<Pergunta> perguntas){
        int jogada=1;
        int resultado;

        while(jogada<=5){

            int index = verificacao(perguntas);
            System.out.println("\t\t\tPERGUNTA "+jogada +":\n"+ perguntas.get(index).pergunta);

            System.out.println("\t\t\tOPÇÕES:");
            if(jogada<=3){
               resultado= perguntas.get(index).respostaAte3();
                verSeECorreta(resultado,index,jogada,perguntas);
            }
            else{
                resultado= perguntas.get(index).perguntaDificil();
                verSeECorreta(resultado,index,jogada,perguntas);
            }

            jogada++;
        }
        System.out.println("\n+++++++++++++++++++++++++++++FIM DO JOGO+++++++++++++++++++++++++++++");
        int pontuacao=0;
        for(String r: respostasCertas){
            for(Pergunta p:perguntas){
                if(r.substring(0,r.length()-1).equalsIgnoreCase(p.pergunta)){
                    pontuacao+= p.contas();
                }
            }

        }

        System.out.println("-->Pontuação: "+ pontuacao);
        System.out.print("-->Nome: ");
        String nome= sc.nextLine();
        System.out.println("-->Certas: ");
        for(String r:respostasCertas){
            System.out.println("\t\t->"+r);
        }
        System.out.println("-->Erradas: ");
        for(String r:respostasErradas){
            System.out.println("\t\t->"+r);
        }
        Jogador j= new Jogador(nome,respostasErradas,respostasCertas);
        System.out.println("-->Data: "+ j.data);
        f.writeFicheiroObjetos(j);
        f.readFicheiroObjetos(j);
        System.out.println("\n+++++++++++++++++++++++++++++++++DONE+++++++++++++++++++++++++++++++++");
    }

    private void verSeECorreta(int resultado,int index, int jogada,ArrayList<Pergunta> perguntas){
        if(resultado==1){
            resultadoELugar= perguntas.get(index).pergunta + jogada;
            respostasCertas.add(resultadoELugar);
            tdsrespostas.add(index);
        }
        else if(resultado==0){
            resultadoELugar= perguntas.get(index).pergunta + jogada;
            respostasErradas.add(resultadoELugar);
            tdsrespostas.add(index);
        }
        else{
            System.out.println("ERRO ERRO");
        }
    }

    private int verificacao(ArrayList<Pergunta> perguntas) {
        int index = (int) (Math.random() * perguntas.size());
        if (tdsrespostas.contains(index)) {
            return verificacao(perguntas);
        } else {
            return index;
        }
    }
}
