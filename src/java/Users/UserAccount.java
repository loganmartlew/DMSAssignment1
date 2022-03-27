package Users;

import conn.ConnInit;
import java.sql.*;
import java.util.logging.Logger;

/**
 *
 * @author coen
 */
public class UserAccount {

    private String userName;
    private String password;

    Boolean isOnline = false;

    public UserAccount() {
    }

    public void createUser(String uName, String pWord) {

        Connection conn;
        ConnInit init = new ConnInit();

        try {
            conn = init.startDB();

            String user = uName;
            String pass = pWord;

            PreparedStatement st = conn.prepareStatement("SELECT * from vyd3379_userInfo where username=?");
            st.setString(1, user);
            ResultSet results = st.executeQuery();
            
            if (results.next()) {
                System.out.println("user already exist in database!");

            } else {
                String query = "INSERT into vyd3379_userInfo where userName=? and password=?";

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2, pass);

                ps.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());

        }
    }

    public void logoutSystem() {
        isOnline = false;
    }

    public Boolean loginSystem() {

        Connection conn;
        ConnInit init = new ConnInit();

        try {
            conn = init.startDB();

            PreparedStatement pS = conn.prepareStatement("SELECT userName from vyd3379_userInfo where userName=? and password=?");
            pS.setString(1, userName);
            pS.setString(2, password);

            ResultSet results = pS.executeQuery();

            if (results.next()) {
                userName = results.getString(1);
                password = results.getString(2);
                isOnline = true;

            } else {
                pS.close();
                conn.close();
                isOnline = false;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());

        }
        return isOnline;
    }

    /*
    *Below is getters and setters for UserAccount class
     */
    public boolean getIsOnline() {
        return isOnline;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String uName) {
        this.userName = uName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String pWord) {
        this.password = pWord;
    }
}
