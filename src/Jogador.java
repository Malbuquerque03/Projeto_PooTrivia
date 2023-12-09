import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Jogador implements Serializable {

    protected String data;
    protected String nome;

    protected ArrayList<Pergunta> erradas;
    protected ArrayList<Pergunta> certas;
    protected String nomeFile;

    public Jogador( String nome,ArrayList<Pergunta> erradas,ArrayList<Pergunta> certas , String data) {
        this.data = data;
        this.nome = nome;
        this.erradas=erradas;
        this.certas=certas;
        setNomeFile(nomeFileObj());

    }


    // setters
    public void setData(String data) {
        this.data = data;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setErradas(ArrayList<Pergunta> erradas) { this.erradas = erradas; }

    public void setCertas(ArrayList<Pergunta> certas) { this.certas = certas; }

    public void setNomeFile(String nomeFile) { this.nomeFile = nomeFile; }

    //getters
    public String getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Pergunta> getErradas() {
        return erradas;
    }

    public ArrayList<Pergunta> getCertas() {
        return certas;
    }

    public String getNomeFile() { return nomeFile; }

    private String nomeFileObj(){
        String pathNome= "pootrivia_jogo_";
        String[] date = data.split("-|:| ");
        for(int i =0; i< date.length;i++){
            pathNome+= date[i];
        }
        date = nome.split(" ");
        pathNome += "_"+ date[0].charAt(0);
        for(int i=1; i< date.length;i++){
            pathNome+=date[i].charAt(0);
        }
        pathNome+= ".dat";

        return pathNome;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "data='" + data + '\'' +
                ", nome='" + nome + '\'' +
                ", erradas=" + erradas +
                ", certas=" + certas +
                ", nomeFile='" + nomeFile + '\'' +
                '}';
    }


}