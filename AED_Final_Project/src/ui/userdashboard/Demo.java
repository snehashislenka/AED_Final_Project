/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.userdashboard;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;

/**
 *
 * @author slenk
 */
public class Demo extends javax.swing.JPanel {

    /**
     * Creates new form demo
     */
    public Demo() {
        initComponents();
        setLayout(new GridLayout(2, 3, 0, 0));
                
//        setAlignmentX(CENTER_ALIGNMENT);
        for(int i = 0; i < 1; i++) {
            for (int j=0; j<3; j++) {
                JLabel lbl = new JLabel("Demo");
                lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//                lbl.setSize(100, 200);
                this.add(lbl); 
//                if(i%2 == 0) {
//                    JSeparator sep = new JSeparator();
//                    this.add(sep);
//                } else {
//                    this.add(lbl);  
//                }
                
    //            this.add(new JSeparator());
            }
//            JSeparator sep = new JSeparator();
//            this.add(sep);
        }
        
//        JSeparator sep = new JSeparator();
//        this.add(sep);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}