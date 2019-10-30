package supergenius.springboot;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author LiuBin
 * @Date 2019/9/5 11:57
 **/
public class HttpClientTest {

    @Test
    public void testHttpClient() throws Exception {
        String url = "https://accounts.google.com/o/oauth2/token";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        HttpHost proxy = new HttpHost("localhost", 1080, "https");
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        post.setConfig(config);
        post.setHeader("User-Agent", "Mozilla/5.0");
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("grant_type", "refresh_token"));
        urlParameters.add(new BasicNameValuePair("client_id", "961841571041-21f8u6kjmvhpqmj6pmn1ho27016j1ier.apps.googleusercontent.com"));
        urlParameters.add(new BasicNameValuePair("client_secret", "lmxnqEtuOJb4QzIi4eLQDJr4"));
        urlParameters.add(new BasicNameValuePair("refresh_token", "1/E7tFeactM2LhJa72qhGcZ9EApyej_X_TDPXwsOiq4Nk"));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());
    }

    @Test
    public void testOKHttp() {
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//        RequestBody body = RequestBody.create(mediaType, "grant_type=refresh_token&client_id=961841571041-21f8u6kjmvhpqmj6pmn1ho27016j1ier.apps.googleusercontent.com&client_secret=lmxnqEtuOJb4QzIi4eLQDJr4&refresh_token=1%2FE7tFeactM2LhJa72qhGcZ9EApyej_X_TDPXwsOiq4Nk");
//        Request request = new Request.Builder()
//                .url("https://accounts.google.com/o/oauth2/token")
//                .post(body)
//                .addHeader("content-type", "application/x-www-form-urlencoded")
//                .addHeader("cache-control", "no-cache")
//                .addHeader("postman-token", "e10f557b-c6d3-d83b-2186-065af9a33136")
//                .build();
//
//        Response response = client.newCall(request).execute();
    }
}
