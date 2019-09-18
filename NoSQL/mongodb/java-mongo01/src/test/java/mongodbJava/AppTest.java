package mongodbJava;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

public class AppTest {


    @Before
    public void AppTest() {
        App.getConnection("127.0.0.1", 27017, "mydb", "mybaby");

    }


        @Test
        public  void TestInsertOne() {
            Document doc = new Document();
            doc.put("name","刘亦菲");
            doc.put("age",18);
            doc.put("sex","女");
            App.insertOne(doc);
            System.out.println("成功了");
        }
        @Test
        public  void TestInsertOne2() {
            Document doc = new Document();
            doc.append("name","范冰冰").append("age",18).append("sex","女");
            App.insertOne(doc);
            System.out.println("成功了");
        }
        @Test
        public  void TestInsertOne3() {
            Mybaby mybaby = new Mybaby("大S","32","女");
            String json = JSON.toJSON(mybaby).toString();
            Document doc = Document.parse(json);
            App.insertOne(doc);
            System.out.println("成功了");
        }

        @Test
        public void testFindAll() {
            FindIterable<Document> documents = App.findAll();
            for (Document document : documents) {
                System.out.println(document);
            }
        }
    @Test
    public void testUpdateOne() {
        Document doc = new Document();
        doc.append("name", "范冰冰");
        Document update = new Document();
        update.append("$set", new Document("age", 25));
        UpdateResult updateResult = App.updateOne(doc, update);
        System.out.println(updateResult);
        //AcknowledgedUpdateResult{matchedCount=1, modifiedCount=0, upsertedId=null}
    }
    @Test
    public void testUpdateMany() {
        Document doc = new Document();
        doc.append("name", "范冰冰");
        Document update = new Document();
        update.append("$set", new Document("sex", "女"));
        UpdateResult updateResult = App.updatMany(doc, update);
        System.out.println(updateResult);
        //AcknowledgedUpdateResult{matchedCount=2, modifiedCount=1, upsertedId=null}
    }

}
