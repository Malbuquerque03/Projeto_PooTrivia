import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Jogador {

    // Get the current date and time
    String data;
    protected String nome;

    protected ArrayList erradas;
    protected ArrayList certas;
    protected String nomeFile;

    public Jogador( String nome,ArrayList erradas,ArrayList certas ) {
        setData();
        this.nome = nome;
        this.erradas=erradas;
        this.certas=certas;
        setNomeFile(nomeFileObj());

    }

    // setters
    public void setData() {

        // Get the current date and time
        LocalDateTime dataFeia = LocalDateTime.now();
        // Define a formatter for the desired output format
        DateTimeFormatter padrao = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Format the current date and time as a string
        data = dataFeia.format(padrao);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setErradas(ArrayList erradas) { this.erradas = erradas; }

    public void setCertas(ArrayList certas) { this.certas = certas; }

    public void setNomeFile(String nomeFile) { this.nomeFile = nomeFile; }

    //getters
    public String getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList getErradas() { return erradas; }

    public ArrayList getCertas() {
        return certas;
    }

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
}





