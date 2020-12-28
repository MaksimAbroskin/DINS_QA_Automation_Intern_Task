import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Client {
    static Gson gson = new Gson();

    public String get(String endpoint) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(endpoint);
        return executeResponse(httpclient, httpGet);
    }

    public <T> String post(String endpoint, T obj) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(endpoint);
        String request = gson.toJson(obj);
        httpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(request.getBytes())));
        return executeResponse(httpclient, httpPost);
    }

    public <T> String put(String endpoint, T obj) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(endpoint);
        String request = gson.toJson(obj);
        httpPut.setEntity(new InputStreamEntity(new ByteArrayInputStream(request.getBytes())));
        return executeResponse(httpclient, httpPut);
    }

    public String delete(String endpoint) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(endpoint);
        return executeResponse(httpclient, httpDelete);
    }

    String executeResponse(CloseableHttpClient httpclient, HttpUriRequest httpRequest) {
        String text = null;
        try (CloseableHttpResponse response1 = httpclient.execute(httpRequest)) {
            HttpEntity entity1 = response1.getEntity();
            if (entity1 != null) {
                try (InputStream inStream = entity1.getContent()) {
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    int nRead;
                    byte[] data = new byte[1024];
                    while ((nRead = inStream.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, nRead);
                    }
                    buffer.flush();
                    text = buffer.toString(StandardCharsets.UTF_8);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
