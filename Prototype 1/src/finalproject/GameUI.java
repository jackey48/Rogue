/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalproject;

import javax.swing.KeyStroke;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author msull1
 */
public class GameUI extends javax.swing.JFrame {
    //Stats: (Name, Health, Defence, Attack)
    EnemyStats bad1 = new EnemyStats("Evil", 12, 3, 6, 30);
    Events events = new Events();
    Inventory in = new Inventory();
    Graphics g;
    Action UpAction;
    Action DownAction;
    Action LeftAction;
    Action RightAction;
    int CoordsX = 0;
    int CoordsY = 0;
    int length = 30;
    int width = 70;
    int[][] map = new int[length][width];
    int coord = 0;
    PlayerStats player = new PlayerStats("Player", 24, 3, 7, map, 0, 0, length, width);
    /**
     * Creates new form GameUI
     */
    public GameUI() {
        initComponents();
        in.addItem("Sword", "+2 ATT"); //auto equiping item
        in.equip(player);
        //Positions
        for(int row = 0; row < length; row++){
            for(int col = 0; col < width; col++){
                map[row][col] = coord;
                coord += 10;
            }
        }
        //Setting Graphics
        g = jPanel1.getGraphics();
        jPanel1.paintComponents(g);
        jPanel1.setFocusable(true);
        
        //Creating Key Binds
        UpAction = new GameUI.UpAction();
        DownAction = new GameUI.DownAction();
        RightAction = new GameUI.RightAction();
        LeftAction = new GameUI.LeftAction();
        
        //Golden boi #1
        player.setMap(map);
        
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        jPanel1.getActionMap().put("upAction", UpAction);
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        jPanel1.getActionMap().put("downAction", DownAction);
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        jPanel1.getActionMap().put("rightAction", RightAction);
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        jPanel1.getActionMap().put("leftAction", LeftAction);
        updateUI();
    }

    public void updateUI() {
        playerNameLabel.setText(player.getName());
        playerHealthBar.setMaximum(player.getMaxHealth());
        playerHealthBar.setValue(player.getCurrentHealth());
        playerHealthLabel.setText("HP: "+String.valueOf(player.getCurrentHealth())+"/"+String.valueOf(player.getMaxHealth()));
        playerAttackLabel.setText("ATT: "+String.valueOf(player.getAttack()));
        playerDefenceLabel.setText("DEF: "+String.valueOf(player.getDefence()));
        levelLabel.setText("LV: "+player.getLevel());
        expBar.setMaximum(player.getMaxExp());
        expBar.setValue(player.getCurrentExp());
        expLabel.setText("EXP: "+String.valueOf(player.getCurrentExp())+"/"+String.valueOf(player.getMaxExp()));
        
        enemyNameLabel.setText(bad1.getName());
        enemyHealthBar.setMaximum(bad1.getMaxHealth());
        enemyHealthBar.setValue(bad1.getCurrentHealth());
        enemyHealthLabel.setText("HP: "+String.valueOf(bad1.getCurrentHealth())+"/"+String.valueOf(bad1.getMaxHealth()));
        enemyAttackLabel.setText("ATT: "+String.valueOf(bad1.getAttack()));
        enemyDefenceLabel.setText("DEF: "+String.valueOf(bad1.getDefence()));
        
        inventoryTextBox.setText("");
        for (int i = 0; i < in.getInventoryLength(); i++) {
            inventoryTextBox.append(in.getItems(i)+"\n");
        }
    }

    public class UpAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[player.positionY][player.positionX];
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
            CoordsY--;
            player.setPosY(CoordsY);
            mapValue = map[player.positionY][player.positionX];
            g.setColor(Color.black);
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
        }
    }
    public class DownAction extends AbstractAction{
   
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[player.positionY][player.positionX];
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
            CoordsY++;
            player.setPosY(CoordsY);
            mapValue = map[player.positionY][player.positionX];
            g.setColor(Color.black);
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
        }
    }
    public class LeftAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[player.positionY][player.positionX];
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
            CoordsX--;
            player.setPosX(CoordsX);
            mapValue = map[player.positionY][player.positionX];
            g.setColor(Color.black);
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
        }
    }
    public class RightAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[CoordsY][player.positionX];
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
            CoordsX++;
            player.setPosX(CoordsX);
            mapValue = map[CoordsY][player.positionX];
            g.setColor(Color.black);
            g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
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

        Background = new javax.swing.JPanel();
        attackButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
        levelLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inventoryTextBox = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        attackButton.setText("Attack");
        attackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attackButtonMouseClicked(evt);
            }
        });

        jButton3.setText("Interact");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Next Room");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        playerHealthLabel.setText("HP: 10/10");

        playerHealthBar.setForeground(new java.awt.Color(255, 51, 51));
        playerHealthBar.setName(""); // NOI18N

        expLabel.setText("Exp: 10/10");

        expBar.setForeground(new java.awt.Color(51, 102, 255));

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

        levelLabel.setText("jLabel1");

        inventoryTextBox.setColumns(20);
        inventoryTextBox.setRows(5);
        jScrollPane2.setViewportView(inventoryTextBox);

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(expLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(playerHealthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playerHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(enemyHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enemyHealthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(enemyAttackLabel)
                                .addGap(18, 18, 18)
                                .addComponent(enemyDefenceLabel))))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(playerNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(levelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemyNameLabel))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(attackButton)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(playerAttackLabel)
                                .addGap(18, 18, 18)
                                .addComponent(playerDefenceLabel))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        BackgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {expBar, playerHealthBar});

        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerNameLabel)
                            .addComponent(enemyNameLabel)
                            .addComponent(levelLabel))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemyHealthBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enemyHealthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerHealthBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(playerHealthLabel))
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expLabel)
                            .addComponent(expBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerAttackLabel)
                            .addComponent(playerDefenceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enemyAttackLabel)
                            .addComponent(enemyDefenceLabel))
                        .addGap(52, 52, 52)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attackButton)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Background.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        jPanel1.requestFocus();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void attackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attackButtonMouseClicked
        // TODO add your handling code here:
        int temp = bad1.currentHealth;
        player.combat(bad1, events);
        eventTextBox.append(bad1.getName()+" takes "+(temp - bad1.getCurrentHealth())+" damage! \n");
        updateUI();
        if (bad1.getCurrentHealth() == 0) {
            eventTextBox.append(player.getName()+" gains "+bad1.getExpValue()+" exp \n");
            player.gainExp(bad1.getExpValue());
            bad1.setCurrentHealth();
            updateUI();
        }

        temp = player.currentHealth;
        bad1.actionChoose(player, events);
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
        updateUI();
    }//GEN-LAST:event_attackButtonMouseClicked

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
    private javax.swing.JPanel Background;
    private javax.swing.JButton attackButton;
    private javax.swing.JLabel enemyAttackLabel;
    private javax.swing.JLabel enemyDefenceLabel;
    private javax.swing.JProgressBar enemyHealthBar;
    private javax.swing.JLabel enemyHealthLabel;
    private javax.swing.JLabel enemyNameLabel;
    private javax.swing.JTextArea eventTextBox;
    private javax.swing.JProgressBar expBar;
    private javax.swing.JLabel expLabel;
    private javax.swing.JTextArea inventoryTextBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel playerAttackLabel;
    private javax.swing.JLabel playerDefenceLabel;
    private javax.swing.JProgressBar playerHealthBar;
    private javax.swing.JLabel playerHealthLabel;
    private javax.swing.JLabel playerNameLabel;
    // End of variables declaration//GEN-END:variables
}
