/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Juvetic
 */
public class DBConnection {
    Connection con;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    String db = "db_sisproyektor";
    String user = "root";
    String pass = "";
    String host = "localhost";
    String port = ":3306/";
    String driver = "jdbc:mysql://";

    public DBConnection() {
        openConnection();
    }
    
    public Connection openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(driver+host+port+db, user, pass);
            System.out.println("Koneksi berhasil!");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada database!");
            System.out.println("File MySQL Connector tidak ditemukan!\n" + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Pastikan MySQL dan Apache dalam kondisi 'Start'!");
            System.out.println("Database tidak ditemukan!\n" + ex);
        }
        return con;
    }
}