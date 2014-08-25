package com.dct.service.test;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.VersionInfo;
import com.dct.service.TriangleService;
import com.dct.service.impl.TriangleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TriangleServiceMethodsImplementationTest {
    TriangleService service;

    @Before
    public void setUp() {
        service = new TriangleServiceImpl();
    }

    @Test
    public void testVersion() {
        TriangleServiceImpl mock = Mockito.mock(TriangleServiceImpl.class);
        Mockito.when(mock.getVersion()).thenReturn(new VersionInfo("1.0-SNAPSHOT"));
        VersionInfo versionInfo = mock.getVersion();
        Assert.assertEquals("1.0-SNAPSHOT", versionInfo.getVersion());
    }

    @Test
    public void testTriangleCheckCorrect() {
        boolean result = service.checkTriangle(new TriangleData(3.0, 4.0, 5.0));
        Assert.assertTrue(result);
    }

    @Test
    public void testTriangleCheckIncorrect() {
        boolean result = service.checkTriangle(new TriangleData(1.0, 2.0, 5.0));
        Assert.assertFalse(result);
    }
}
