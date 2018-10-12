package com.xhx.json;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class TestJsonNode {
    ObjectMapper mapper = new ObjectMapper();
    private String str;
    {
        Map<String,Object> map = new HashMap<>();
        List<String> eles = new ArrayList<>();
        eles.add("1");
        eles.add("2");
        eles.add("3");
        map.put("id","89f-fad");
        map.put("name","手机");
        map.put("model","nokia");
        map.put("size","6.0");
        map.put("eles",eles);
        try {
            str= mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJson1() throws Exception{
        //获取JsonNode对象
        JsonNode jsonNode = mapper.readTree(str);
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        fields.forEachRemaining(field->{
            System.out.println(field.getKey()+"  "+field.getValue().asText());
        });

        JsonNode size = jsonNode.path("size");


    }


    /**
     * JsonFactory  创建json的工厂，用来创建json生成器,json解析器
     *
     * json生成器
     */
    @Test
    public void testJsonFactory() throws Exception{
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(System.out, JsonEncoding.UTF8);
        generator.writeStartObject(); //开始创建一个json对象
        generator.writeFieldName("name");
        generator.writeString("小a");
        generator.writeStringField("age","29");

        generator.writeObjectFieldStart("computer"); //开始创建一个json对象
        generator.writeStringField("model","dell");
        generator.writeEndObject();

        generator.writeArrayFieldStart("phones"); //开始创建一个json数组
        generator.writeString("nokia");
        generator.writeString("moto");
        generator.writeEndArray();

        generator.writeEndObject();
        generator.close();

        //{"name":"小a","age":"29","computer":{"model":"dell"},"phones":["nokia","moto"]}

    }

    /**
     * JsonFactory json解析器
     * @throws Exception
     */
    @Test
    public void testJsonFactory2() throws Exception{
        String str = "{\"name\":\"小a\",\"age\":\"29\",\"computer\":{\"model\":\"dell\"},\"phones\":[\"nokia\",\"moto\"]}";
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser = jsonFactory.createParser(str);
        while(parser.nextToken()!=JsonToken.END_OBJECT){
            String key = parser.getCurrentName();
            if("name".equals(key)){
                parser.nextToken();
                System.out.println(parser.getText());
            }
        }
    }



    /**
     * JsonNodeFactory 用来构造JsonNode节点  ObjectNode ArrayNode
     * @throws IOException
     */

    @Test
    public void testJsonNodeFactory() throws IOException {
        JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
        JsonFactory jsonFactory = new JsonFactory();

        ObjectNode rootNode = jsonNodeFactory.objectNode();
        rootNode.put("name","小a");
        rootNode.put("gender","女");
        //添加对象
        ObjectNode childNode = jsonNodeFactory.objectNode();
        childNode.put("child1","小大");
        childNode.put("child2","小老");
        rootNode.set("child",childNode);

        //添加数组
        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
        arrayNode.add("phone").add("mp4");
        rootNode.set("eles",arrayNode);

        JsonGenerator generator = jsonFactory.createGenerator(System.out);
        mapper.writeTree(generator,rootNode);
        //{"name":"小a","gender":"女","child":{"child1":"小大","child2":"小老"},"eles":["phone","mp4"]}

    }

    /**
     * JsonNode 用来表示Json节点的结构
     * @throws Exception
     */
    @Test
    public void testJsonNode() throws Exception{
        String str = "{\"name\":\"小a\",\"gender\":\"女\",\"child\":{\"child1\":\"小大\",\"child2\":\"小老\"},\"eles\":[\"phone\",\"mp4\"]}";
        JsonNode jsonNode = mapper.readTree(str);


        //获取根节点的某个对象
        JsonNode name = jsonNode.get("name");
        System.out.println(name.asText());

        //获取子对象节点
        JsonNode child = jsonNode.get("child");
        JsonNode child1 = child.get("child1");
        System.out.println(child1.asText());

        //获取数组节点
        JsonNode eles = jsonNode.get("eles");
        for(int i = 0; i< eles.size();i++){
            System.out.println(eles.get(i).asText());
        }


    }

}
