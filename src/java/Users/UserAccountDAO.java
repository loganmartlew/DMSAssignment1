package Users;

import java.text.*;
import java.util.*;
import java.sql.*;
import conn.ConnInit;

/**
 * @author coen
 */
public class UserAccountDAO {

    static ConnInit init = null;
    static Connection conn = null;
    static ResultSet rs = null;

    public static UserAccount login(UserAccount user) {

        Statement st = null;

        String username = user.getUserName();
        String password = user.getPassword();

        String searchQuery = "SELECT * from vyd3379_userInfo where userName="
                + username + "AND password=" + password + "";

        System.out.println("Your username is :" + username);
        System.out.println("Your password is :" + password);
        System.out.println("Query :" + searchQuery);

        try {

            init = new ConnInit();
            conn = init.startDB();

            st = conn.createStatement();
            rs = st.executeQuery(searchQuery);
            boolean next = rs.next();

            if (!next) {
                System.out.println("Sorry you are not a registered "
                        + "user please sign up first");
                user.setIsOnline(false);
            } else if (next) {
                String uName = rs.getString("userName");

                System.out.println("Welcome " + uName);
                user.setIsOnline(true);
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                }
                st = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }

                conn = null;
            }
        }

        return user;

    }

}
