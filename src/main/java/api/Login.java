package api;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

/**
 * Created by Alex Astakhov on 10.11.2016.
 */
public class Login {
    private String loginUrl = "https://kismia.com/sign/in/?new_markup";

    public HttpResponse doLogin(String email, String password){
        HttpResponse httpResponse = null;
        try {
            httpResponse = Request.Post(loginUrl).bodyString("email=" + email + "&password=" + password, ContentType.APPLICATION_FORM_URLENCODED).execute().returnResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

}
