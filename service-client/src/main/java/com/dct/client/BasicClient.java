package com.dct.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class that takes each client common features.
 * Those include base URL, paths and connection creation.
 */
public class BasicClient {
    public static final String BASE_URI = ApplicationProperties.getBaseURL();
    public static final String PATH_VERSION = ApplicationProperties.getVersionPath();
    public static final String PATH_TRIANGLE = ApplicationProperties.getCheckTrianglePath();

    /**
     * Creates HttpURLConnection to base URL for path specified
     * @param path
     * @return Connection
     */
    public HttpURLConnection createConnection(String path) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(BASE_URI + path);
            connection = (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
