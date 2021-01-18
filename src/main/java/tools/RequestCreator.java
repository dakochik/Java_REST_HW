package tools;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Class with only one method, which makes request to website by it's uri.
 */
public class RequestCreator {
    /**
     * Gets data from website by URI.
     *
     * @param path path to website.
     * @return string made from the response to the site request.
     * @throws IOException              if there are problems with connection
     * @throws IllegalArgumentException if the uri is invalid
     */
    public static String getRequest(String path) throws IOException, IllegalArgumentException {

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(new HttpGet(path))) {

            HttpEntity entity = response.getEntity();
            return IOUtils.toString(entity.getContent());
        }
    }
}
