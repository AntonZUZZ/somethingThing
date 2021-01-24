package Passive;

import com.mongodb.DB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

//идея состоит в том, что есть что-то, что изменяется каждые N миллисекунд. Пусть это будет азываться ресурс.
public class Resources {
    //todo по таймауту увеличивать на +10 какое-то поле в базе данных
    //если превысит лимит в 100, то перестать увеличивать

    //То что сейчас написано это чисто для примера, чтобы пощупать монго,
    // в дальнейшем это можно будет записать в докуметацию. как пример работы с БД

    //бпза данных todo: опять же, чисто чтобы попробовать, статические переменные надо бы убрать в итоге
    public static MongoDatabase db;
    public static void main(String[] args)
    {
        //получаю MongoDatabase
        db = MongoDBConnection.getDb();

        //

        //записываю определенный документ в существующую коллекцию
        Document doc = new Document();
        doc.put("name", "vasa");            //Записываем название
        doc.put("num", 42);                 //Записываем смысл

        db.getCollection("forumUsers").insertOne(doc);
    }
}
