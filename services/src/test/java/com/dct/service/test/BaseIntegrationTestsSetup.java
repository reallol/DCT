package com.dct.service.test;

import com.dct.client.DCTClient;
import com.dct.client.impl.DCTClientImpl;
import org.junit.Before;

public abstract class BaseIntegrationTestsSetup {
    DCTClient client;

    @Before
    public void setUp() {
        client = new DCTClientImpl();
    }
}
