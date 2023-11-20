import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Jogador {

    // Get the current date and time
    String data;
    protected String nome;


    public Jogador( String nome) {
        setData();
        this.nome = nome;
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


    //getters
    public String getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }
}





