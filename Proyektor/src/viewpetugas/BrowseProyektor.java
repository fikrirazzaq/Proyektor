/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewpetugas;

import configdb.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juvetic
 */
public class BrowseProyektor extends javax.swing.JFrame {

    //Membuat Connection, Statement &
    Connection con;
    ResultSet rs;
    Statement stmt;
    
    DBConnection dbCon = new DBConnection();
    DefaultTableModel tabelModel;
    
    public BrowseProyektor() {
        initComponents();
        con = dbCon.openConnection();
        try {
            String sql = "SELECT pr_id, pr_nama, pr_harga, pr_stok FROM t_proyektor";
                        
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            String nmKolom [] = {"ID Proyektor", "Merk Proyektor", "Harga Sewa",
                "Stok"};
            tabelModel = new javax.swing.table.DefaultTableModel(null, nmKolom);
            
            while(rs.next()){
                String id = rs.getString(1);
                String nama = rs.getString(2);
                String harga = rs.getString(3);
                String stok = rs.getString(4);
                
                tabelModel.addRow(new String []{id, nama, harga, 
                    stok});
            }
            tblProyektor.setModel(tabelModel);
            tblProyektor.repaint();
        } catch (SQLException ex) {
            System.out.println("Data gagal ditampilkan!" + ex);
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
        tblProyektor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblProyektor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProyektor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProyektor;
    // End of variables declaration//GEN-END:variables
}
