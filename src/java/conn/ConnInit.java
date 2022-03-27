package conn;

import java.sql.*;

/**
 *
 * @author coen
 */
public class ConnInit {
    
    public ConnInit(){}

    public Connection startDB() throws SQLException {

        //required conn info for dmsAssignments DB
        String db = "jdbc:mysql://raptor2.aut.ac.nz:3306/dmsAssignments";
        String user = "dmsstudent4";
        String pass = "fpn871";
        Connection conn;
       
        conn = DriverManager.getConnection(db, user, pass);
        
        return conn;
    }
}
