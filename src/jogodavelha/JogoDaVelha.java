/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;
/**
 *
 * @author carol
 */
public class JogoDaVelha extends javax.swing.JFrame {
    //Variáveis
    int qtde; // Variável referente à quantidade de jogadas.
    int jogador; // Variável que define que a vez de cada jogador.
    int matriz[][] = new int [3][3]; // Criação de uma matriz para o armazenamento das jogadas, possibilitando o conhecimento do ganhador, quando alguém vencer. 
    JButton b[] = new JButton[9]; // Criação de um  vetor que posteriormente irá marcar o X ou a O no devido botão.
    String jogador1, jogador2, ganhador; // Criação das variáveis jogador1 e jogador2 para armazenar os nomes dos jogadores 1 e 2, respectivamente, e da variável ganhador, que posteriormente, ao fim do jogo, receberá o nome do ganhador.
    ImageIcon X = new ImageIcon(getClass().getResource("/imagens/cancel_close_delete_exit_logout_remove_x_icon_123217.png")); // Instância para armazenar a imagem do X.
    ImageIcon O = new ImageIcon(getClass().getResource("/imagens/ios7-circle-outline_icon-icons.com_50307.png")); // Instância para armazenar a imagem do O.
    
    /**
     * Creates new form JogoDaVelha
     */
    public JogoDaVelha() { //Classe que inicia os componentes e armazena as atribuições de algumas variáveis.
        initComponents(); // Inicia os componentes.
        Color cordefundo = new Color(255, 252, 252); //Criação da instância um objeto utilizando cores do sistema RGB.
        getContentPane().setBackground(cordefundo); //Utilização desse objeto para alterar o background do JFrame.
        
        qtde = 1; // Define que o número de jogadas é igua a 1.
        jogador = 1; // Define que o primeiro a jogar será o jogador1.
        b[0] = bt_1; // Define que a posicão 0 do vetor b será equivalente ao JButton de variável bt_1.
        b[1] = bt_2; // Define que a posicão 1 do vetor b será equivalente ao JButton de variável bt_2.
        b[2] = bt_3; // Define que a posicão 2 do vetor b será equivalente ao JButton de variável bt_3.
        b[3] = bt_4; // Define que a posicão 3 do vetor b será equivalente ao JButton de variável bt_4.
        b[4] = bt_5; // Define que a posicão 4 do vetor b será equivalente ao JButton de variável bt_5.
        b[5] = bt_6; // Define que a posicão 5 do vetor b será equivalente ao JButton de variável bt_6.
        b[6] = bt_7; // Define que a posicão 6 do vetor b será equivalente ao JButton de variável bt_7.
        b[7] = bt_8; // Define que a posicão 7 do vetor b será equivalente ao JButton de variável bt_8.
        b[8] = bt_9; // Define que a posicão 8 do vetor b será equivalente ao JButton de variável bt_9.
    }
    
    public void jogada(JButton b, int x, int y){ // Método para marcar as jogadas
        b.setEnabled(false); // Faz com que os botões não estejam selecionados no iníco da jogada.
        if(jogador == 1){ // Se a variável jogador, que armazena a vez de cada jogador, for igual a 1, devem ser executados os seguintes comandos:
          matriz[x][y] = 1; // Atribui o valor 1 a posição x e y - definidas pelo clique em determinado botão - da matriz, para que seja marcada como uma jogada do jogador1. 
          b.setIcon(X); // Insere a imagem do objeto X no JButton b.
          jogador = 2; // Altera a variável jogador, para que seja a vez do jogador2.
          ganhador = jogador1; // Atribui a variável jogador1 ao ganhador, para que se sua jogada definir sua vitória, seu nome seja impresso.
          checarjogada(1); // Checa se essa jogada definiu a vitória do jogador1.
        }
        else{ // Se a condição do if for falsa, devem ser executados os comandos a seguir:
            matriz[x][y] = 2; // Atribui o valor 2 a posição x e y - definidas pelo clique em determinado botão - da matriz, para que seja marcada como uma jogada do jogador2.
            b.setIcon(O); // Insere a imagem do objeto O no JButton b.
            jogador = 1; // Altera a variável jogador, para que seja a vez do jogador1.
            ganhador = jogador2; // Atribui a variável jogador2 ao ganhador, para que se sua jogada definir sua vitória, seu nome seja impresso.
            checarjogada(2); // Checa se essa jogada definiu a vitória do jogador2.
        }
        qtde++; // Incrementa a quantidade de jogadas.
    }
    
     public void checarjogada(int x){ // Método para checar se a última jogada definiu um ganhador.
        if(vitoria(x) == true){ // Verifica se o método booleano vitoria define a vitória como uma verdade.
        JOptionPane.showMessageDialog(null, "Jogador: " + ganhador + " " + "venceu!", "Vitória", JOptionPane.INFORMATION_MESSAGE); // Utilização do JOptionPane para imprimir o nome do ganhador.
        fimjogo(); // Método para finalizar o jogo.
        }   
    }
     
