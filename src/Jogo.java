import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {


    public void menu(ArrayList<Pergunta> perguntas){
        Scanner sc = new Scanner(System.in);
        String response;
        //lig();
        while (true){
            System.out.println("\t\t\tVAMOS JOGAR??(S/N)");
            response = sc.nextLine();
            if (response.equalsIgnoreCase("sim") || response.equalsIgnoreCase("s"))
                lig(perguntas);

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
        ArrayList respostasCertas =new ArrayList<>() ;
        ArrayList respostasErradas =new ArrayList<>() ;
        String resultadoELugar;
        int resultado =0;
        Scanner sc = new Scanner(System.in);

        while(jogada<=5){
            int index = (int)(Math.random() * perguntas.size());
            System.out.println("\t\t\tPERGUNTA "+jogada +":\n"+ perguntas.get(index).pergunta);

            System.out.println("\t\t\tOPÇÕES:");
            if(jogada<=3){
               resultado= perguntas.get(index).respostaAte3();
                if(resultado==1){
                    resultadoELugar= perguntas.get(index) + String.valueOf(jogada);
                    respostasCertas.add(resultadoELugar);
                }
               else if(resultado==0){
                    resultadoELugar= perguntas.get(index) + String.valueOf(jogada);
                    respostasErradas.add(resultadoELugar);
                }
               else{
                    System.out.println("ERRO ERRO");
                }
            }
            jogada++;
        }
    }

}
