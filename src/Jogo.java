import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;



public class Jogo {

    ArrayList<Pergunta> respostasCertas =new ArrayList<>() ;
    ArrayList<Pergunta> respostasErradas =new ArrayList<>() ;

    GereFicheiro f = new GereFicheiro();
    Scanner sc = new Scanner(System.in);


    public void menu(ArrayList<Pergunta> perguntas, ArrayList<Jogador> jogadores){
        Scanner sc = new Scanner(System.in);
        String response;
        while (true){
            System.out.println("\t\t\tVAMOS JOGAR??(S/N)");
            response = sc.nextLine();
            if (response.equalsIgnoreCase("sim") || response.equalsIgnoreCase("s")){
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

        while(jogada<=5){

            int index = verificacao(perguntas,respostasCertas, respostasErradas);
            System.out.println("\t\t\tPERGUNTA "+jogada +":\n"+ perguntas.get(index).getPergunta());

            System.out.println("\t\t\tOPÇÕES:\n");

            verSeECorreta(perguntas.get(index).questionario(jogada),index,perguntas);


            jogada++;
        }
        System.out.println("\n+++++++++++++++++++++++++++++FIM DO JOGO+++++++++++++++++++++++++++++");
        System.out.print("-->Nome: ");
        String nome= sc.nextLine();
        Jogador j= new Jogador(nome,respostasErradas,respostasCertas,createDate());
        int pontos= pontuacao(j);

        System.out.println("-->Pontuação: "+ pontos);

        System.out.println("-->Certas: ");
        for(Pergunta r: j.getCertas()){
            System.out.println("\t\t->"+r.getPergunta());
        }
        System.out.println("-->Erradas: ");
        for(Pergunta r: j.getErradas()){
            System.out.println("\t\t->"+r.getPergunta());
        }


        System.out.println("-->Data: "+ j.getData());
        saveData(j,jogadores);
        /*
        if(!jogadores.isEmpty()){
            for(Jogador jog : jogadores){
                System.out.println("------------JOGADOR---------");
                System.out.println(jog.getNome());
                System.out.println(jog.getData());
                System.out.println(jog.getNomeFile());
                for(Pergunta p: jog.getCertas()){
                    System.out.println(p.getPergunta());
                }

                System.out.println(pontuacao(jog));
                System.out.println("----------------------------");
            }


        }

         */

        top3(jogadores);

        System.out.println("\n+++++++++++++++++++++++++++++++++DONE+++++++++++++++++++++++++++++++++");

    }


    public String fazPergunta(ArrayList<Pergunta> perguntas, int jogada, int index) {

        if(jogada <= 5){
            return ("PERGUNTA "+jogada +": "+ perguntas.get(index).getPergunta());

        }
        return null;
    }
    public ArrayList<String> fazResposta(ArrayList<Pergunta> perguntas, int jogada, int index){
        return perguntas.get(index).getAnswers(jogada);
    }
    public boolean checksAnswer(ArrayList<Pergunta> perguntas, int jogada, int index,String respostaSelecionada,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas){
        boolean resultado;

        resultado = perguntas.get(index).checkAnswer(respostaSelecionada,jogada);
        if(resultado){
            respostasCertas.add(perguntas.get(index));
        }
        else  {
            respostasErradas.add(perguntas.get(index));
        }

        return resultado;
    }



    private void verSeECorreta(boolean resultado,int index,ArrayList<Pergunta> perguntas){
        if(resultado){
            respostasCertas.add(perguntas.get(index));
        }
        else{
            respostasErradas.add(perguntas.get(index));
        }
    }

    public int verificacao(ArrayList<Pergunta> perguntas,ArrayList<Pergunta>respostasCertas,ArrayList<Pergunta>respostasErradas) {
        int index = (int) (Math.random() * perguntas.size());
        if (respostasCertas.contains(perguntas.get(index))||respostasErradas.contains(perguntas.get(index))) {
            return verificacao(perguntas,respostasCertas,respostasErradas);
        } else {
            return index;
        }
    }

    private void buscaFilesJogadores(Jogador j,ArrayList<Jogador> jogadores) {
        jogadores.clear();

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
                // Print the names of the files
                for (File file : files) {
                    // GereFicheiro gg= new GereFicheiro();
                    if(file.getName().endsWith(".dat")){
                        File fn = new File(file.getName());
                        f.readFicheiroObjetos(fn,jogadores);
                    }

                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

    }

    private void top3(ArrayList<Jogador> jogadores){
        if(!jogadores.isEmpty()) {
            jogadores= ordenaJogadores(jogadores);

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
    public ArrayList<String> getTop3(ArrayList<Jogador> jogadores){
        ArrayList<String> top3 = new ArrayList<>();
        if(!jogadores.isEmpty()) {
            jogadores = ordenaJogadores(jogadores);

            if (jogadores.size() < 4){
                if(jogadores.size()==1)
                    top3.add("<html><div style='text-align: center;'>" +"<h1>********LUGAR Nº 1 ********</h1>"+ "<li>NOME-->" + jogadores.get(0).getNome()+"</li>"+"<li>DATA--> " + jogadores.get(0).getData()+"</li>"+"<li>FICHEIRO--> " + jogadores.get(0).getNomeFile()+"</li>"+"</ul></div></html>");
                else{
                    for (int i = 1; i <= jogadores.size(); i++) {
                        top3.add("<html><div style='text-align: center;'>" +"<h1>********LUGAR Nº  " + i + " ********</h1>"+ "<li>NOME-->" + jogadores.get(i - 1).getNome()+"</li>"+"<li>DATA--> " + jogadores.get(i - 1).getData()+"</li>"+"<li>FICHEIRO--> " + jogadores.get(i - 1).getNomeFile()+"</li>"+"</ul></div></html>");
                    }
                }

            }

            else{
                for (int i = 1; i <= 3; i++) {
                    top3.add("<html><div style='text-align: center;'>" +"<h1>********LUGAR Nº  " + i + " ********</h1>"+ "<li>NOME-->" + jogadores.get(i - 1).getNome()+"</li>"+"<li>DATA--> " + jogadores.get(i - 1).getData()+"</li>"+"<li>FICHEIRO--> " + jogadores.get(i - 1).getNomeFile()+"</li>"+"</ul></div></html>");

                }
            }

        }
        return top3;
    }

    private ArrayList<Jogador> ordenaJogadores(ArrayList<Jogador> jogadores){
        Jogador max;
        boolean sorted = false;
        while (!sorted) { // enquanto não tiver ordenado vai continuar
            sorted = true;
            for (int i = 0; i < jogadores.size() - 1; i++) {
                if (pontuacao(jogadores.get(i)) < pontuacao(jogadores.get(i + 1))) { // se a pontuacao da esquerda for menor q a da direita troca
                    max = jogadores.get(i);
                    jogadores.set(i, jogadores.get(i + 1));
                    jogadores.set(i + 1, max); // trocas
                    sorted = false; //ainda n sabemos se ta ordenado ou n
                }
            }
        }

        return jogadores;
    }

    public int pontuacao(Jogador j){
        int pontos=0;
        for(Pergunta r: j.getCertas()){
            pontos += r.contas();
        }

        return pontos;
    }


    public void saveData(Jogador j,ArrayList<Jogador> jogadores){
        File filename = new File(j.getNomeFile());
        f.writeFicheiroObjetos(j,filename);
        buscaFilesJogadores(j,jogadores);
    }
    public String createDate(){
        // Get the current date and time
        LocalDateTime data = LocalDateTime.now();
        // Define a formatter for the desired output format
        DateTimeFormatter padrao = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Format the current date and time as a string
        return data.format(padrao);
    }

}