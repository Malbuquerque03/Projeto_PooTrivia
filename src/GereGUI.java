import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class GereGUI extends JFrame {
        Color corBotao= new Color(229,179,242);
        Color corLetrasBotao= new Color	(86,86,86);
        Color corPerguntas= new Color(242,162,192);
        Color corFundo= new Color(64,61,62);
        private CardLayout cardLayout;
        private JPanel cardPanel;
        private int aux;

        Jogo jogo=new Jogo();
        public GereGUI(ArrayList<Pergunta> perguntas,ArrayList<Integer> tdsrespostas,ArrayList<String> respostasCertas,ArrayList<String> respostasErradas) {

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


            tdsrespostas.clear();
            respostasCertas.clear();
            respostasErradas.clear();

            int jogada =1;
            int index;

            cardPanel.add(getWelcomePanel(), "Welcome");
            for (int i = 1; i <= 5; i++) {
                index = jogo.verificacao(perguntas,tdsrespostas);
                cardPanel.add(createQuestionPanel(index, jogada, jogo, perguntas, jogo.fazResposta(perguntas, jogada, index),respostasCertas,respostasErradas), "Question" + i);

                //if(aux==1) {
                cardPanel.add(createRightResultPanel(), "Right Result Question" + i);
                //}else if(aux==2){
                cardPanel.add(createWrongResultPanel(), "Wrong Result Question" + i);

                //}
                jogada++;
                tdsrespostas.add(index);
            }

            add(cardPanel);

        }
        private JPanel getWelcomePanel() {
            //Define o painel de Boas Vindas
            JPanel welcomePanel = new JPanel(new BorderLayout());
            welcomePanel.setBackground(corFundo);
            JLabel welcomeLabel = new JLabel("Bem-vindo ao POO Trivia!");
            welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
            welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            welcomeLabel.setForeground(corPerguntas);

            //Painel do Botão Começar
            JPanel buttonPanel = getButtonPanel();

            welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
            welcomePanel.add(buttonPanel, BorderLayout.SOUTH);

            return welcomePanel;
        }

        private JPanel getButtonPanel() {
            //Define o painel do botão
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton startButton = new JButton("Começar");
            buttonPanel.setBackground(new Color(10,186,181));

            // Define um tamanho específico para o botão
            Dimension buttonSize = new Dimension(300, 60);
            startButton.setPreferredSize(buttonSize);

            // Define o tamanho da fonte do texto no botão
            Font buttonFont = new Font("Times New Roman", Font.BOLD, 23);
            startButton.setFont(buttonFont);
            //Define a cor do texto
            startButton.setForeground(corPerguntas);

            startButton.addActionListener(e -> cardLayout.next(cardPanel));
            buttonPanel.add(startButton);

            return buttonPanel;
        }

        private JPanel createQuestionPanel(int index,int jogada,Jogo jogo,ArrayList<Pergunta> perguntas,ArrayList respostas,ArrayList<String> respostasCertas,ArrayList<String> respostasErradas ) {
            //Define o painel da pergunta
            JPanel questionPanel = new JPanel(new BorderLayout());
            String perguntaTexto = jogo.fazPergunta(perguntas,jogada,index);
            JLabel questionLabel = new JLabel("<html>" + perguntaTexto + "</html>");
            questionLabel.setFont(new Font("Times New Roman", Font.BOLD,20));
            questionLabel.setForeground(corPerguntas);
            questionPanel.setBackground(corFundo);

            questionPanel.add(questionLabel, BorderLayout.NORTH);

            //Define painel de opções
            JPanel optionsPanel = new JPanel(new GridLayout(respostas.size(), 1));

            for (Object option : respostas) {
                JButton optionButton = new JButton(option.toString());
                optionButton.addActionListener(e -> {
                    boolean correta = verificarResposta(optionButton, perguntas, jogada,index,respostasCertas,respostasErradas);

                    System.out.println("Resposta: "+correta);

//                if(correta)
//                    cardPanel.add(createRightResultPanel(), "Right Result Question" + i);
//                //}else if(aux==2){
//                else
//                    cardPanel.add(createWrongResultPanel(), "Wrong Result Question" + i);

                    if(!correta)
                        cardLayout.next(cardPanel);
                    cardLayout.next(cardPanel);
                });
                optionsPanel.add(optionButton);
            }

            questionPanel.add(optionsPanel, BorderLayout.CENTER);

            return questionPanel;
        }

        private boolean verificarResposta(JButton button, ArrayList<Pergunta> perguntas, int jogada, int index,ArrayList<String> respostasCertas,ArrayList<String> respostasErradas) {
            aux=0;
            String respostaSelecionada = button.getText();
            return jogo.checksAnswer(perguntas, jogada, index, respostaSelecionada,respostasCertas,respostasErradas);
          
        }

        private JPanel createRightResultPanel(){

            //Define o painel de ACERTOU
            JPanel resultPanel = new JPanel(new BorderLayout());
            JLabel resultLabel = new JLabel();

            resultPanel.setBackground(corFundo);
            resultLabel.setText("ACERTOU!");
            resultLabel.setHorizontalAlignment(JLabel.CENTER);
            resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            resultLabel.setForeground(corPerguntas);

            //Painel do Botão Continuar
            JPanel continuebuttonPanel = getContinueButtonPanel();

            resultPanel.add(resultLabel, BorderLayout.CENTER);
            resultPanel.add(continuebuttonPanel, BorderLayout.SOUTH);

            return resultPanel;

        }
        private JPanel createWrongResultPanel(){

            //Define o painel de ERROU
            JPanel resultPanel = new JPanel(new BorderLayout());
            JLabel resultLabel = new JLabel();

            resultPanel.setBackground(corFundo);
            resultLabel.setText("ERROU!");
            resultLabel.setHorizontalAlignment(JLabel.CENTER);
            resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            resultLabel.setForeground(corPerguntas);

            //Painel do Botão Continuar
            JPanel continuebuttonPanel = getContinueButtonPanel();

            resultPanel.add(resultLabel, BorderLayout.CENTER);
            resultPanel.add(continuebuttonPanel, BorderLayout.SOUTH);

            return resultPanel;
        }
        private JPanel getContinueButtonPanel() {
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

            continueButton.addActionListener(e -> cardLayout.next(cardPanel));
            continueButtonPanel.add(continueButton);

            return continueButtonPanel;
        }


    }



