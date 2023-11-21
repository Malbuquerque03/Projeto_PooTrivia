import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Jogador {

    // Get the current date and time
    String data;
    protected String nome;

    protected ArrayList erradas;
    protected ArrayList certas;

    public Jogador( String nome,ArrayList erradas,ArrayList certas ) {
        setData();
        this.nome = nome;
        this.erradas=erradas;
        this.certas=certas;
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

    public void setErradas(ArrayList erradas) {
        this.erradas = erradas;
    }

    public void setCertas(ArrayList certas) {
        this.certas = certas;
    }

    //getters
    public String getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList getErradas() {
        return erradas;
    }

    public ArrayList getCertas() {
        return certas;
    }
}





