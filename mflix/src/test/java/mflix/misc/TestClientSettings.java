package mflix.misc;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.SslSettings;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestClientSettings {
    @Before
    public void setUp() {
        String URI = "mongodb+srv://mflixAppUser:mflixAppPwd@m220js-htida.mongodb.net/test?retryWrites=true&w=majority&maxPoolSize=50&wtimeout=2500&connectTimeoutMS=2000";
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(URI)).build();
        MongoClient mongoClient = MongoClients.create(settings);

// TODO do a read on the cluster to ensure you are connected
    
        SslSettings sslSettings = settings.getSslSettings();
        ReadPreference readPreference = settings.getReadPreference();
        ReadConcern readConcern = settings.getReadConcern();
        WriteConcern writeConcern = settings.getWriteConcern();
    
        System.out.println(sslSettings.toString());
        System.out.println(readPreference.toString());
        System.out.println(readConcern.asDocument().toString());
        System.out.println(writeConcern.asDocument().toString());
    }
    
    @Test
    public void printClientSettings() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
