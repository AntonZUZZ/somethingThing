package Passive;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

//todo: надо переосмыслить это все. Странный класс с одиноким статическим методом

public class MongoDBConnection {

    private static MongoDatabase db;

    private MongoDBConnection() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        System.out.println("Клиент создан");

        //todo: имя базы данных надо будет передавать в конструктор
        db = mongoClient.getDatabase("test");
        System.out.println("Успешное подключение к \"" + db.getName() + "\"");
    }

    public static MongoDatabase getDb() {
        if (db == null) {
            new MongoDBConnection();
        }
        return db;
    }
}
