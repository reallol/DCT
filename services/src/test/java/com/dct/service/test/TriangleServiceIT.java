package com.dct.service.test;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Category(TriangleIntegrationTest.class)
public class TriangleServiceIT extends BaseIntegrationTestsSetup {
    private static final Logger logger = LoggerFactory.getLogger(TriangleServiceIT.class);

    @Test
    public void testLocalVersionIsCorrect() throws Exception {
        logger.debug("Testing local version info GET method");
        client.setLocalEndpoint();
        VersionInfo version = client.getVersionInfo();

        Assert.assertNotNull(version);
        Assert.assertEquals("1.0-SNAPSHOT", version.getVersion());
    }

    @Test
    public void testRemoteVersionIsCorrect() throws Exception {
        logger.debug("Testing remote version info GET method");
        client.setRemoteEndpoint();
        VersionInfo version = client.getVersionInfo();

        Assert.assertNotNull(version);
        Assert.assertEquals("1.0-SNAPSHOT", version.getVersion());
    }

    @Test
    public void testLocalCorrectTriangle() throws Exception {
        logger.debug("Testing local triangle check method for correct triangle");
        client.setLocalEndpoint();
        TriangleResult result = client.checkTriangle(new TriangleData(3.0, 4.0, 5.0));

        Assert.assertNotNull(result);
        Assert.assertEquals("YES", result.getExists());
    }

    @Test
    public void testRemoteCorrectTriangle() throws Exception {
        logger.debug("Testing remote triangle check method for correct triangle");
        client.setRemoteEndpoint();
        TriangleResult result = client.checkTriangle(new TriangleData(3.0, 4.0, 5.0));

        Assert.assertNotNull(result);
        Assert.assertEquals("YES", result.getExists());
    }

    @Test
    public void testLocalIncorrectTriangle() throws Exception {
        logger.debug("Testing local triangle check method for incorrect triangle");
        client.setLocalEndpoint();
        TriangleResult result = client.checkTriangle(new TriangleData(1.0, 4.0, 5.0));

        Assert.assertNotNull(result);
        Assert.assertEquals("NO", result.getExists());
    }

    @Test
    public void testRemoteIncorrectTriangle() throws Exception {
        logger.debug("Testing remote triangle check method for incorrect triangle");
        client.setRemoteEndpoint();
        TriangleResult result = client.checkTriangle(new TriangleData(1.0, 4.0, 5.0));

        Assert.assertNotNull(result);
        Assert.assertEquals("NO", result.getExists());
    }
}
