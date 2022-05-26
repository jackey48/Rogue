/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 *
 * @author kchan3
 */
public class GameUI extends javax.swing.JFrame {
    Graphics g;
    Action UpAction;
    Action DownAction;
    Action LeftAction;
    Action RightAction;
    int CoordsX = 0;
    int CoordsY = 0;
    int length = 30;
    int width = 30;
    int[][] map = new int[length][width];
    int coord = 0;
    Player p1 = new Player(map,0,0, length, width);
    /**
     * Creates new form GameUI
     */
    public GameUI() {
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
        
        //Creating Key Binds
        UpAction = new UpAction();
        DownAction = new DownAction();
        RightAction = new RightAction();
        LeftAction = new LeftAction();
        
        //Golden boi #1
        p1.setMap(map);
        
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        jPanel1.getActionMap().put("upAction", UpAction);
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        jPanel1.getActionMap().put("downAction", DownAction);
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        jPanel1.getActionMap().put("rightAction", RightAction);
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        jPanel1.getActionMap().put("leftAction", LeftAction);
        
    }
    public class UpAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[p1.positionY][p1.positionX];
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
            CoordsY--;
            p1.setPosY(CoordsY);
            mapValue = map[p1.positionY][p1.positionX];
            g.setColor(Color.black);
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
        }
    }
    public class DownAction extends AbstractAction{
   
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[p1.positionY][p1.positionX];
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
            CoordsY++;
            p1.setPosY(CoordsY);
            mapValue = map[p1.positionY][p1.positionX];
            g.setColor(Color.black);
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
        }
    }
    public class LeftAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[p1.positionY][p1.positionX];
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
            CoordsX--;
            p1.setPosX(CoordsX);
            mapValue = map[p1.positionY][p1.positionX];
            g.setColor(Color.black);
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
        }
    }
    public class RightAction extends AbstractAction{
        
        @Override
        public void actionPerformed(ActionEvent e){
            g.setColor(Color.green);
            int mapValue = map[CoordsY][p1.positionX];
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
            CoordsX++;
            p1.setPosX(CoordsX);
            mapValue = map[CoordsY][p1.positionX];
            g.setColor(Color.black);
            g.fillRect(p1.getX(mapValue),p1.getY(mapValue,p1.getX(mapValue)),10,10);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 448, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.SHIFT_MASK);
//Action ??
        
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        g.setColor(Color.green);
        g.fillRect(0,0,400,400);
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
                
                new GameUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
