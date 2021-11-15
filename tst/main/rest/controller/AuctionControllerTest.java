package main.rest.controller;

import java.time.Instant;

import main.rest.AbstractTest;
import main.rest.model.UniCorn;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import static org.junit.Assert.*;

public class AuctionControllerTest extends AbstractTest {
    UniCorn uniCorn;

    @Before
    public void setUp() {
        super.setUp();
        uniCorn = new UniCorn();
        uniCorn.setHeight(20);
        uniCorn.setWeight(25);
        uniCorn.setHornLength(25);
        uniCorn.setName("TestUniCorn");
    }

    @Test
    public void getUniCorns() throws Exception {
        String uri = "/unicorns/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                                                                .accept(MediaType.APPLICATION_JSON_VALUE))
                                 .andReturn();

        int status = mvcResult.getResponse()
                              .getStatus();
        assertEquals(200, status);
    }

    @Test
    public void createUnicornHappyPath() throws Exception {
        String uri = "/unicorns/";
        String inputJson = super.mapToJson(uniCorn);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                                                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                                .content(inputJson))
                                 .andReturn();

        int status = mvcResult.getResponse()
                              .getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse()
                                  .getContentAsString();
        assertNotNull(content);
    }

    @Test(expected = NestedServletException.class)
    public void createUnicornFailurePath() throws Exception {
        String uri = "/unicorns/";
        uniCorn.setName(null);
        String inputJson = super.mapToJson(uniCorn);
        mvc.perform(MockMvcRequestBuilders.post(uri)
                                          .contentType(MediaType.APPLICATION_JSON_VALUE)
                                          .content(inputJson))
           .andReturn();
    }

    @Test(expected = NestedServletException.class)
    public void updateUnicornFailurePath() throws Exception {
        Long id = Instant.now().toEpochMilli();
        String uri = "/unicorns/"+id;

        uniCorn.setUnicornId(id);
        String inputJson = super.mapToJson(uniCorn);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                                                                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    }
    @Test
    public void updateUnicornHappyPath() throws Exception {
        String uri = "/unicorns/";
        String inputJson = super.mapToJson(uniCorn);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                                                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                                .content(inputJson))
                                 .andReturn();
        String content = mvcResult.getResponse()
                                  .getContentAsString();
        Long id = Long.parseLong(content.substring("\"unicornId\":".length()+1, content.length()-1));
        uniCorn.setUnicornId(id);
        inputJson = super.mapToJson(uniCorn);
        uri = "/unicorns/"+id;
        mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                                                                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse()
                              .getStatus();
        assertEquals(200, status);
    }
}