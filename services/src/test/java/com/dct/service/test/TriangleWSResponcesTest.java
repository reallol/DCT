package com.dct.service.test;

import javax.ws.rs.core.Response;

import com.dct.model.entities.TriangleData;
import com.dct.service.ws.TriangleWS;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class TriangleWSResponcesTest {
    TriangleWS wservice;

    @Before
    public void setUp() {
        wservice = new TriangleWS();
    }

    @Test
    public void testGetVersionResponce() throws NoSuchFieldException, IllegalAccessException {
        Response response = wservice.getVersionInfo();
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }

    @Test
    public void testCheckTriangleResponce() throws IOException {
        Response response = wservice.validateTriangle(new TriangleData(3.0, 4.0, 5.0));
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }

}
