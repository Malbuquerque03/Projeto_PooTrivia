import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;


public class GereGUI extends JFrame {
    Color corBotao= new Color(229,179,242);
    Color corLetrasBotao= new Color	(86,86,86);
    Color corPerguntas= new Color(242,162,192);
    Color corFundo= new Color(64,61,62);
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private int jogada;


    Jogo jogo=new Jogo();
    public GereGUI(ArrayList<Pergunta> perguntas ,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas,ArrayList<Jogador> jogadores) {

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

        cardPanel.add(getWelcomePanel( perguntas, respostasCertas,respostasErradas,jogadores), "Welcome");

        add(cardPanel);

    }
    private JPanel getWelcomePanel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas,ArrayList<Jogador> jogadores) {
        //Define o painel de Boas Vindas
        respostasCertas.clear();
        respostasErradas.clear();
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(corFundo);
        JLabel welcomeLabel = new JLabel("Bem-vindo ao POO Trivia!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        welcomeLabel.setForeground(corPerguntas);

        //Painel do Botão Começar
        JPanel buttonPanel = getButtonPanel( perguntas, respostasCertas,respostasErradas, jogadores);

        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomePanel.add(buttonPanel, BorderLayout.SOUTH);

        return welcomePanel;
    }

    private JPanel getButtonPanel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas,ArrayList<Jogador> jogadores) {
        //Define o painel do botão
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton("Começar");
        buttonPanel.setBackground(corFundo);

        // Define um tamanho específico para o botão
        Dimension buttonSize = new Dimension(300, 60);
        startButton.setPreferredSize(buttonSize);

        // Define o tamanho da fonte do texto no botão
        Font buttonFont = new Font("Times New Roman", Font.BOLD, 23);
        startButton.setFont(buttonFont);
        //Define a cor do texto
        startButton.setForeground(corPerguntas);

        startButton.addActionListener(e -> {
            jogada=1;
            int index = jogo.verificacao(perguntas);
            cardPanel.add(createQuestionPanel(index, perguntas, jogo.fazResposta(perguntas, jogada, index),respostasCertas,respostasErradas,jogadores), "Question" + (jogada));
            cardLayout.next(cardPanel);

        });
        buttonPanel.add(startButton);

        return buttonPanel;
    }

    private JPanel createQuestionPanel(int index,ArrayList<Pergunta> perguntas,ArrayList respostas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas ,ArrayList<Jogador> jogadores) {

        //Define o painel da pergunta
        JPanel questionPanel = new JPanel(new BorderLayout());
        String perguntaTexto = jogo.fazPergunta(perguntas, jogada, index);
        JLabel questionLabel = new JLabel("<html>" + perguntaTexto + "</html>");
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        questionLabel.setForeground(corPerguntas);
        questionPanel.setBackground(corFundo);

        questionPanel.add(questionLabel, BorderLayout.NORTH);

        //Define painel de opções
        JPanel optionsPanel = new JPanel(new GridLayout(respostas.size(), 1));

        for (Object option : respostas) {
            JButton optionButton = new JButton(option.toString());
            optionButton.addActionListener(e -> {
                cardPanel.removeAll();
                boolean correta = verificarResposta(optionButton, perguntas, jogada,index,respostasCertas,respostasErradas);
                if(jogada<6) {
                    if(correta){
                        cardPanel.add(createRightResultPanel(perguntas,respostasCertas,respostasErradas,jogadores, index),"Right Result Question"+(jogada));
                        cardLayout.next(cardPanel);
                    }else{
                        cardPanel.add(createWrongResultPanel(perguntas,respostasCertas,respostasErradas,jogadores),"Wrong Result Question"+(jogada));
                        cardLayout.next(cardPanel);

                    }

                }

            });
            optionsPanel.add(optionButton);
        }

        questionPanel.add(optionsPanel, BorderLayout.CENTER);

        return questionPanel;
    }

    private boolean verificarResposta(JButton button, ArrayList<Pergunta> perguntas, int jogada, int index,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas) {
        //aux=0;
        String respostaSelecionada = button.getText();
        return jogo.checksAnswer(perguntas, jogada, index, respostaSelecionada,respostasCertas,respostasErradas);

    }

    private JPanel createRightResultPanel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas ,ArrayList<Jogador> jogadores, int index){

        //Define o painel de ACERTOU
        JPanel resultPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel();

        resultPanel.setBackground(corFundo);
        resultLabel.setText("ACERTOU!");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        resultLabel.setForeground(corPerguntas);


        JLabel pontosLabel = new JLabel("Ganhou " + perguntas.get(index).contas()+" pontos!!!"); // Change this message as needed
        pontosLabel.setHorizontalAlignment(JLabel.CENTER);
        pontosLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pontosLabel.setForeground(corPerguntas);

        //Painel do Botão Continuar
        JPanel continuebuttonPanel = getContinueButtonPanel(perguntas,respostasCertas,respostasErradas,jogadores);

        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(pontosLabel, BorderLayout.CENTER);
        resultPanel.add(continuebuttonPanel, BorderLayout.SOUTH);

        return resultPanel;

    }
    private JPanel createWrongResultPanel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas ,ArrayList<Jogador> jogadores){

        //Define o painel de ERROU
        JPanel resultPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel();

        resultPanel.setBackground(corFundo);
        resultLabel.setText("ERROU!");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        resultLabel.setForeground(corPerguntas);

        //Painel do Botão Continuar
        JPanel continuebuttonPanel = getContinueButtonPanel(perguntas,respostasCertas,respostasErradas,jogadores);

        resultPanel.add(resultLabel, BorderLayout.CENTER);
        resultPanel.add(continuebuttonPanel, BorderLayout.SOUTH);

        return resultPanel;
    }
    private JPanel getContinueButtonPanel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas ,ArrayList<Jogador> jogadores) {
        //Define o painel do botão
        JPanel continueButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton continueButton = new JButton("Continuar");
        continueButtonPanel.setBackground(corFundo);

        // Define um tamanho específico para o botão
        Dimension buttonSize = new Dimension(300, 60);
        continueButton.setPreferredSize(buttonSize);

        // Define o tamanho da fonte do texto no botão
        Font buttonFont = new Font("Times New Roman", Font.BOLD, 23);
        continueButton.setFont(buttonFont);
        //Define a cor do texto
        continueButton.setForeground(corBotao);

        continueButton.addActionListener(e -> {
            jogada++;
            if (jogada < 6) {
                cardPanel.removeAll();
                int index = jogo.verificacao(perguntas);
                cardPanel.add(createQuestionPanel(index,perguntas, jogo.fazResposta(perguntas, jogada, index), respostasCertas, respostasErradas ,jogadores), "Question" + (jogada));
                cardLayout.next(cardPanel);
            } else{
                cardPanel.removeAll();
                cardPanel.add(getNameInputPanel(perguntas, respostasCertas,respostasErradas,jogadores),"NameInput");
                cardLayout.next(cardPanel);
            }

        });
        continueButtonPanel.add(continueButton);


        return continueButtonPanel;
    }

    private JPanel getNameInputPanel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas,ArrayList<Jogador> jogadores){
        //Painel principal
        JPanel nameInputPanel = new JPanel(new BorderLayout());
        nameInputPanel.setBackground(corFundo);
        //Label do nome
        JLabel nameLabel = new JLabel("Introduza o seu nome:");

        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        nameLabel.setForeground(corPerguntas);
        //Painel do nameField
        JPanel nameFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField nameField = new JTextField(10); //Text Field
        nameFieldPanel.setForeground(corFundo);

        Dimension nameFieldSize = new Dimension(200, 30); //Define o tamanho
        nameField.setPreferredSize(nameFieldSize);
        nameField.setForeground(corFundo);

        //Painel do botão de confirmar
        JPanel confirmButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton("Confirmar");
        confirmButtonPanel.setBackground(corFundo);

        // Define um tamanho específico para o botão
        Dimension buttonSize = new Dimension(300, 60);
        confirmButton.setPreferredSize(buttonSize);

        // Define o tamanho da fonte do texto no botão
        Font buttonFont = new Font("Times New Roman", Font.BOLD, 23);
        confirmButton.setFont(buttonFont);
        //Define a cor do texto
        confirmButton.setForeground(corBotao);

        confirmButton.addActionListener(e -> {
            String name = nameField.getText();
            if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(nameInputPanel, "Por favor, insira um nome válido (apenas letras).", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(nameInputPanel, "Nome inserido: " + name, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                cardPanel.removeAll();
                //cardPanel.add(getWelcomePanel( perguntas, respostasCertas,respostasErradas,), "Welcome");
                cardPanel.add(getResumePanel( perguntas, respostasCertas,respostasErradas,name,jogadores), "Resume Panel");
                cardLayout.next(cardPanel);
            }
        });

        nameInputPanel.add(nameLabel,BorderLayout.NORTH);
        nameFieldPanel.add(nameField);
        nameInputPanel.add(nameField,BorderLayout.CENTER);
        confirmButtonPanel.add(confirmButton);
        nameInputPanel.add(confirmButtonPanel,BorderLayout.SOUTH);


        return nameInputPanel;
    }

    private JPanel getResumePanel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas,String nome,ArrayList<Jogador> jogadores){
        //Define o painel de Resumo do Jogo
        JPanel resumoPanel = new JPanel(null);
        resumoPanel.setBackground(corFundo);
        //Cria um novo Jogador
        Jogador j= new Jogador(nome,respostasErradas,respostasCertas);
        //Label do nome
        JLabel nameLabel = new JLabel(j.getNome());
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        nameLabel.setForeground(corPerguntas);
        nameLabel.setBounds(0, 0, 500, 50);
        //Label da Pontuação
        JLabel pontuacaoLabel = new JLabel("Pontuação: "+ jogo.pontuacao(j));
        pontuacaoLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        pontuacaoLabel.setForeground(corPerguntas);
        pontuacaoLabel.setBounds(0, 60, 500, 30);
        //Label de "certas"
        JLabel certasLabel = new JLabel("Certas: ");
        certasLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        certasLabel.setForeground(corPerguntas);
        certasLabel.setBounds(0, 100, 500, 30);
        //Label das respostas certas
        int i=0;
        for (Pergunta r : j.getCertas()) {
            JLabel respostasAcertadas = new JLabel("<html>" + r.getPergunta() + "</html>");
            respostasAcertadas.setFont(new Font("Times New Roman", Font.BOLD, 20));
            respostasAcertadas.setForeground(corPerguntas);
            respostasAcertadas.setBounds(0, 140+(i*50), 1000, 50);
            resumoPanel.add(respostasAcertadas);
            i++;
        }
        //Label de "erradas"
        JLabel erradasLabel = new JLabel("Erradas: ");
        erradasLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        erradasLabel.setForeground(corPerguntas);
        erradasLabel.setBounds(0, 400, 500, 30);
        //Label das respostas erradas
        int n=0;
        for (Pergunta r : j.getErradas()) {
            JLabel respostasIncorretas = new JLabel("<html>" + r.getPergunta() + "</html>");
            respostasIncorretas.setFont(new Font("Times New Roman", Font.BOLD, 20));
            respostasIncorretas.setForeground(corPerguntas);
            respostasIncorretas.setBounds(0, 440+(n*50), 1000, 50);
            resumoPanel.add(respostasIncorretas);
            n++;
        }


        //Botão de continuar
        JButton continueButton = new JButton("Continuar");
        continueButton.setBounds(375, 700, 300, 60);

        // Define um tamanho específico para o botão
        //Dimension buttonSize = new Dimension(300, 60);
        //continueButton.setPreferredSize(buttonSize);

        // Define o tamanho da fonte do texto no botão
        Font buttonFont = new Font("Times New Roman", Font.BOLD, 23);
        continueButton.setFont(buttonFont);
        //Define a cor do texto
        continueButton.setForeground(corBotao);
        jogo.saveData(j);

        continueButton.addActionListener(e -> {
            cardPanel.removeAll();
            cardPanel.add(getTop3Panel(perguntas,respostasCertas,respostasErradas,jogadores),"Top 3");
            cardLayout.next(cardPanel);
        });

        resumoPanel.add(erradasLabel);
        resumoPanel.add(certasLabel);
        resumoPanel.add(nameLabel);
        resumoPanel.add(pontuacaoLabel);
        resumoPanel.add(continueButton);

        return resumoPanel;

    }

    private JPanel getTop3Panel(ArrayList<Pergunta> perguntas,ArrayList<Pergunta> respostasCertas,ArrayList<Pergunta> respostasErradas ,ArrayList<Jogador> jogadores){
        //Painel principal
        JPanel top3Panel = new JPanel(null);
        top3Panel.setBackground(corFundo);
        int n=0;
        for(String s : jogo.getTop3(jogadores)){
            JLabel top3Label = new JLabel(s);
            top3Label.setFont(new Font("Times New Roman", Font.BOLD, 20));
            top3Label.setForeground(corPerguntas);
            top3Label.setBounds(0, 50+(n*150), 1000, 150);
            top3Panel.add(top3Label);
            n++;
        }

        //Botão de continuar
        JButton continueButton = new JButton("Continuar");
        continueButton.setBounds(375, 700, 300, 60);

        // Define o tamanho da fonte do texto no botão
        Font buttonFont = new Font("Times New Roman", Font.BOLD, 23);
        continueButton.setFont(buttonFont);
        //Define a cor do texto
        continueButton.setForeground(corBotao);

        continueButton.addActionListener(e -> {
            cardPanel.removeAll();
            cardPanel.add(getWelcomePanel( perguntas, respostasCertas,respostasErradas,jogadores), "Welcome");
            cardLayout.next(cardPanel);

        });

        top3Panel.add(continueButton);

        return top3Panel;

    }




}
