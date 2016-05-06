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
public class LihatProyektor extends javax.swing.JPanel {

    //Membuat Connection, Statement &
    Connection con;
    ResultSet rs;
    Statement stmt;
    
    DBConnection dbCon = new DBConnection();
    DefaultTableModel tabelModel;
    
    public LihatProyektor() {
        initComponents();
        con = dbCon.openConnection();
        
        try {
            String sql = "SELECT * FROM t_proyektor";
                        
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            String nmKolom [] = {"ID Proyektor", "Merk", "Harga Sewa", "Stok"};
            tabelModel = new javax.swing.table.DefaultTableModel(null, nmKolom);
            
            while(rs.next()){
                String id = rs.getString(1);
                String merk = rs.getString(2);
                String harga = rs.getString(3);
                String stok = rs.getString(4);
                
                tabelModel.addRow(new String []{id, merk, harga, stok});
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

        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        txCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProyektor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnHapus.setText("Hapus");

        btnUbah.setText("Ubah");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Pencarian Berdasarkan ID Proyektor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnUbah)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnHapus))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah))
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        con = dbCon.openConnection();
        
        try {
            String sql = "SELECT * FROM t_proyektor WHERE pr_id=" + txCari.getText();
                        
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            String nmKolom [] = {"ID Proyektor", "Merk", "Harga Sewa", "Stok"};
            tabelModel = new javax.swing.table.DefaultTableModel(null, nmKolom);
            
            while(rs.next()){
                String id = rs.getString(1);
                String merk = rs.getString(2);
                String harga = rs.getString(3);
                String stok = rs.getString(4);
                
                tabelModel.addRow(new String []{id, merk, harga, stok});
            }
            tblProyektor.setModel(tabelModel);
        } catch (SQLException ex) {
            System.out.println("Data gagal ditampilkan!" + ex);
        }
    }//GEN-LAST:event_btnCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProyektor;
    private javax.swing.JTextField txCari;
    // End of variables declaration//GEN-END:variables
}
