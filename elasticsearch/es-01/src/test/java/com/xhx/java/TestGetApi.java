package com.xhx.java;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestGetApi {

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
        GetRequest getRequest = new GetRequest("people", "position", "1");
        //不获取source
//        FetchSourceContext context = new FetchSourceContext(false);
//        getRequest.fetchSourceContext(context);

//        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);


        //获取指定列
        String[] includes = new String[]{"name","age"};
        String[] excludes = Strings.EMPTY_ARRAY;

        FetchSourceContext context = new FetchSourceContext(true,includes,excludes);
        getRequest.fetchSourceContext(context);

        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getSource()));

    }


    /**
     * 判断数据是否存在
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        GetRequest getRequest = new GetRequest("people", "position", "10");
        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);


        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);

    }

}
