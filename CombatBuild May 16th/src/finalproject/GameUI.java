/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalproject;

/**
 *
 * @author msull1
 */
public class GameUI extends javax.swing.JFrame {
    //Stats: (Name, Health, Defence, Attack)
    PlayerStats player = new PlayerStats("Player", 100, 5, 10);
    EnemyStats bad1 = new EnemyStats("Evil", 50, 2, 8);
    Events events = new Events();
    /**
     * Creates new form GameUI
     */
    public GameUI() {
        initComponents();
        gameSetUp();
    }

    public void gameSetUp() {
        playerNameLabel.setText(player.getName());
        playerHealthBar.setMaximum(player.getMaxHealth());
        playerHealthBar.setValue(player.getCurrentHealth());
        playerHealthLabel.setText("HP: "+String.valueOf(player.getCurrentHealth())+"/"+String.valueOf(player.getMaxHealth()));
        playerAttackLabel.setText("ATT: "+String.valueOf(player.getAttack()));
        playerDefenceLabel.setText("DEF: "+String.valueOf(player.getDefence()));
        expBar.setValue(player.getCurrentExp());
        expLabel.setText("EXP: "+String.valueOf(player.getCurrentExp())+"/"+String.valueOf(player.getMaxExp()));
        
        enemyNameLabel.setText(bad1.getName());
        enemyHealthBar.setMaximum(bad1.getMaxHealth());
        enemyHealthBar.setValue(bad1.getCurrentHealth());
        enemyHealthLabel.setText("HP: "+String.valueOf(bad1.getCurrentHealth())+"/"+String.valueOf(bad1.getMaxHealth()));
        enemyAttackLabel.setText("ATT: "+String.valueOf(bad1.getAttack()));
        enemyDefenceLabel.setText("DEF: "+String.valueOf(bad1.getDefence()));
    }
    
    public void startCombat() {
        while(player.getCurrentHealth() > 0 && bad1.getCurrentHealth() > 0) {
            if (attackButton.getModel().isPressed()) {
                int temp = player.currentHealth;
                player.loseHealth(events.damage(bad1.getAttack(), player.getDefence()));
                if (player.currentHealth < 0) {
                    player.loseHealth(player.currentHealth);
                }
            eventTextBox.append(("\n"+player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage!"));
            playerHealthLabel.setText("HP: "+String.valueOf(player.getCurrentHealth())+"/"+String.valueOf(player.getMaxHealth()));
            playerHealthBar.setValue(player.currentHealth);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        attackButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        playerHealthLabel = new javax.swing.JLabel();
        playerHealthBar = new javax.swing.JProgressBar();
        expLabel = new javax.swing.JLabel();
        expBar = new javax.swing.JProgressBar();
        playerAttackLabel = new javax.swing.JLabel();
        playerDefenceLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventTextBox = new javax.swing.JTextArea();
        playerNameLabel = new javax.swing.JLabel();
        enemyNameLabel = new javax.swing.JLabel();
        enemyHealthLabel = new javax.swing.JLabel();
        enemyHealthBar = new javax.swing.JProgressBar();
        enemyDefenceLabel = new javax.swing.JLabel();
        enemyAttackLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField2.setText("jTextField1");

        attackButton.setText("Attack");
        attackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attackButtonMouseClicked(evt);
            }
        });

        jButton3.setText("Attack 2");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("jButton4");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        playerHealthLabel.setText("HP: 10/10");

        playerHealthBar.setForeground(new java.awt.Color(255, 51, 51));
        playerHealthBar.setName(""); // NOI18N

        expLabel.setText("Exp: 10/10");

        expBar.setForeground(new java.awt.Color(51, 51, 255));

        playerAttackLabel.setText("ATT: 6");

        playerDefenceLabel.setText("DEF: 7");

        eventTextBox.setColumns(20);
        eventTextBox.setRows(5);
        jScrollPane1.setViewportView(eventTextBox);

        playerNameLabel.setText("Player");

        enemyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        enemyNameLabel.setText("Enemy");

        enemyHealthLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        enemyHealthLabel.setText("HP: 10/10");

        enemyHealthBar.setForeground(new java.awt.Color(255, 51, 51));
        enemyHealthBar.setName(""); // NOI18N

        enemyDefenceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        enemyDefenceLabel.setText("DEF: 7");

        enemyAttackLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        enemyAttackLabel.setText("ATT: 6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expLabel)
                            .addComponent(playerHealthLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(playerHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enemyHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemyHealthLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(expBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enemyDefenceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemyAttackLabel))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(playerNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemyNameLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(attackButton)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(playerAttackLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerDefenceLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {expBar, playerHealthBar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerNameLabel)
                            .addComponent(enemyNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerHealthBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enemyHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enemyHealthLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(playerHealthLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expLabel)
                            .addComponent(expBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerAttackLabel)
                            .addComponent(playerDefenceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enemyAttackLabel)
                            .addComponent(enemyDefenceLabel))
                        .addGap(52, 52, 52)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attackButton)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {expBar, playerHealthBar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attackButtonMouseClicked
        // TODO add your handling code here:
        int temp = bad1.currentHealth;
        player.combat(bad1, events);
        eventTextBox.append(("\n"+bad1.getName()+" takes "+(temp - bad1.getCurrentHealth())+" damage!"));
        enemyHealthLabel.setText("HP: "+String.valueOf(bad1.getCurrentHealth())+"/"+String.valueOf(bad1.getMaxHealth()));
        enemyHealthBar.setValue(bad1.currentHealth);
    }//GEN-LAST:event_attackButtonMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attackButton;
    private javax.swing.JLabel enemyAttackLabel;
    private javax.swing.JLabel enemyDefenceLabel;
    private javax.swing.JProgressBar enemyHealthBar;
    private javax.swing.JLabel enemyHealthLabel;
    private javax.swing.JLabel enemyNameLabel;
    private javax.swing.JTextArea eventTextBox;
    private javax.swing.JProgressBar expBar;
    private javax.swing.JLabel expLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel playerAttackLabel;
    private javax.swing.JLabel playerDefenceLabel;
    private javax.swing.JProgressBar playerHealthBar;
    private javax.swing.JLabel playerHealthLabel;
    private javax.swing.JLabel playerNameLabel;
    // End of variables declaration//GEN-END:variables
}
