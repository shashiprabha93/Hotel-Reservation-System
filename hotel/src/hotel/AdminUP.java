/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Nipun
 */
public class AdminUP extends javax.swing.JFrame {
    
    Connection conn = null;
    
    PreparedStatement pst = null;
    
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;

    /**
     * Creates new form AdminUP
     */
    public AdminUP() {
        initComponents();
        
        conn = DBconnect.connect();
        
        tableload();
    }
    
    public void tableload(){
        try{
            
        String n = "SELECT ReservationId, CustomerName, ContactNo, CheckInDate, CheckOutDate, Email, TotalAmount FROM resevationdetails WHERE CustomerName = '"+ AdminDetails.na +"' OR ReservationId = '"+ AdminUP.id +"'";
        
        pst = conn.prepareStatement(n);
        
        rs = pst.executeQuery();
        
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 494));
        getContentPane().setLayout(null);

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(531, 321, 70, 25);

        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(63, 321, 59, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 20, 452, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
                int z = JOptionPane.showConfirmDialog(null,"Do you want to Delete this Customer details");
        
        if(z == 0){
            
            
            
            
            
            String qa = "SELECT ReservationId, CustomerName, CheckInDate, CheckOutDate FROM resevationdetails WHERE CustomerName = '"+ AdminDetails.na +"'"; 
            
            try{
                pst = conn.prepareStatement(qa);
                
                rs = pst.executeQuery();
                
                while (rs.next()) {

                   /* int id = Integer.parseInt(rs.getString(1));*/
                     String idD = rs.getString(1);
                     String Oname = rs.getString(2);
                     String Indate = rs.getString(3); 
                     String Outdate = rs.getString(4);
                 
            
                    /* System.out.println(idD);
                     System.out.println(Oname);
                     System.out.println(Indate); */

                  /* SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                   
                    java.util.Date Indate = formatter.parse(rs.getString(3)); 
                                      
                    java.util.Date Outdate = formatter.parse(rs.getString(4)); */

                    try {

                        String qns = "INSERT INTO oldde (ReservationId, CustomerName, CheckInDate, CheckOutDate) values ('"+ idD +"', '"+ Oname +"', '"+ Indate +"','"+ Outdate +"')";

                        pst = (PreparedStatement) conn.prepareStatement(qns);

                        pst.execute();
                        
                        String fkj = "SELECT RoomId FROM reservedroom WHERE ReservationId = '"+ idD +"'";
                        
                        pst = conn.prepareStatement(fkj);
                        
                        rs1 = pst.executeQuery();
                        
                        while(rs1.next()){
                            
                            String room = rs1.getString(1);
                            
                            try{
                                
                                String vc = "UPDATE hotelrooms SET BookingStatus = 1 WHERE RoomId = '"+ room +"'";
                                
                                pst = conn.prepareStatement(vc);
                                
                                pst.execute();
                                
                            }
                            catch(Exception e){
                                
                            }
                            
                        }
                        
                        String gj = "DElETE FROM reservedroom WHERE ReservationId = '"+ idD +"'";
                        
                        
                        pst = conn.prepareStatement(gj);
                        
                        pst.execute();
                        
                       String hj = "DElETE FROM reservedservice WHERE ReservationId = '"+ idD +"'";
                        
                        
                        pst = conn.prepareStatement(hj);
                        
                        pst.execute();
                        
                       

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                
                }    
                
             /*   String xq = "DELETE FROM resevationdetails WHERE CheckOutDate < CURDATE() ";
                
                pst = conn.prepareStatement(xq);
                
                pst.execute();
                
                AdminDetails AD1 = new AdminDetails();
        
                 AD1.setVisible(true);
        
                this.dispose();*/
                
            } 
            
            catch(Exception e){
                
            } 
            
            
            
            
            
            String qav = "DELETE FROM resevationdetails WHERE CustomerName = '"+ AdminDetails.na +"'"; 
            
            try{
                pst = conn.prepareStatement(qav);
                
                pst.execute();
                
                AdminDetails AD1 = new AdminDetails();
        
                 AD1.setVisible(true);
        
                this.dispose();
                
            } 
            
            catch(Exception e){
                System.out.println(e);
            } 
            
                        try{
                String tos = "SELECT COUNT(RoomId) FROM hotelrooms WHERE BookingStatus = 1 AND RoomName = 'Deluxe' AND Bed = 'Single'";
                                
                                pst  = conn.prepareStatement(tos);
                                
                                rs2 = pst.executeQuery();
                                
                                while(rs2.next()){
                                    
                                    String countno1 = rs2.getString(1);
                                    
                                /*    int countno1 = Integer.parseInt(rs2.getString(1)); */
                                    
                                    System.out.println(countno1);
                                    
                                    try{
                                        String dg1 = "UPDATE roomtype SET AvailableRooms = '"+ countno1 +"' WHERE RoomName = 'Deluxe' AND Bed = 'Single'";
                                        
                                        pst = conn.prepareStatement(dg1);
                                        
                                        pst.execute();
                                    }
                                    
                                    catch(Exception e){
                                        
                                    }
                                    
                                }
            }
            
            catch(Exception e){
                
            }
            
             try{
                String tos = "SELECT COUNT(RoomId) FROM hotelrooms WHERE BookingStatus = 1 AND RoomName = 'Deluxe' AND Bed = 'Double'";
                                
                                pst  = conn.prepareStatement(tos);
                                
                                rs2 = pst.executeQuery();
                                
                                while(rs2.next()){
                                    
                                    String countno1 = rs2.getString(1);
                                    
                                /*    int countno1 = Integer.parseInt(rs2.getString(1)); */
                                    
                                    System.out.println(countno1);
                                    
                                    try{
                                        String dg1 = "UPDATE roomtype SET AvailableRooms = '"+ countno1 +"' WHERE RoomName = 'Deluxe' AND Bed = 'Double'";
                                        
                                        pst = conn.prepareStatement(dg1);
                                        
                                        pst.execute();
                                    }
                                    
                                    catch(Exception e){
                                        
                                    }
                                    
                                }
            }
            
            catch(Exception e){
                
            }
            
              try{
                String tos = "SELECT COUNT(RoomId) FROM hotelrooms WHERE BookingStatus = 1 AND RoomName = 'Standard' AND Bed = 'double'";
                                
                                pst  = conn.prepareStatement(tos);
                                
                                rs2 = pst.executeQuery();
                                
                                while(rs2.next()){
                                    
                                    String countno1 = rs2.getString(1);
                                    
                                /*    int countno1 = Integer.parseInt(rs2.getString(1)); */
                                    
                                    System.out.println(countno1);
                                    
                                    try{
                                        String dg1 = "UPDATE roomtype SET AvailableRooms = '"+ countno1 +"' WHERE RoomName = 'Standard' AND Bed = 'Double'";
                                        
                                        pst = conn.prepareStatement(dg1);
                                        
                                        pst.execute();
                                    }
                                    
                                    catch(Exception e){
                                        
                                    }
                                    
                                }
            }
            
            catch(Exception e){
                
            }
              
             try{
                String tos = "SELECT COUNT(RoomId) FROM hotelrooms WHERE BookingStatus = 1 AND RoomName = 'Suite' AND Bed = 'Single'";
                                
                                pst  = conn.prepareStatement(tos);
                                
                                rs2 = pst.executeQuery();
                                
                                while(rs2.next()){
                                    
                                    String countno1 = rs2.getString(1);
                                    
                                /*    int countno1 = Integer.parseInt(rs2.getString(1)); */
                                    
                                    System.out.println(countno1);
                                    
                                    try{
                                        String dg1 = "UPDATE roomtype SET AvailableRooms = '"+ countno1 +"' WHERE RoomName = 'Suite' AND Bed = 'Single'";
                                        
                                        pst = conn.prepareStatement(dg1);
                                        
                                        pst.execute();
                                    }
                                    
                                    catch(Exception e){
                                        
                                    }
                                    
                                }
            }
            
            catch(Exception e){
                
            }
             
            try{
                String tos = "SELECT COUNT(RoomId) FROM hotelrooms WHERE BookingStatus = 1 AND RoomName = 'Standard' AND Bed = 'Single'";
                                
                                pst  = conn.prepareStatement(tos);
                                
                                rs2 = pst.executeQuery();
                                
                                while(rs2.next()){
                                    
                                    String countno1 = rs2.getString(1);
                                    
                                /*    int countno1 = Integer.parseInt(rs2.getString(1)); */
                                    
                                    System.out.println(countno1);
                                    
                                    try{
                                        String dg1 = "UPDATE roomtype SET AvailableRooms = '"+ countno1 +"' WHERE RoomName = 'Standard' AND Bed = 'Single'";
                                        
                                        pst = conn.prepareStatement(dg1);
                                        
                                        pst.execute();
                                    }
                                    
                                    catch(Exception e){
                                        
                                    }
                                    
                                }
            }
            
            catch(Exception e){
                
            } 
             
             try{
                String tos = "SELECT COUNT(RoomId) FROM hotelrooms WHERE BookingStatus = 1 AND RoomName = 'Suite' AND Bed = 'Double'";
                                
                                pst  = conn.prepareStatement(tos);
                                
                                rs2 = pst.executeQuery();
                                
                                while(rs2.next()){
                                    
                                    String countno1 = rs2.getString(1);
                                    
                                /*    int countno1 = Integer.parseInt(rs2.getString(1)); */
                                    
                                    System.out.println(countno1);
                                    
                                    try{
                                        String dg1 = "UPDATE roomtype SET AvailableRooms = '"+ countno1 +"' WHERE RoomName = 'Suite' AND Bed = 'Double'";
                                        
                                        pst = conn.prepareStatement(dg1);
                                        
                                        pst.execute();
                                    }
                                    
                                    catch(Exception e){
                                        
                                    }
                                    
                                }
            }
            
            catch(Exception e){
                
            } 
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
                AdminDetails AD1 = new AdminDetails();
        
                AD1.setVisible(true);
        
                this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         
        int r = jTable1.getSelectedRow();
         id = jTable1.getValueAt(r, 0).toString();
         name = jTable1.getValueAt(r, 1).toString();
         num = jTable1.getValueAt(r, 2).toString();
         ckin = jTable1.getValueAt(r, 3).toString();
         ckout = jTable1.getValueAt(r, 4).toString();
         email = jTable1.getValueAt(r, 5).toString();
         
         
         Update up = new Update();
         
         up.setVisible(true);
         
         this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    public static String id;
    public static String name;
    public static String num;
    public static String ckin;
    public static String ckout;
    public static String email;
   
    

   
    
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
            java.util.logging.Logger.getLogger(AdminUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
