/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author Nipun
 */
public class Update extends javax.swing.JFrame {

    Connection conn = null;
    
    PreparedStatement pst = null;
    
    ResultSet rs = null;
    
    /**
     * Creates new form Update
     */
    public Update() {
        initComponents();
        
        conn = DBconnect.connect();
        
        content();
        
    }
    
    public void content(){
        try{
            
            jTextField1.setText(AdminUP.name);
            jTextField2.setText(AdminUP.num);
            jTextField3.setText(AdminUP.ckin);
            jTextField4.setText(AdminUP.ckout);
            jTextField5.setText(AdminUP.email);
           
            
        }
        catch(Exception e){
            
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 492));
        getContentPane().setLayout(null);

        jLabel1.setText("Customer name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 40, 91, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 30, 163, 30);

        jLabel2.setText("Contact Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 79, 92, 16);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 70, 163, 30);

        jLabel3.setText("Checkin Date (non-editable)");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 110, 160, 30);

        jLabel4.setText("Checkout Date (non-editable)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 150, 170, 30);

        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 190, 71, 30);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(180, 190, 163, 30);

        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 310, 71, 25);

        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 310, 59, 25);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(520, 102, 100, 30);

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser2);
        jDateChooser2.setBounds(520, 142, 100, 30);

        jLabel6.setText("New Checkin Date");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(400, 110, 110, 16);

        jLabel7.setText("New Checkout Date");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(400, 150, 120, 16);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(180, 110, 160, 30);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(180, 150, 160, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String na = jTextField1.getText();
        
        String nu = jTextField2.getText();
        
        String cik = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
        
        String cok = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
        
        String em = jTextField5.getText(); 
        
        
        
        
        String oi = "UPDATE resevationdetails SET CustomerName = '"+ na +"', ContactNo = '"+ nu +"', CheckInDate = '"+ cik +"', CheckOutDate = '"+ cok +"',Email = '"+ em +"' WHERE ReservationId = '"+ AdminUP.id +"'";
        
        try{
             pst = conn.prepareStatement(oi);
        
             pst.execute();
             
             AdminUP au = new AdminUP();
        
             this.dispose();
        
        au.setVisible(true);
             
             
        }
        catch(Exception e){
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              
        AdminUP au = new AdminUP();
        
        this.dispose();
        
        au.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