    public boolean vitoria(int x){ // Método para verificar se alguém ganhou, com base na última jogada.
        for(int i = 0; i < matriz.length; i++){ // Laço de repetição utilizado para navegar pela matriz das jogadas a procura de um vencedor.
            if(matriz[i][0] == x && matriz[i][1] == x && matriz[i][2] == x){ // Verifica se há um acerto na horizontal.
                return true; // Se a condição for verdadeira, o método boolenao retornará o valor de verdade.
            }
            if(matriz[0][i] == x && matriz[1][i] == x && matriz[2][i] == x){ // Verifica se há um acerto na vertical.
                return true; // Se a condição for verdadeira, o método boolenao retornará o valor verdade.
            }
        }
        if(matriz[0][0] == x && matriz[1][1] == x && matriz[2][2] == x){ // Verifica se há um acerto na diagonal de direção \.
            return true; // Se a condição for verdadeira, o método boolenao retornará o valor verdade.
        }
        if(matriz[0][2] == x && matriz[1][1] == x && matriz[2][0] == x){ // Verifica se há um acerto na diagonal de direção /.
            return true; // Se a condição for verdadeira, o método boolenao retornará o valor verdade.
        }
            return false; // Se nenhuma condição for verdadeira, o método boolenao retornará o valor falso.
    }
    
    public void fimjogo(){ // Método utilizado para finalizar o jogo.
        for(int i = 0; i < 9; i++){ // Laço de repetição utilizado para percorrer o vetor b que tem como valores os botões.
            b[i].setEnabled(false); // Tira a seleção do botão.
        }
    }
    
    public void limpar(){ // Método para limpar os botões e as variáveis para um novo jogo.
        for(int i = 0; i < 9; i++){ // Laço de repetição que percorre os botões - valores do vetor b. 
            b[i].setEnabled(true); // Retira a seleção dos botões.
            b[i].setIcon(null); // Apaga os ícones dos botões.
        }
        for(int x = 0; x < 3; x++){ // Laço de repetição que percorre as marcações feitas pelos jogadores anteriormente, pelas linhas.
            for(int y = 0; y < 3; y++){ // Laço de repetição que percorre as marcações feitas pelos jogadores anteriormente, pelas colunas.
                matriz[x][y] = 0; //Limpa todos os valores antes associados as marcações dos jogadores.
            }
        }
        jogador = 1; // Retorna a vez para o jogador.
        jogador1 = ""; // Limpa o nome do jogador1.
        jogador2 = ""; // Limpa o nome do jogador2.
        ganhador = ""; // Limpa o nome do ganhador.
    }
    
