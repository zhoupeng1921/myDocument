package mongodbJava;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Hello world!
 *
 */
public class App 
{
    private static MongoCollection<Document> collection;
    public static void getConnection(String host,int port,String dbName,String collectionName){
        MongoClient client = new MongoClient(host, port);
        MongoDatabase database = client.getDatabase(dbName);
        collection = database.getCollection(collectionName);
        System.out.println(collection);
    }

    //插入一条
    public static void insertOne(Document document){
        collection.insertOne(document);
    }

    //查询多条
    public static  FindIterable<Document> findAll(){
        FindIterable<Document> documents = collection.find();
        return documents;
    }
    //只更新第一条
    public static UpdateResult updateOne(Bson bson, Bson update){
        UpdateResult updateResult = collection.updateOne(bson, update);
        return updateResult;
    }

    //只更新第多条
    public static UpdateResult updatMany(Bson bson, Bson update){
        UpdateResult updateResult = collection.updateMany(bson, update);
        return updateResult;
    }
    //替换现有文档
    public static void replace(Bson bson, Document update){
        collection.replaceOne( bson, update);
    }
    //只删除一个
    public static void deleteOne(Bson filter){
        collection.deleteOne(filter);
    }
    public static void deleteMany(Bson filter){
        collection.deleteMany(filter);
    }

}
