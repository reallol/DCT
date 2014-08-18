package com.dct.client.impl;

import com.dct.client.BasicClient;
import com.dct.client.DCTClient;
import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class DCTClientImpl extends BasicClient implements DCTClient {
    private static final Logger logger = LoggerFactory.getLogger(DCTClientImpl.class);

    @Override
    public VersionInfo getVersionInfo() {
        ObjectMapper mapper = new ObjectMapper();
        HttpURLConnection conn = createConnection(PATH_VERSION);
        VersionInfo version = null;
        try {
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                logger.error("GET request failed with HTTP error code = " + conn.getResponseCode());
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                logger.debug("GET result: " + output);
                version = mapper.readValue(output, VersionInfo.class);
            }
            conn.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return version;
    }

    @Override
    public TriangleResult checkTriangle(TriangleData data) throws IllegalArgumentException {
        ObjectMapper mapper = new ObjectMapper();
        HttpURLConnection conn = createConnection(PATH_TRIANGLE);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        TriangleResult triangleResult = null;
        try {
            String json = ow.writeValueAsString(data);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            if (conn.getResponseCode() == 400) {
                logger.debug("Bad request arguments");
            } else if (conn.getResponseCode() != 200) {
                logger.error("POST request failed with HTTP error code = " + conn.getResponseCode());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                while ((output = br.readLine()) != null) {
                    logger.debug("POST result: " + output);
                    triangleResult = mapper.readValue(output, TriangleResult.class);
                }
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return triangleResult;
    }
}
