package com.dct.test.service;

import javax.ws.rs.core.Response;

import com.dct.model.entities.TriangleData;
import com.dct.service.impl.TriangleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class TriangleServiceImplResponcesTest {

    TriangleServiceImpl service;

    @Before
    public void setUp() {
        service = new TriangleServiceImpl();
    }

    @Test
    public void testGetVersionResponce() throws NoSuchFieldException, IllegalAccessException {
        Response response = service.getVersionInfo();
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }

    @Test
    public void testCheckTriangleResponce() throws IOException {
        Response response = service.validateTriangle(new TriangleData(3.0, 4.0, 5.0));
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }

}
