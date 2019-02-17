package com.xhx.java;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestDeleteApi {

    private static String HOST="192.168.94.150";
    private static int PORT=9200;

    private RestClient restClient = null;
    private RestHighLevelClient client = null;

    @Before
    public void testInit(){
        RestClientBuilder builder = RestClient.builder(new HttpHost(HOST, PORT));
        restClient = builder.build();
        client = new RestHighLevelClient(builder);
    }

    @After
    public void testClose() throws IOException {
        restClient.close();
        client.close();
    }

    @Test
    public void test01() throws Exception{
        DeleteRequest deleteRequest = new DeleteRequest("people", "position", "1");


        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

    }

}
