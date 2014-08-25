package com.dct.client.runner;

import com.dct.client.impl.DCTClientImpl;
import com.dct.model.entities.TriangleData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 3) {
            logger.error("Missing arguments for triangle check, exiting application");
            System.exit(0);
        }
        DCTClientImpl client = new DCTClientImpl();
        client.setLocalEndpoint();
        logger.info("GET request result from service: " + client.getVersionInfo().toString());

        Double a = Double.parseDouble(args[0]);
        Double b = Double.parseDouble(args[1]);
        Double c = Double.parseDouble(args[2]);
        TriangleData data = new TriangleData(a, b, c);
        logger.info("POST request result from service: " + client.checkTriangle(data).toString());
    }
}
