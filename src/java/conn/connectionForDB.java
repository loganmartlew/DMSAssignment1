
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conn;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//jdbc:derby:UserDB_Ebd
/**
 *
 * @author coen-
 */
public final class connectionForDB {

    public static void main(String[] args) {
        try {
            //required conn info for dmsAssignments DB
            String db = "jdbc:mysql://raptor2.aut.ac.nz:3306/dmsAssignments";
            String user = "dmsstudent4";
            String pass = "fpn871";

            Connection conn;
            conn = DriverManager.getConnection(db, user, pass);
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
    }
}
