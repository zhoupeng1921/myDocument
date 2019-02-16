package com.xhx.java;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TestIndexApi {

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


    /**
     * 插入操作
     * map 类型
     */
    @Test
    public  void testIndex1() throws Exception{

        Map<String, Object> content = new HashMap<>(5);
        content.put("name","小李");
        content.put("age",18);
        content.put("birthday", LocalDate.now().minusYears(18));
        content.put("description","爱好跑步，喜欢吃东西，逛街");

        IndexRequest indexRequest = new IndexRequest("people", "position", "1");
        //可以接受map类型
        indexRequest.source(content);
        indexRequest.opType(DocWriteRequest.OpType.CREATE);

        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response));

    }

    /**
     * 插入操作
     * json 类型
     */
    @Test
    public  void testIndex2() throws Exception{

        Map<String, Object> content = new HashMap<>(5);
        content.put("name","小白");
        content.put("age",23);
        content.put("birthday", LocalDate.now().minusYears(18));
        content.put("description","喜欢购物，散步，游泳");

        IndexRequest indexRequest = new IndexRequest("people", "position", "2");
        //可以接受json
        indexRequest.source(JSON.toJSONString(content), XContentType.JSON);
        indexRequest.opType(DocWriteRequest.OpType.CREATE);

        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response));

    }

    /**
     * 插入操作
     * XContentBuilder 来构造对象
     */
    @Test
    public  void testIndex3() throws Exception{

        IndexRequest indexRequest = new IndexRequest("people", "position", "3");


        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.field("name","小红");
        builder.field("age",25);
        builder.field("birthday", LocalDate.now().minusYears(25));
        builder.field("description","喜欢吃东西，旅游");
        builder.endObject();
        indexRequest.source(builder);
        indexRequest.opType(DocWriteRequest.OpType.CREATE);

        try {

            IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(JSON.toJSONString(response));
        }catch (ElasticsearchException e){
            if(e.status() == RestStatus.CONFLICT){
                System.out.println("冲突了");
            }
        }


    }

    /**
     * 插入操作
     * key pairs
     */
    @Test
    public  void testIndex4() throws Exception{

        IndexRequest indexRequest = new IndexRequest("people", "position", "4");


        indexRequest.source("name","李三","age",28,"birthday",
                LocalDate.now().minusYears(28),
                "description","爱好学习");
        indexRequest.opType(DocWriteRequest.OpType.CREATE);

        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response));

    }


    /**
     * client.index是同步的，下面介绍异步
     * client.indexAsync
     *
     * @throws Exception
     */
    @Test
    public void testIndex5() throws Exception{
        IndexRequest indexRequest = new IndexRequest("people", "position", "5");


        indexRequest.source("name","王五","age",30,"birthday",
                LocalDate.now().minusYears(30),
                "description","爱打乒乓球");
        indexRequest.opType(DocWriteRequest.OpType.CREATE);

        client.indexAsync(indexRequest, RequestOptions.DEFAULT, new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
                System.out.println(JSON.toJSONString(indexResponse));
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
        Thread.sleep(2000);
    }


}
