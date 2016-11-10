package api;

import core.MethodsFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Alex Astakhov on 10.11.2016.
 */
public class Matches {
    private Header accept = new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
    private Header upgradeInsequre = new BasicHeader("Upgrade-Insecure-Requests", "1");
    private Header origin = new BasicHeader("Origin","https://kismia.com");
    private Header userAgent = new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
    private Header contentType = new BasicHeader("Content-Type","application/x-www-form-urlencoded");
    private Header referer = new BasicHeader("Referer","https://kismia.com/matches");
    private Header acceptEncoding = new BasicHeader("Accept-Encoding","gzip, deflate, br");
    private Header acceptLanguage = new BasicHeader("Accept-Language","ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4,uk;q=0.2");

    private Header[] headers = {origin, upgradeInsequre, userAgent, contentType, accept, referer, acceptEncoding, acceptLanguage};
    private String matchesUrl = "https://kismia.com/matches";

    public int playMatches(Header[] cookieHeaders){
        int uid = nextMatch(cookieHeaders);
        makeRandomChoice(uid);
        return uid;

    }

    private int nextMatch(Header[] cookieHeaders) {
        HttpResponse httpResponse;
        try {
            httpResponse = Request.Get(matchesUrl).setHeaders(headers).setHeaders(cookieHeaders).execute().returnResponse();
            HttpEntity entity = httpResponse.getEntity();
            StringBuilder source = new StringBuilder(EntityUtils.toString(entity));
            source = MethodsFactory.cutStringBuilder(source, "name=\"user_id\"");
            return Integer.parseInt(MethodsFactory.cutStringBuilder(source, "value=\"", "\"").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void makeRandomChoice(int userId){
        Random random = new Random();
        String answer = String.valueOf(random.nextInt(3) + 1);
        String body = "answer=" + answer + "&referer_url=" + matchesUrl + "&reply=1" + "&user_id=" + String.valueOf(userId);


        try {
            Request.Post(matchesUrl).setHeaders(headers)
                    .bodyString(body, ContentType.APPLICATION_FORM_URLENCODED).execute().returnResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
