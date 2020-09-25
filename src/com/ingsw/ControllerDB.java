/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Marco
 */
public class ControllerDB {
    
    private static Connection getRemoteConnection() {
    if (System.getenv("RDS_HOSTNAME") != null) {
      try {
      Class.forName("org.mysql.Driver");
      String dbName = System.getenv("RDS_DB_NAME");
      String userName = System.getenv("RDS_USERNAME");
      String password = System.getenv("RDS_PASSWORD");
      String hostname = System.getenv("RDS_HOSTNAME");
      String port = System.getenv("RDS_PORT");
      String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
      //logger.trace("Getting remote connection with connection string from environment variables.");
      Connection con = DriverManager.getConnection(jdbcUrl);
      //logger.info("Remote connection successful.");
      return con;
      }
        catch (ClassNotFoundException e) { 
           // logger.warn(e.toString());
        }
        catch (java.sql.SQLException e) { 
            //logger.warn(e.toString());
        }
    }
    return null;
  }
}
