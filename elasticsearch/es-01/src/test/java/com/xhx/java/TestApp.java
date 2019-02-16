package com.xhx.java;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public class TestApp {

    private static String HOST="192.168.91.150";
    private static int PORT=9200;

    private RestClient restClient = null;
    private RestHighLevelClient restHighLevelClient = null;

    @Before
    private void testInit(){
        RestClientBuilder builder = RestClient.builder(new HttpHost(HOST, PORT));
        restClient = builder.build();
        restHighLevelClient = new RestHighLevelClient(builder);
    }

    @After
    private void testClose() throws IOException {
        restClient.close();
        restHighLevelClient.close();
    }




}
