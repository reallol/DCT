package com.dct.test.service;

import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.Assert;
import org.junit.Test;

public class TriangleServiceIT {
    static final String ROOT_URL = "http://localhost:8080/DCTApp";

    @Test
    public void testVersionIsCorrect() throws Exception {
        ClientRequest request = new ClientRequest(ROOT_URL + "/service/version");
        ClientResponse<VersionInfo> response = request.get(VersionInfo.class);
        VersionInfo version = response.getEntity();

        Assert.assertNotNull(version);
        Assert.assertEquals("1.0-SNAPSHOT", version.getVersion());
    }

    @Test
    public void testCorrectTriangle() throws Exception {
        ClientRequest request = new ClientRequest(ROOT_URL + "/service/checkTriangle");
        request.accept("application/json");
        request.formParameter("a", "3");
        request.formParameter("b", "4");
        request.formParameter("c", "5");
        ClientResponse<TriangleResult> response = request.post(TriangleResult.class);
        TriangleResult result = response.getEntity();

        Assert.assertNotNull(result);
        Assert.assertEquals("YES", result.getExists());
    }

    @Test
    public void testIncorrectTriangle() throws Exception {
        ClientRequest request = new ClientRequest(ROOT_URL + "/service/checkTriangle");
        request.accept("application/json");
        request.formParameter("a", "1");
        request.formParameter("b", "4");
        request.formParameter("c", "5");
        ClientResponse<TriangleResult> response = request.post(TriangleResult.class);
        TriangleResult result = response.getEntity();

        Assert.assertNotNull(result);
        Assert.assertEquals("NO", result.getExists());
    }
}
