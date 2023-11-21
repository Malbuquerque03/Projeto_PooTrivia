import java.io.*;
import java.util.ArrayList;

public class GereFicheiro {
    protected ArrayList<Pergunta> perguntas = new ArrayList<>();
    protected ArrayList respostas;



    public void writeFicheiroObjetos(Jogador j) {
        String pathNome= "pootrivia_jogo_";
        String[] date = j.data.split("-|:| ");
        for(int i =0; i< date.length;i++){
            pathNome+= date[i];
        }
        date = j.nome.split(" ");
        pathNome += "_"+ date[0].charAt(0);
        for(int i=1; i< date.length;i++){
            pathNome+=date[i].charAt(0);
        }
        pathNome+= ".dat";
        File f = new File(pathNome);
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



    public void readFicheiroObjetos(Jogador e, File fo) {

        try {
            FileInputStream fis = new FileInputStream(fo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            e = (Jogador) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de objetos.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de objetos.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }

}





