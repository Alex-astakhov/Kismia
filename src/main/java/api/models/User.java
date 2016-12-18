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

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            System.out.println("Object is null");
            return false;
        }
        if (!User.class.isAssignableFrom(obj.getClass())) {
            System.out.println("Object is other class");
            return false;
        }
        final User other = (User) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            System.out.println("Expected email: " + this.email + ", Actual email: " + other.email);
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            System.out.println("Expected password: " + this.password + ", Actual password: " + other.password);
            return false;
        }

        if ((this.userId == null) ? (other.userId != null) : !this.userId.equals(other.userId)) {
            System.out.println("Expected userId: " + this.userId + ", Actual userId: " + other.userId);
            return false;
        }
        return true;
    }
}
