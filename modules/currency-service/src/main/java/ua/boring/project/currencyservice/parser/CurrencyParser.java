package ua.boring.project.currencyservice.parser;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import ua.boring.project.currencyservice.data.entity.Currency;

import java.io.IOException;

public class CurrencyParser {

    private static final String BASE_URL = "http://data.fixer.io/api/latest?access_key=";
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux i686; rv:19.0) Gecko/20100101 Firefox/19.0";
    private static final String ACCESS_KEY = "3eb87d2f2f5921cf92718d577eafcb24&format=1";

    private static String resultUrl;

    static {
        resultUrl = BASE_URL+ACCESS_KEY;
    }

    public static Currency getCurrencies() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(resultUrl);
        request.addHeader("User-Agent", USER_AGENT);
        request.addHeader("Content-Type", "text/html");

        HttpResponse response = client.execute(request);

        String resultJson = EntityUtils.toString(response.getEntity());

        return new Gson().fromJson(resultJson, Currency.class);
    }

}
