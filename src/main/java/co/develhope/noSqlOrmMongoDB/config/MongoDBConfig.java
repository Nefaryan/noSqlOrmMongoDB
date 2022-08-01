package co.develhope.noSqlOrmMongoDB.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Override //metodo per importare il nome del DB
    protected String getDatabaseName() {
        return "DatabasePerEsercizi";
    }

    // Connesione al mongoDB e nel loro sito si recupera la stringa
    //Metodo situato nel link sotto gli import
    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://root:Dev1@testingdatabase.p9npycz.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override //Questo metodo inporta i packege
    protected Collection<String> getMappingBasePackages() {
        //return super.getMappingBasePackages(); modifica con:
        return Collections.singleton("co.develhope");
    }

    @Override // Crea automaticamente gli indici
    protected boolean autoIndexCreation() {
        return true;
    }
}
