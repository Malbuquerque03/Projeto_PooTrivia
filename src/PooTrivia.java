import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PooTrivia {
    public static void main(String[] args) {
       new PooTrivia();
    }
    public PooTrivia(){

         ArrayList<Pergunta> perguntas = new ArrayList<>();
         ArrayList respostas =new ArrayList<>() ;
        String line="CIENCIAS;Qual é o processo pelo qual as plantas fazem seu próprio alimento?/Fotossíntese/Fotocópia&Respiração celular/Metamorfose&Digestão externa/Cozimento solar&Transpiração invertida/Síntese lunar& Síntese clorofiliana;Quem é considerado o pai da biologia moderna?/Charles Darwin/Richard Dawkins&Isaac Newton/Aristóteles&Carolyn Bertozzi/Jennifer Doudna&Dmitri Mendeleev/Edward O. Wilson&Thomas Edison/Marie Curie&Marcus Feldman;O que a sigla DNA representa?/Ácido desoxirribonucleico/Xylozyme/ReactaPro&Ácido Acetilsalicílico/EnigmaTech&Ácido Gama-Aminobutírico/Protenina A&Ácido Ascórbico";
        String[] linha;
        String[][] separado;
        linha = separaRespostas(line,";");
        separado=separa2Respostas(linha,"/");


        for(int i=1;i<separado.length;i++){
            perguntas.add(new Pergunta(separado[i][0], false));
        }


        for( Pergunta p: perguntas){
            System.out.println(p.getPergunta());
        }


        if(separado[0][0].equalsIgnoreCase("ciencias")){

                }

        }


    private static String[] separaRespostas(String td, String a){     //metodo de separacao
        String[] respostas= td.split(a);
        return respostas;
    }
    private static String[][] separa2Respostas(String[] respostas, String a){     //metodo de separacao
        String[][] separadinho = new String[respostas.length][];
        for (int i = 0; i < respostas.length; i++) {

            separadinho[i] = respostas[i].split(a);
        }
        return separadinho;
    }

    private static void printtabela(String[][] a){       // metodo para ajuda de debug
        for(int i =0; i<a.length;i++){
            for(int j =0; j<a[i].length;j++) {
                System.out.println("[" + i + "] ["+j+"] " + a[i][j]);
            }
        }
    }

    private static void printarray(String[] a){        // metodo para ajuda de debug
        for(int i =0; i<a.length;i++){
            System.out.println("["+i+"] "+a[i]);
        }
    }
}