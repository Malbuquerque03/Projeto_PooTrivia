import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Jogo {

    ArrayList<String> respostasCertas =new ArrayList<>() ;
    ArrayList<String> respostasErradas =new ArrayList<>() ;
    ArrayList<Integer> tdsrespostas =new ArrayList<>() ;

    GereFicheiro f = new GereFicheiro();
    Scanner sc = new Scanner(System.in);

    String resultadoELugar;

    public void menu(ArrayList<Pergunta> perguntas, ArrayList<Jogador> jogadores){
        Scanner sc = new Scanner(System.in);
        String response;
        while (true){
            System.out.println("\t\t\tVAMOS JOGAR??(S/N)");
            response = sc.nextLine();
            if (response.equalsIgnoreCase("sim") || response.equalsIgnoreCase("s")){
                tdsrespostas.clear();
                respostasCertas.clear();
                respostasErradas.clear();
                lig(perguntas,jogadores);
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



    public void lig(ArrayList<Pergunta> perguntas,ArrayList<Jogador> jogadores){
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

        int pontos= pontuacao(perguntas,jogadores,null);
        System.out.println("-->Pontuação: "+ pontos);
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
           // resultadoELugar= perguntas.get(index).pergunta + jogada;
            resultadoELugar= perguntas.get(index).pergunta;
            respostasCertas.add(resultadoELugar);
            tdsrespostas.add(index);
        }
        else if(resultado==0){
           // resultadoELugar= perguntas.get(index).pergunta + jogada;
            resultadoELugar= perguntas.get(index).pergunta;
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




    private void listFilesExample(Jogador j,ArrayList<Jogador> jogadores) {

        // Specify the directory path
        String directoryPath = "C:\\Users\\Utilizador\\IdeaProjects\\Projeto_PooTrivia";

        // Create a File object for the specified directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List all files in the directory
            File[] files = directory.listFiles();

            // Check if any files are found
            if (files != null) {
                int cont=0;
                // Print the names of the files
                for (File file : files) {
                    if(file.getName().endsWith(".dat")){
                        File fn = new File(file.getName());
                        f.readFicheiroObjetos(j,fn,1,jogadores);
                        cont++;
                        System.out.println(file.getName());

                    }
                    System.out.println("CONT--->"+cont);

                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

    }

    private void top3(ArrayList<Jogador> jogadores, ArrayList<Pergunta> perguntas){
        if(jogadores.size()>0) {
            Jogador max;
            boolean sorted = false;
            while (!sorted) { // enquanto n tiver ordenado vai continuar
                sorted = true;
                for (int i = 0; i < jogadores.size() - 1; i++) {
                    if (pontuacao(perguntas, jogadores, jogadores.get(i)) > pontuacao(perguntas, jogadores, jogadores.get(i + 1))) { // se a pontuacao da esquerda for maior q a da direita troca
                        max = jogadores.get(i);
                        jogadores.set(i, jogadores.get(i + 1));
                        jogadores.set(i + 1, max); // trocas
                        sorted = false; //ainda n sabemos se ta ordenado ou n 
                    }
                }
            }

            if (jogadores.size() < 4){
                if(jogadores.size()==1)
                    System.out.println("********LUGAR Nº 1 ********\n"+ "NOME-->" + jogadores.get(0).getNome()+"\nDATA--> " + jogadores.get(0).getData()+"\nFICHEIRO--> " + jogadores.get(0).getNomeFile());
                else{
                    for (int i = 1; i <= jogadores.size(); i++) {
                        System.out.println("********LUGAR Nº " + i + "********");
                        System.out.println("NOME-->" + jogadores.get(i - 1).getNome());
                        System.out.println("DATA--> " + jogadores.get(i - 1).getData());
                        System.out.println("FICHEIRO--> " + jogadores.get(i - 1).getNomeFile());
                    }
                }

            }

            else{
                for (int i = 1; i <= 3; i++) {
                    System.out.println("********LUGAR Nº " + i + "********");
                    System.out.println("NOME-->" + jogadores.get(i - 1).getNome());
                    System.out.println("DATA--> " + jogadores.get(i - 1).getData());
                    System.out.println("FICHEIRO--> " + jogadores.get(i - 1).getNomeFile());
                }
            }


        }

    }
    private int pontuacao(ArrayList<Pergunta> perguntas,ArrayList<Jogador> jogadores, Jogador j){
        int pontos=0;
        if(jogadores.isEmpty()){
            for(String r: respostasCertas){
                for(Pergunta p:perguntas){
                    if(r.equalsIgnoreCase(p.pergunta))
                        pontos+= p.contas();
                }
            }
        }
        else{
            for(Object r: j.getCertas()){
                for(Pergunta p:perguntas){
                    if(r.equals(p.pergunta))
                        pontos+= p.contas();
                }
            }

        }

        return pontos;
    }
  
}
