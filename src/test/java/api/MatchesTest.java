package api;

import core.MethodsFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
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
        cookieHeaders = MethodsFactory.cookieNameSubst(cookieHeaders);
        Matches matches = new Matches();
        Set<Integer> uIds = new HashSet<>();
        for (int i = 0; i < Integer.parseInt(count); i++) {
            int id = matches.playMatches(cookieHeaders);
            System.out.println(id);
            Assert.assertTrue(uIds.add(id));
        }
    }
}
