/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ulb-Kalema
 */
public class clsAdresses {
    
    private String adress;
    private String desi_eqpmt;
    private int id_adresse;
    private String statut;
    
    public static Connection ConnectToDB() throws Exception {
      //Registering the Driver
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost/bd_Adresse_Mac";
      java.sql.Connection con = DriverManager.getConnection(mysqlUrl, "root", "MQ4k4z22MhB6vD8GvsrY87du75KiNW");
      return (Connection) con;
   }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the desi_eqpmt
     */
    public String getDesi_eqpmt() {
        return desi_eqpmt;
    }

    /**
     * @param desi_eqpmt the desi_eqpmt to set
     */
    public void setDesi_eqpmt(String desi_eqpmt) {
        this.desi_eqpmt = desi_eqpmt;
    }

    /**
     * @return the id_adresse
     */
    public int getId_adresse() {
        return id_adresse;
    }

    /**
     * @param id_adresse the id_adresse to set
     */
    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    //La procedure pour inserer les donnees dans la base 
    public void insertdata(clsAdresses add){
        try {
            Connection con = ConnectToDB();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO tb_adresses_mac (`desi_eqpmt`, `adress`, `statut`) values (?,?,?)");
            pstmt.setString(1, add.getDesi_eqpmt());
            pstmt.setString(2, add.getAdress());
            pstmt.setString(3, add.getStatut());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(clsAdresses.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
     //La procedure pour modifier les donnees dans la base 
    public void updatedata(clsAdresses add){
        try {
            Connection con = ConnectToDB();
            PreparedStatement pstmt = con.prepareStatement("UPDATE tb_adresses_mac SET `desi_eqpmt`=?, `adress`=?, `statut`=? WHERE id_adresse=?");
            pstmt.setString(1, add.getDesi_eqpmt());
            pstmt.setString(2, add.getAdress());
            pstmt.setString(3, add.getStatut());
            pstmt.setInt(4, add.getId_adresse());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(clsAdresses.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void chargement(JTable tbl) throws SQLException {
        try {
            Connection con = ConnectToDB();
            PreparedStatement st = con.prepareStatement("SELECT `id_adresse` AS ID, `desi_eqpmt` AS EQUIPEMENT, `adress` AS AD_MAC, `statut` AS STATUT FROM `tb_adresses_mac`");
            ResultSet rs = st.executeQuery();
            tbl.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        } catch (Exception ex) {
            Logger.getLogger(clsAdresses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
   public int testerDroit(String nom) throws SQLException {
        int val = 0;
        try {
            Connection con = ConnectToDB();
            PreparedStatement st = con.prepareStatement("SELECT * FROM `tb_adresses_mac` WHERE `adress` = '" + nom + "' AND `statut`= 'Activé' ");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                val=1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }
        return val;
    }
    
}
