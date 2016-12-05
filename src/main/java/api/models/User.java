package api.models;

/**
 * Created by Alex Astakhov on 30.11.2016.
 */
public class User {
    private String email;
    private String password;
    private String userId;

    public User(String email, String password, String userId) {
        this.email = email;
        this.password = password;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }
}
