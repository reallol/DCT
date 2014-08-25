package com.dct.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Class for reading application's properties
 */
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

    /**
     * Gets local basic URL
     * @return base.url property value
     */
    public static String getLocalBaseURL() {
        return properties.getProperty("local.base.url");
    }

    /**
     * Gets remote basic URL
     * @return base.url property value
     */
    public static String getRemoteBaseURL() {
        return properties.getProperty("remote.base.url");
    }

    /**
     * Gets path for version checking
     * @return version.path property value
     */
    public static String getVersionPath() {
        return properties.getProperty("version.path");
    }

    /**
     * Gets path for checking triangle existence
     * @return check.triangle.path property value
     */
    public static String getCheckTrianglePath() {
        return properties.getProperty("check.triangle.path");
    }

}
