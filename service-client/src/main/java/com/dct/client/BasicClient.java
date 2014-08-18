package com.dct.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BasicClient {
    public static final String BASE_URI = ApplicationProperties.getBaseURL();
    public static final String PATH_VERSION = ApplicationProperties.getVersionPath();
    public static final String PATH_TRIANGLE = ApplicationProperties.getCheckTrianglePath();

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
