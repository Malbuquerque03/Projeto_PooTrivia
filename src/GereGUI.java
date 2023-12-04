import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GereGUI extends JFrame{

    Color corBotao= new Color(229,179,242);
    Color corLetrasBotao= new Color	(86,86,86);
    Color corPerguntas= new Color(242,162,192);
    Color corFundo= new Color(64,61,62);
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GereGUI(ArrayList<Pergunta> perguntas) {
        Jogo jogo=new Jogo();

        // Adiciona margens à janela
        int marginSize = 100;
        EmptyBorder margin = new EmptyBorder(marginSize, marginSize, marginSize, marginSize);
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(margin);
        // Define a cor do fundo
        contentPanel.setBackground(corFundo);

        setContentPane(contentPanel);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        //Painel de boas-vindas
        JPanel welcomePanel = getWelcomePanel();

        jogo.tdsrespostas.clear();

        int jogada =1;
        int index;
        index= jogo.verificacao(perguntas);


        // Painel da primeira pergunta
        JPanel questionPanel1 = createQuestionPanel(index,jogada,jogo,perguntas, jogo.fazResposta(perguntas,jogada,index));
        JPanel resultado1=painelDoResultado(false,perguntas,index);
        index= jogo.verificacao(perguntas);
        jogada++;
        // Painel da segunda pergunta
        JPanel questionPanel2 = createQuestionPanel(index,jogada,jogo,perguntas, jogo.fazResposta(perguntas,jogada,index));
        JPanel resultado2=painelDoResultado(false,perguntas,index);
        index= jogo.verificacao(perguntas);
        jogada++;
        // Painel da terceira pergunta
        JPanel questionPanel3 = createQuestionPanel(index,jogada,jogo,perguntas, jogo.fazResposta(perguntas,jogada,index));
        JPanel resultado3=painelDoResultado(false,perguntas,index);
        index= jogo.verificacao(perguntas);
        jogada++;
        // Painel da quarta pergunta
        JPanel questionPanel4 = createQuestionPanel(index,jogada,jogo,perguntas, jogo.fazResposta(perguntas,jogada,index));
        JPanel resultado4=painelDoResultado(false,perguntas,index);
        index= jogo.verificacao(perguntas);
        jogada++;
        // Painel da quinta pergunta
        JPanel questionPanel5 = createQuestionPanel(index,jogada,jogo,perguntas, jogo.fazResposta(perguntas,jogada,index));
        JPanel resultado5=painelDoResultado(false,perguntas,index);

        // Adiciona os painéis ao cardPanel
        cardPanel.add(welcomePanel, "Welcome");
        cardPanel.add(questionPanel1, "Question1");
        cardPanel.add(resultado1, "Result1");
        cardPanel.add(questionPanel2, "Question2");
        cardPanel.add(resultado2, "Result2");
        cardPanel.add(questionPanel3, "Question3");
        cardPanel.add(resultado3, "Result3");
        cardPanel.add(questionPanel4, "Question4");
        cardPanel.add(resultado4, "Result4");
        cardPanel.add(questionPanel5, "Question5");
        cardPanel.add(resultado5, "Result5");


        add(cardPanel);

    }

    private JPanel getWelcomePanel() {

        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(corFundo);
        JLabel welcomeLabel = new JLabel("Bem-vindo ao POO Trivia!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        welcomeLabel.setForeground(corPerguntas);

        //Painel do Botão Começar
        JPanel buttonPanel = getButtonPanel("Começar");

        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomePanel.add(buttonPanel, BorderLayout.SOUTH);
        return welcomePanel;
    }

    private JPanel getButtonPanel(String mensagem) {

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton(mensagem);
        buttonPanel.setBackground(corFundo);

        // Define um tamanho específico para o botão
        Dimension buttonSize = new Dimension(300, 60);
        startButton.setPreferredSize(buttonSize);

        // Define o tamanho da fonte do texto no botão
        Font buttonFont = new Font("Times new Roman", Font.BOLD, 23);
        startButton.setFont(buttonFont);

        // definir cor do botão
        startButton.setBackground(corBotao);
        //Define a cor do texto
        startButton.setForeground(corLetrasBotao);


        startButton.addActionListener(e -> cardLayout.next(cardPanel));
        buttonPanel.add(startButton);
        return buttonPanel;
    }

    private JPanel createQuestionPanel(int index,int jogada,Jogo jogo,ArrayList<Pergunta> perguntas,ArrayList<String> respostas) {
        JPanel questionPanel = new JPanel(new BorderLayout());
        String perguntaTexto = jogo.fazPergunta(perguntas,jogada,index);
        JLabel questionLabel = new JLabel("<html>" + perguntaTexto + "</html>");
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD,20));
        questionLabel.setForeground(corPerguntas);

        questionPanel.add(questionLabel, BorderLayout.NORTH);
        questionPanel.setBackground(corFundo);

        JPanel optionsPanel = new JPanel(new GridLayout(respostas.size(), 1));

        for (Object option : respostas) {
            JButton optionButton = new JButton(option.toString());
            optionButton.addActionListener(e -> cardLayout.next(cardPanel));
            optionsPanel.add(optionButton);
            optionButton.setBackground(corBotao);
            optionButton.setForeground(corLetrasBotao);


            if (optionButton.getText().equalsIgnoreCase(perguntas.get(index).respostaCerta(jogada)))
                painelDoResultado(true,perguntas,index);

            else
                painelDoResultado(false,perguntas,index);


        }



        questionPanel.add(optionsPanel, BorderLayout.CENTER);


        return questionPanel;
    }

    private JPanel painelDoResultado(Boolean acertou,ArrayList<Pergunta> perguntas,int index) {
        JPanel resultadoLabelsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultadoLabelsPanel.setLayout(new BoxLayout(resultadoLabelsPanel, BoxLayout.Y_AXIS));
        JPanel resultadoPainel = new JPanel(new BorderLayout());
        resultadoLabelsPanel.setBackground(corFundo);
        JLabel resultadoLabel;
        JLabel pontuacaoLabel;
        if(acertou){
             resultadoLabel = new JLabel("(:!!!ACERTOU!!!:)");
             pontuacaoLabel= new JLabel("+"+perguntas.get(index)+" PONTOS<3<3");
        }
        else{
            resultadoLabel = new JLabel("); !!!ERROU!!! ;(");
            pontuacaoLabel= new JLabel("+ 0 PONTOS (T_T)");
        }

        resultadoLabel.setHorizontalAlignment(JLabel.CENTER);
        resultadoLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        resultadoLabel.setForeground(corPerguntas);

        pontuacaoLabel.setHorizontalAlignment(JLabel.CENTER);
        pontuacaoLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        pontuacaoLabel.setForeground(corPerguntas);


        resultadoLabelsPanel.add(resultadoLabel);
        resultadoLabelsPanel.add(pontuacaoLabel);


        JPanel buttonPanel = getButtonPanel("Proxima Pergunta");

        resultadoPainel.add(resultadoLabelsPanel, BorderLayout.CENTER);
        resultadoPainel.add(buttonPanel, BorderLayout.SOUTH);

        return resultadoPainel;
    }


}


