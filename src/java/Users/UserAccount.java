package Users;

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
    /*
    *Below is getters and setters for UserAccount class
     */
    public boolean getIsOnline() {
        return isOnline;
    }
    
    public void setIsOnline(Boolean on){
        this.isOnline = on;
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
