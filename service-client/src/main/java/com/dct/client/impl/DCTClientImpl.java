package com.dct.client.impl;

import com.dct.client.BasicClient;
import com.dct.client.DCTClient;
import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import com.dct.model.exceptions.DCTClientException;
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

/**
 * Implementation for DCTClient.
 * Extends BasicClient.
 */
public class DCTClientImpl extends BasicClient implements DCTClient {
    private static final Logger logger = LoggerFactory.getLogger(DCTClientImpl.class);

    /**
     * Method creates connection and tries to send GET request to the endpoint URL.
     * @return Application version information
     * @see com.dct.client.DCTClient
     */
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
                throw new DCTClientException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                logger.debug("GET result: " + output);
                version = mapper.readValue(output, VersionInfo.class);
            }
        } catch (IOException e) {
            logger.error("Error reading responce");
            e.printStackTrace();
        } catch (DCTClientException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return version;
    }

    /**
     * Method creates connection to endpoint service and sends POST request to check if triangle is valid.
     * @param data TriangleData with all three sides specified
     * @return TriangleResult that is "YES" if triangle is valid and "NO" otherwise
     * @see com.dct.client.DCTClient
     */
    @Override
    public TriangleResult checkTriangle(TriangleData data) {
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
                throw new DCTClientException("Failed : HTTP error code : "
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
        } catch (IOException e) {
            logger.error("Error reading responce");
            e.printStackTrace();
        } catch (DCTClientException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }

        return triangleResult;
    }
}
