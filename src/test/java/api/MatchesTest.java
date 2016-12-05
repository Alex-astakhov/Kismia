package api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Alex Astakhov on 10.11.2016.
 */
public class MatchesTest {

    @Test
    @Parameters({"email","password"})
    public void tryLogin(@Optional("bevov@divismail.ru") String email, @Optional("ahtung") String password) throws IOException {
        Login login = new Login();
        HttpResponse httpResponse = login.doLogin(email, password);
        HttpEntity entity = httpResponse.getEntity();
        Assert.assertEquals("", EntityUtils.toString(entity));
    }



    @Test(dependsOnMethods = "tryLogin")
    @Parameters({"count"})
    public void nonrecurringMatches(@Optional("50") String count) throws InterruptedException {
        Matches matches = new Matches();
        Set<Integer> uIds = new HashSet<>();
        for (int i = 0; i < Integer.parseInt(count); i++) {
            int id = matches.playMatches();
            System.out.println(id);
            Assert.assertTrue(uIds.add(id));
        }
    }
}