    public void novo_jogo(){
        jogador1 = JOptionPane.showInputDialog("Digite o nome do primeiro jogador:"); // Abre uma caixa de diálogo para que seja digitado o nome do primeiro jogador.
        
        while(jogador1==null){
            jogador1 = JOptionPane.showInputDialog("Digite o nome do primeiro jogador:");
        } // Estrutura de repetição que abre uma caixa de diálogo para digitação do nome do primeiro jogador enquanto ele estiver nulo.
        
        jogador2 = JOptionPane.showInputDialog("Digite o nome do segundo jogador:"); // Abre uma caixa de diálogo para que seja digitado o nome do segundo jogador.
    
        while(jogador2==null){
            jogador2 = JOptionPane.showInputDialog("Digite o nome do segundo jogador:");
        } // Estrutura de repetição que abre uma caixa de diálogo para digitação do nome do segundo jogador enquanto ele estiver nulo.
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_1 = new javax.swing.JButton();
        bt_2 = new javax.swing.JButton();
        bt_3 = new javax.swing.JButton();
        bt_4 = new javax.swing.JButton();
        bt_5 = new javax.swing.JButton();
        bt_6 = new javax.swing.JButton();
        bt_7 = new javax.swing.JButton();
        bt_8 = new javax.swing.JButton();
        bt_9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_opcoes = new javax.swing.JMenu();
        item_novo_jogo = new javax.swing.JMenuItem();
        menu_sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bt_1.setBackground(new java.awt.Color(230, 220, 220));
        bt_1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_1.setEnabled(false);
        bt_1.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_1ActionPerformed(evt);
            }
        });

        bt_2.setBackground(new java.awt.Color(230, 220, 220));
        bt_2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_2.setEnabled(false);
        bt_2.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_2ActionPerformed(evt);
            }
        });

        bt_3.setBackground(new java.awt.Color(230, 220, 220));
        bt_3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_3.setEnabled(false);
        bt_3.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_3ActionPerformed(evt);
            }
        });

        bt_4.setBackground(new java.awt.Color(230, 220, 220));
        bt_4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_4.setEnabled(false);
        bt_4.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_4ActionPerformed(evt);
            }
        });

        bt_5.setBackground(new java.awt.Color(230, 220, 220));
        bt_5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_5.setEnabled(false);
        bt_5.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_5ActionPerformed(evt);
            }
        });

        bt_6.setBackground(new java.awt.Color(230, 220, 220));
        bt_6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_6.setEnabled(false);
        bt_6.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_6ActionPerformed(evt);
            }
        });

        bt_7.setBackground(new java.awt.Color(230, 220, 220));
        bt_7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_7.setEnabled(false);
        bt_7.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_7ActionPerformed(evt);
            }
        });

        bt_8.setBackground(new java.awt.Color(230, 220, 220));
        bt_8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_8.setEnabled(false);
        bt_8.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_8ActionPerformed(evt);
            }
        });

        bt_9.setBackground(new java.awt.Color(230, 220, 220));
        bt_9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bt_9.setEnabled(false);
        bt_9.setPreferredSize(new java.awt.Dimension(90, 90));
        bt_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_9ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/coollogo_com-27838192.png"))); // NOI18N

        menu_opcoes.setText("Opções");
        menu_opcoes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        item_novo_jogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.CTRL_MASK));
        item_novo_jogo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        item_novo_jogo.setText("Novo Jogo");
        item_novo_jogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_novo_jogoActionPerformed(evt);
            }
        });
        menu_opcoes.add(item_novo_jogo);

        jMenuBar1.add(menu_opcoes);

        menu_sair.setText("Sair");
        menu_sair.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menu_sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_sairMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(bt_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(bt_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(bt_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(bt_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_1ActionPerformed
    jogada(bt_1, 0, 0); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_1, posicionado na primeira linha e na primeira coluna.
    }//GEN-LAST:event_bt_1ActionPerformed

    private void bt_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_2ActionPerformed
    jogada(bt_2, 0, 1); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_2, posicionado na primeira linha e na segunda coluna.
    }//GEN-LAST:event_bt_2ActionPerformed

    private void bt_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_3ActionPerformed
    jogada(bt_3, 0, 2); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_3, posicionado na primeira linha e na terceira coluna.
    }//GEN-LAST:event_bt_3ActionPerformed

    private void bt_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_4ActionPerformed
    jogada(bt_4, 1, 0); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_4, posicionado na segunda linha e na primeira coluna.
    }//GEN-LAST:event_bt_4ActionPerformed

    private void bt_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_5ActionPerformed
    jogada(bt_5, 1, 1); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_5, posicionado na segunda linha e na segunda coluna.
    }//GEN-LAST:event_bt_5ActionPerformed

    private void bt_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_6ActionPerformed
    jogada(bt_6, 1, 2); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_6, posicionado na segunda linha e na terceira coluna.
    }//GEN-LAST:event_bt_6ActionPerformed

    private void bt_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_7ActionPerformed
    jogada(bt_7, 2, 0); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_7, posicionado na terceira linha e na primeira coluna.
    }//GEN-LAST:event_bt_7ActionPerformed

    private void bt_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_8ActionPerformed
    jogada(bt_8, 2, 1); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_8, posicionado na terceira linha e na segunda coluna.
    }//GEN-LAST:event_bt_8ActionPerformed

    private void bt_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_9ActionPerformed
    jogada(bt_9, 2, 2); // Executa o método jogada utilizando como parâmetros o JButton de variável bt_9, posicionado na terceira linha e na terceira coluna.
    }//GEN-LAST:event_bt_9ActionPerformed

    private void menu_sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_sairMouseClicked
    System.exit(0); // Sai da tela com um clique no item de menu sair.
    }//GEN-LAST:event_menu_sairMouseClicked

    private void item_novo_jogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_novo_jogoActionPerformed
    limpar(); // Limpar as jogadas
    novo_jogo(); // Iniciar o jogo novamente, com a definição dos novos jogadores.
    }//GEN-LAST:event_item_novo_jogoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    limpar(); // Desbloqueia os botões.
    novo_jogo(); // Inicia o jogo a partir da definição dos jogadores.
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoDaVelha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_1;
    private javax.swing.JButton bt_2;
    private javax.swing.JButton bt_3;
    private javax.swing.JButton bt_4;
    private javax.swing.JButton bt_5;
    private javax.swing.JButton bt_6;
    private javax.swing.JButton bt_7;
    private javax.swing.JButton bt_8;
    private javax.swing.JButton bt_9;
    private javax.swing.JMenuItem item_novo_jogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_opcoes;
    private javax.swing.JMenu menu_sair;
    // End of variables declaration//GEN-END:variables
}
