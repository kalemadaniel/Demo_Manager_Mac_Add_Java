/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ulb-Kalema
 */
public class clsAdresses {
    
    
    
    public static Connection ConnectToDB() throws Exception {
      //Registering the Driver
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost/bd_json_msyql";
      java.sql.Connection con = DriverManager.getConnection(mysqlUrl, "root", "MQ4k4z22MhB6vD8GvsrY87du75KiNW");
      return (Connection) con;
   }
    
}
