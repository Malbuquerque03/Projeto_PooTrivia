
import java.io.*;
import java.util.ArrayList;

public class GereFicheiro {


    /**
     *
     * @param f
     * @param perguntas
     * @param respostas
     */
    public void readTextFile(File f, ArrayList<Pergunta> perguntas, ArrayList respostas) {

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                String[] linha;
                String[][] separado;
                while ((line = br.readLine()) != null) {
                    linha = separaRespostas(line,";");
                    separado=separa2Respostas(linha,"/");


                    if(separado[0][0].equalsIgnoreCase("ciencias")){
                        for(int j=1; j< separado.length;j++) {
                            String[][] facildificil = separaEstranho(separado,j);
                            perguntas.add(new Ciencia(separado[j][0],buedaFacil(facildificil),buedaDificil(facildificil),facildificil[0][0]));
                        }

                    }

                    if(separado[0][0].equalsIgnoreCase("artes")){

                        for(int j=1; j< separado.length;j++) {
                            perguntas.add(new Artes(separado[j][0],addArray(separado,j),separado[j][1]));

                        }

                    }

                    if(separado[0][0].equalsIgnoreCase("ski")){
                        for(int j=1; j< separado.length;j++) {
                            perguntas.add( new Ski(separado[j][0],addArray(separado,j),separado[j][1]));
                        }


                    }

                    if(separado[0][0].equalsIgnoreCase("natacao")){
                        for(int j=1; j< separado.length;j++) {
                            perguntas.add( new Natacao(separado[j][0],addArray(separado,j),separado[j][1]));
                        }

                    }

                    if(separado[0][0].equalsIgnoreCase("futebol")){
                        for(int j=1; j< separado.length;j++) {
                            String[][] facildificil = separaEstranho(separado,j);
                            String[] certas = new String[2];
                            certas[0] = facildificil[0][0];
                            certas[1]=facildificil[0][1];
                            perguntas.add(new Futebol(separado[j][0],buedaFacil(facildificil),buedaDificil(facildificil),certas));

                        }
                    }

                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }

    }


    public void writeFicheiroObjetos(Jogador j, File f) {

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(j);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }

    }





    public void readFicheiroObjetos(Jogador j, File fo, ArrayList<Jogador> jogadores) {

        try {

            FileInputStream fis = new FileInputStream(fo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            j = (Jogador) ois.readObject();

                adicionaJogador(j, jogadores);

            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de objetos.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de objetos.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }
    private String[] separaRespostas(String td, String a){     //metodo de separacao
        String[] respostas= td.split(a);
        return respostas;
    }
    private String[][] separa2Respostas(String[] respostas, String a){     //metodo de separacao
        String[][] separadinho = new String[respostas.length][];
        for (int i = 0; i < respostas.length; i++) {

            separadinho[i] = respostas[i].split(a);
        }
        return separadinho;
    }
    private ArrayList addArray(String[][] aSeparar, int j){
        ArrayList a = new ArrayList();

        for (int i = 0; i < aSeparar[j].length - 1; i++) {
            a.add(aSeparar[j][i + 1]);
        }
        return a;
    }


    private String[][] separaEstranho(String[][] separado,int j){

        String[] respostas= new String[separado[j].length-1];

        for(int i=0;i<separado[j].length-1;i++){
            respostas[i]=separado[j][i+1];
        }

        String[][] facilDificil = separa2Respostas(respostas,"&");
        return facilDificil;
    }
    private ArrayList buedaFacil(String[][] mixed){

        ArrayList facis=new ArrayList();
        for(int i=0;i<mixed.length;i++){
            facis.add(mixed[i][0]);
        }
        return facis;
    }

    private ArrayList buedaDificil(String[][] mixed){
        ArrayList dificis=new ArrayList();
        for(int i=0;i<mixed.length;i++){
            dificis.add(mixed[i][mixed[i].length-1]);
        }
        return dificis;
    }

    private static void printarray(String[] a){        // metodo para ajuda de debug
        for(int i =0; i<a.length;i++){
            System.out.println("["+i+"] "+a[i]);
        }
    }

    private static void printtabela(String[][] a){       // metodo para ajuda de debug
        for(int i =0; i<a.length;i++){
            for(int j =0; j<a[i].length;j++) {
                System.out.println("[" + i + "] ["+j+"] " + a[i][j]);
            }
        }
    }



    private void adicionaJogador(Jogador e,ArrayList<Jogador> jogadores){
        jogadores.add(new Jogador(e.getNome(),e.getCertas(),e.getErradas()));
    }

}




