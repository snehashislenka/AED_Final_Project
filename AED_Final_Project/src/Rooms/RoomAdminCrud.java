/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Rooms;

/**
 *
 * @author Anshul
 */
public class RoomAdminCrud extends javax.swing.JPanel {

    /**
     * Creates new form RoomAdminPanel
     */
    public RoomAdminCrud() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jTextField12 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField11 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 600, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room Number", "Type", "Desc", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 580, 170));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 600, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 600, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Create");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 600, 30));

        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 150, 30));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 200, 30));
        add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 30));
        add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 200, 30));

        jLabel15.setText("Price");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel16.setText("Desc");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 20));

        jLabel17.setText("Type");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 20));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 10));
        add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 200, 30));

        jLabel19.setText("Room No");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jButton5.setText("Submit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 150, 30));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 200, 30));
        add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 200, 30));
        add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 200, 30));

        jLabel18.setText("Price");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 20));

        jLabel20.setText("Desc");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, 20));

        jLabel21.setText("Type");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, 20));
        add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 200, 30));

        jLabel22.setText("Room No");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
