package com.dct.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    private static Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ApplicationProperties.class);

    static {
        try {
            properties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("endpoint.properties"));
        } catch (IOException e) {
            logger.error("Failed to load properties file");
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("base.url");
    }

    public static String getVersionPath() {
        return properties.getProperty("version.path");
    }

    public static String getCheckTrianglePath() {
        return properties.getProperty("check.triangle.path");
    }

}
