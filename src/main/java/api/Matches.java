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
    private String matchesUrl = "https://kismia.com/matches";

    public int playMatches(){
        int uid = nextMatch();
        makeRandomChoice(uid);
        return uid;

    }

    private int nextMatch() {
        HttpResponse httpResponse;
        try {
            httpResponse = Request.Get(matchesUrl).execute().returnResponse();
            HttpEntity entity = httpResponse.getEntity();
            StringBuilder source = new StringBuilder(EntityUtils.toString(entity));
            //System.out.println(source);
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
            Request.Post(matchesUrl).bodyString(body, ContentType.APPLICATION_FORM_URLENCODED).execute().returnResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
