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
    private Header accept = new BasicHeader("Accept","application/json, text/javascript, */*; q=0.01");
    private Header origin = new BasicHeader("Origin","https://kismia.com");
    private Header xRequestWith = new BasicHeader("X-Requested-With","XMLHttpRequest");
    private Header userAgent = new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
    private Header contentType = new BasicHeader("Content-Type","application/x-www-form-urlencoded");
    private Header referer = new BasicHeader("Referer","https://kismia.com/");
    private Header acceptEncoding = new BasicHeader("Accept-Encoding","gzip, deflate, br");
    private Header acceptLanguage = new BasicHeader("Accept-Language","ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4,uk;q=0.2");
    private String loginUrl = "https://kismia.com/sign/in/?new_markup";

    private Header[] headers = {accept, origin, xRequestWith, userAgent, contentType, referer, acceptEncoding, acceptLanguage};

    public HttpResponse doLogin(String email, String password){
        HttpResponse httpResponse = null;
        try {
            httpResponse = Request.Post(loginUrl).setHeaders(headers).bodyString("email=" + email + "&password=" + password, ContentType.APPLICATION_FORM_URLENCODED).execute().returnResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

}
