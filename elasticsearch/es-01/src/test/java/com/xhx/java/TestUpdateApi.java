package com.xhx.java;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TestUpdateApi {

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
     *  ScriptType.INLINE
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        UpdateRequest updateRequest = new UpdateRequest("people", "position", "1");

        Map<String, Object> params = Map.of("age", 1);
        Script script = new Script(ScriptType.INLINE, "painless", "ctx._source.age += params.age", params);
        updateRequest.script(script);

        UpdateResponse response = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }

    /**
     *  ScriptType.STORED
     *  todo 需要先存脚本，怎么存还没研究
     *
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        UpdateRequest updateRequest = new UpdateRequest("people", "position", "1");

        Map<String, Object> params = Map.of("age", 1);
        Script script = new Script(ScriptType.STORED, null,"add-age",  params);
        updateRequest.script(script);

        UpdateResponse response = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }

    /**
     * doc 部分更新
     * 可以是map类型，json,或者XContentBuilder,也可以直接放参数
     * @throws Exception
     */
    @Test
    public void test03() throws Exception{
        UpdateRequest updateRequest = new UpdateRequest("people", "position", "1");

        Map<String,Object> params = Map.of("age",13,"birthday", LocalDate.now().minusYears(13));
        updateRequest.doc(params);

        //updateRequest.doc(JSON.toJSONString(params), XContentType.JSON);


/*        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.timeField("age", 13);
        builder.field("birthday", LocalDate.now().minusYears(13));
        builder.endObject();
        updateRequest.doc(builder);*/

        //updateRequest.doc("age",13,"birthday", LocalDate.now().minusYears(13));

        UpdateResponse response = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }


    /**
     * scriptedUpsert 不管文档是否存在，都执行script?
     * upsert 文档不存在就插入
     * @throws Exception
     */
    @Test
    public void test04() throws Exception{
        UpdateRequest updateRequest = new UpdateRequest("people", "position", "10");

        Map<String, Object> params = Map.of("age", 1);
        Script script = new Script(ScriptType.INLINE, "painless", "ctx._source.age += params.age", params);
        updateRequest.script(script);


        HashMap<String, Object> pa = new HashMap<>(params);
        pa.put("name","小文");
        updateRequest.upsert(pa);

        updateRequest.scriptedUpsert(false);

        UpdateResponse response = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }


    /**
     * docAsUpsert 更新时不存在就插入
     * @throws Exception
     */
    @Test
    public void test05() throws Exception{
        UpdateRequest updateRequest = new UpdateRequest("people", "position", "8");

        Map<String,Object> params = Map.of("age",13,"birthday",
                LocalDate.now().minusYears(13),
                "name","芳芳");
        updateRequest.doc(params);

        updateRequest.docAsUpsert(true);

        UpdateResponse response = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }
}
