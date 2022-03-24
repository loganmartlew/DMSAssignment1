
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

    private Connection conn;

    public connectionForDB() {
        try {
            //required conn info for dmsAssignments DB
            String db = "jdbc:mysql://raptor2.aut.ac.nz:3306/dmsAssignments";
            String user = "dmsstudent4";
            String pass = "fpn871";

            conn = DriverManager.getConnection(db, user, pass);
            Statement s = conn.createStatement();

            createTableUsers();

            insertUser("Coen", "ducksareweird");

            ResultSet rs = s.executeQuery("SELECT * from vyd3379_userInfo");
            if (rs != null) // if rs == null, then there is no record in ResultSet to show  
            {
                while (rs.next()) {
                    System.out.println("________________________________________");
                    System.out.println("userName: " + rs.getString(1));
                    System.out.println("Password: " + rs.getString(2));
                    System.out.println("________________________________________");
                }
            }

            deleteUser("Coen", "ducksareweird");
            
            
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }
    
    /*
    * The below is the code for creating the table for userInfo
    * Also it has insert User(very basic atm)
    * Also it has delete User(also basic)
    */

    private void createTableUsers() {
        try {

            Statement s = conn.createStatement();
            s.execute("CREATE TABLE if not exists vyd3379_userInfo(userName varchar(20), password varchar(20))");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertUser(String userName, String password) {
        try {

            String user = userName;
            String pass = password;

            String query = "INSERT INTO vyd3379_userInfo (userName, password) "
                    + "VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);

            ps.execute();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }

    public void deleteUser(String userName, String password) {
        try {

            String user = userName;

            String query = "DELETE from vyd3379_userInfo where userName (?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(0, user);

            ps.execute();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }
    
        /*
    * The below is the code for creating the table for Products
    * Also it has insert Product(very basic atm)
    * Also it has delete Product(also basic)
    */
    
        private void createTableProducts() {
        try {

            Statement s = conn.createStatement();
            s.execute("CREATE TABLE if not exists vyd3379_products(productName varchar(20), description varchar(20), quantity varchar(3), price varchar(4)");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertProduct(String productName, String description, String quantity, String price) {
        try {

            String name = productName;
            String desc = description;
            String amount = quantity;
            String cost = price;

            String query = "INSERT INTO vyd3379_userInfo (productName, description, quantity, price) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setString(3, amount);
            ps.setString(4, cost);

            ps.execute();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }

    public void deleteProduct(String productName, String quantity) {
        try {

            String name = productName;
            String amount = quantity;

            String query = "DELETE from vyd3379_userInfo where productName (?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, amount);

            ps.execute();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }
}
