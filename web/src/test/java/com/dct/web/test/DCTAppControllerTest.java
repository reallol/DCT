package com.dct.web.test;

import com.dct.client.DCTClient;
import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import com.dct.web.controller.DCTAppController;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-dispatcher-servlet.xml"})
@WebAppConfiguration
@Category(DCTAppIntegrationTest.class)
public class DCTAppControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DCTClient clientMock;

    @InjectMocks
    private DCTAppController appController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
    }

    @Test
    public void getVersionTest() throws Exception {

        when(clientMock.getVersionInfo()).thenReturn(new VersionInfo("1.0-SNAPSHOT"));

        mockMvc.perform(get("/service/version"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(),
                        Charset.forName("utf8"))))
                .andExpect(jsonPath("version", is("1.0-SNAPSHOT")));

    }

    @Test
    public void triangleCheckTest() throws Exception {
        when(clientMock.checkTriangle(new TriangleData(3.0, 4.0, 5.0))).thenReturn(new TriangleResult(true));

        mockMvc.perform(post("/service/checkTriangle")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("a", "3")
                        .param("b", "4")
                        .param("c", "5")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(),
                        Charset.forName("utf8"))))
                .andExpect(jsonPath("exists", is("YES")));
    }
}
