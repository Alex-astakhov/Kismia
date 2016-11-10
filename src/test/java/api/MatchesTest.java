package api;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Astakhov on 10.11.2016.
 */
public class MatchesTest {

    @Test
    @Parameters({"email","password","count"})
    public void nonrecurringMatches(@Optional("bevov@divismail.ru") String email, @Optional("ahtung") String password, @Optional("50") String count){
        Login login = new Login();
        HttpResponse httpResponse = login.doLogin(email, password);
        Header[] cookieHeaders = httpResponse.getHeaders("Set-Cookie");
        cookieHeaders = cookieNameSubst(cookieHeaders);
        Matches matches = new Matches();
        Set<Integer> uIds = new HashSet<>();
        for (int i = 0; i < Integer.parseInt(count); i++) {
            int id = matches.playMatches(cookieHeaders);
            System.out.println(id);
            Assert.assertTrue(uIds.add(id));
        }
    }

    private Header[] cookieNameSubst(Header[] cookieHeaders){
        Header[] newHeader = new Header[cookieHeaders.length];
        int i = 0;
        for (Header h: cookieHeaders) {
            newHeader[i++] = new BasicHeader("Cookie", h.getValue());
        }
        return newHeader;
    }
}
