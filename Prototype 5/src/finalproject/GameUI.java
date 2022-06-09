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
 * @author Matthew Sullivan and Ka Hei Chan
 */
public class GameUI extends javax.swing.JFrame {
    Graphics g;
    Action UpAction;
    Action DownAction;
    Action LeftAction;
    Action RightAction;
    int CoordsX = 1;
    int CoordsY = 1;
    int length = 30;
    int width = 70;
    int[][] map = new int[length][width];
    int coord = 0;
    //Stats: (Name, Health, Defence, Attack)
    EnemyStats bad1 = new EnemyStats("", 0, 0, 0); 
    Events events = new Events();
    Inventory in = new Inventory();
    PlayerStats player = new PlayerStats("Player", 20, 1, 4, map, 1, 1, length, width);
    boolean combat = false; //Used to see if combat is ongoing
    int combatX = 0; //Where combat is happeneing relative to the player
    int combatY = 0;
    
    /**
     * Creates new form GameUI
     */
    public GameUI() {
        in.fillItems();
        events.mapReplacer();
        initComponents();
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
        //refresh the UI when a change happens
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
            char tileColour = events.mapReader(CoordsX, CoordsY-1);
            int mapValue = map[player.positionY][player.positionX];
            if (combat == false) {
                switch (tileColour) {
                    case('W'):
                        g.setColor(Color.black);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))-10,10,10);
                        break;
                    case('o'):
                        g.setColor(Color.green);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        CoordsY--; //change player coordnates
                        player.setPosY(CoordsY);
                        mapValue = map[player.positionY][player.positionX];
                        for(int o = -10; o <= 10; o+=10) { //draw local tiles
                            for(int p = -10; p <= 10; p+=10) {
                                int tileColor = events.getColor(o/10, p/10, CoordsX, CoordsY); //get local tile color
                                switch(tileColor) { 
                                    case(1) :
                                        g.setColor(Color.green);
                                        break;
                                    case(2) :
                                        g.setColor(Color.black);
                                        break;
                                    case(3) :
                                        g.setColor(Color.red);
                                        break;
                                    case(4) :
                                        g.setColor(Color.yellow);
                                        break;
                                }
                                g.fillRect(player.getX(mapValue)+o,player.getY(mapValue,player.getX(mapValue))+p,10,10);
                            }
                        }
                        g.setColor(Color.gray);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        break;
                    case('k'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))-10,10,10);
                        bad1.generateLesserEnemyType(player.getLevel());
                        combat = true;
                        combatX = 0;
                        combatY = -1;
                        eventTextBox.append("You encounter an enemy! \n");
                        updateUI();
                        break;
                    case('e'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))-10,10,10);
                        bad1.generateEliteEnemyType(player.getLevel());
                        combat = true;
                        combatX = 0;
                        combatY = -1;
                        eventTextBox.append("You encounter an elite enemy! \n");
                        updateUI();
                        break;
                    case('b'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))-10,10,10);
                        //bad1.generateBossEnemyType(player.getLevel());
                        combat = true;
                        combatX = 0;
                        combatY = -1;
                        eventTextBox.append("You encounter a boss! \n");
                        updateUI();
                        break;
                    case('t'): 
                        g.setColor(Color.yellow);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))-10,10,10);
                        in.addItem(player.getLevel(), eventTextBox);
                        events.mapLineReplacer(0, -1, CoordsX, CoordsY);
                        updateUI();
                } 
            }
        }
    }
    public class DownAction extends AbstractAction{
   
        @Override
        public void actionPerformed(ActionEvent e){
            char tileColour = events.mapReader(CoordsX, CoordsY+1);
            int mapValue = map[player.positionY][player.positionX];
            if (combat == false) {
                switch (tileColour) {
                    case('W'):
                        g.setColor(Color.black);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))+10,10,10);
                        break;
                        case('o'):
                        g.setColor(Color.green);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        CoordsY++; //change player coordnates
                        player.setPosY(CoordsY);
                        mapValue = map[player.positionY][player.positionX];
                        for(int o = -10; o <= 10; o+=10) { //draw local tiles
                            for(int p = -10; p <= 10; p+=10) {
                                int tileColor = events.getColor(o/10, p/10, CoordsX, CoordsY); //get local tile color
                                switch(tileColor) { 
                                    case(1) :
                                        g.setColor(Color.green);
                                        break;
                                    case(2) :
                                        g.setColor(Color.black);
                                        break;
                                    case(3) :
                                        g.setColor(Color.red);
                                        break;
                                    case(4) :
                                        g.setColor(Color.yellow);
                                        break;
                                }
                                g.fillRect(player.getX(mapValue)+o,player.getY(mapValue,player.getX(mapValue))+p,10,10);
                            }
                        }
                        g.setColor(Color.gray);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        break;
                    case('k'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))+10,10,10);
                        bad1.generateLesserEnemyType(player.getLevel());
                        combat = true;
                        combatX = 0;
                        combatY = +1;
                        eventTextBox.append("You encounter an enemy! \n");
                        updateUI();
                        break;
                    case('e'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))+10,10,10);
                        bad1.generateEliteEnemyType(player.getLevel());
                        combat = true;
                        combatX = 0;
                        combatY = +1;
                        eventTextBox.append("You encounter an elite enemy! \n");
                        updateUI();
                        break;
                    case('b'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))+10,10,10);
                        //bad1.generateBossEnemyType(player.getLevel());
                        combat = true;
                        combatX = 0;
                        combatY = +1;
                        eventTextBox.append("You encounter a boss! \n");
                        updateUI();
                        break;
                    case('t'):
                        g.setColor(Color.yellow);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue))+10,10,10);
                        in.addItem(player.getLevel(), eventTextBox);
                        events.mapLineReplacer(0, 1, CoordsX, CoordsY);
                        updateUI();
                } 
            }
        }
    }
    public class LeftAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            char tileColour = events.mapReader(CoordsX-1, CoordsY);
            int mapValue = map[player.positionY][player.positionX];
            if (combat == false) {
                switch (tileColour) {
                    case('W'):
                        g.setColor(Color.black);
                        g.fillRect(player.getX(mapValue)-10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        break;
                    case('o'):
                        g.setColor(Color.green);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        CoordsX--; //change player coordnates
                        player.setPosX(CoordsX);
                        mapValue = map[player.positionY][player.positionX];
                        for(int o = -10; o <= 10; o+=10) { //draw local tiles
                            for(int p = -10; p <= 10; p+=10) {
                                int tileColor = events.getColor(o/10, p/10, CoordsX, CoordsY); //get local tile color
                                switch(tileColor) { 
                                    case(1) :
                                        g.setColor(Color.green);
                                        break;
                                    case(2) :
                                        g.setColor(Color.black);
                                        break;
                                    case(3) :
                                        g.setColor(Color.red);
                                        break;
                                    case(4) :
                                        g.setColor(Color.yellow);
                                        break;
                                }
                                g.fillRect(player.getX(mapValue)+o,player.getY(mapValue,player.getX(mapValue))+p,10,10);
                            }
                        }
                        g.setColor(Color.gray);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        break;
                    case('k'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue)-10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        bad1.generateLesserEnemyType(player.getLevel());
                        combat = true;
                        combatX = -1;
                        combatY = 0;
                        eventTextBox.append("You encounter an enemy! \n");
                        updateUI();
                        break;
                    case('e'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue)-10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        bad1.generateEliteEnemyType(player.getLevel());
                        combat = true;
                        combatX = -1;
                        combatY = 0;
                        eventTextBox.append("You encounter an elite enemy! \n");
                        updateUI();
                        break;
                    case('b'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue)-10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        //bad1.generateBossEnemyType(player.getLevel());
                        combat = true;
                        combatX = -1;
                        combatY = 0;
                        eventTextBox.append("You encounter a boss! \n");
                        updateUI();
                        break;
                    case('t'):
                        g.setColor(Color.yellow);
                        g.fillRect(player.getX(mapValue)-10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        in.addItem(player.getLevel(), eventTextBox);
                        events.mapLineReplacer(-1, 0, CoordsX, CoordsY);
                        updateUI();
                } 
            }
        }
    }
    public class RightAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            char tileColour = events.mapReader(CoordsX+1, CoordsY);
            int mapValue = map[CoordsY][player.positionX];
            if (combat == false) {
                switch (tileColour) {
                    case('W'):
                        g.setColor(Color.black);
                        g.fillRect(player.getX(mapValue)+10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        break;
                    case('o'):
                        g.setColor(Color.green);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        CoordsX++; //change player coordnates
                        player.setPosX(CoordsX);
                        mapValue = map[player.positionY][player.positionX];
                        for(int o = -10; o <= 10; o+=10) { //draw local tiles
                            for(int p = -10; p <= 10; p+=10) {
                                int tileColor = events.getColor(o/10, p/10, CoordsX, CoordsY); //get local tile color
                                switch(tileColor) { 
                                    case(1) :
                                        g.setColor(Color.green);
                                        break;
                                    case(2) :
                                        g.setColor(Color.black);
                                        break;
                                    case(3) :
                                        g.setColor(Color.red);
                                        break;
                                    case(4) :
                                        g.setColor(Color.yellow);
                                        break;
                                }
                                g.fillRect(player.getX(mapValue)+o,player.getY(mapValue,player.getX(mapValue))+p,10,10);
                            }
                        }
                        g.setColor(Color.gray);
                        g.fillRect(player.getX(mapValue),player.getY(mapValue,player.getX(mapValue)),10,10);
                        break;
                    case('k'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue)+10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        bad1.generateLesserEnemyType(player.getLevel());
                        combat = true;
                        combatX = 1;
                        combatY = 0;
                        eventTextBox.append("You encounter an enemy! \n");
                        updateUI();
                        break;
                    case('e'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue)+10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        bad1.generateEliteEnemyType(player.getLevel());
                        combat = true;
                        combatX = 1;
                        combatY = 0;
                        eventTextBox.append("You encounter an elite enemy! \n");
                        updateUI();
                        break;
                    case('b'): 
                        g.setColor(Color.red);
                        g.fillRect(player.getX(mapValue)+10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        //bad1.generateBossEnemyType(player.getLevel());
                        combat = true;
                        combatX = 1;
                        combatY = 0;
                        eventTextBox.append("You encounter a boss! \n");
                        updateUI();
                        break;
                    case('t'):
                        g.setColor(Color.yellow);
                        g.fillRect(player.getX(mapValue)+10,player.getY(mapValue,player.getX(mapValue)),10,10);
                        in.addItem(player.getLevel(), eventTextBox);
                        events.mapLineReplacer(1, 0, CoordsX, CoordsY);
                        updateUI();
                } 
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

        Background = new javax.swing.JPanel();
        attackButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
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

        inventoryButton.setText("Inventory");
        inventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryButtonMouseClicked(evt);
            }
        });
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerHealthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playerHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(enemyHealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemyHealthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(enemyAttackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemyDefenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(playerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(attackButton)
                                .addGap(18, 18, 18)
                                .addComponent(inventoryButton)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(playerAttackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerDefenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(inventoryButton)
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

    private void inventoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryButtonMouseClicked

    private void attackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attackButtonMouseClicked
        // TODO add your handling code here:
        if (combat == true) {
            int temp = bad1.currentHealth;
            player.combat(bad1, events);
            eventTextBox.append(bad1.getName()+" takes "+(temp - bad1.getCurrentHealth())+" damage! \n");
            updateUI();
            if (bad1.getCurrentHealth() == 0) {
                eventTextBox.append("Victory! \n");
                eventTextBox.append(player.getName()+" gains "+bad1.getExpValue()+" exp \n");
                player.gainExp(bad1.getExpValue());
                combat = false;
                events.mapLineReplacer(combatX, combatY, CoordsX, CoordsY);
                updateUI();
            }

            bad1.actionDo(player, events, eventTextBox);
            updateUI();
        }
        else if (combat == false) {
            eventTextBox.append("You swing at the air \n");
        }
    }//GEN-LAST:event_attackButtonMouseClicked

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        // TODO add your handling code here:
        in.equip(player, eventTextBox, false); //note: delete mode is off
        updateUI();
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        in.equip(player, eventTextBox, true); //note: delete mode is off
        updateUI();
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JButton inventoryButton;
    private javax.swing.JTextArea inventoryTextBox;
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