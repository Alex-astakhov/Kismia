package api.models;

/**
 * Created by Alex Astakhov on 10.11.2016.
 */
public class LoginSuccess {
    private Boolean ok;

    public LoginSuccess(Boolean ok) {
        this.ok = ok;
    }

    public LoginSuccess() {
    }

    public Boolean isOk() {
        return ok;
    }
}
