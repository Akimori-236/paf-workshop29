package nus.iss.tfip.pafworkshop29.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import nus.iss.tfip.pafworkshop29.Constants;

@Configuration
public class MongoConfig implements Constants{
    // get mongo URL from app.properties
    @Value("${mongo.url}")
    private String mongoUrl;

    @Primary
    @Bean
    public MongoTemplate createMongoTemplate() {
        // create client
        MongoClient client = MongoClients.create(mongoUrl);
        // return template with client and database (must be correct)
        return new MongoTemplate(client, DB_ORDERS);
    }
}

