package com.sda.UsedCarDealerSpring.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories (basePackages = {"com.sda.UsedCarDealerSpring"})

public  class MongoConfiguration extends AbstractMongoConfiguration{
    public static final String MONGODB_BEAN_NAME = "Mongo";
    @Value("${hrprojects.mongodb.port:11289}")
    private Integer mongoPort;
    @Value("${hrprojects.mongodb.host:ds211289.mlab.com}")
    private String mongoHost;
    @Value("${hrprojects.mongodb.dbname:twitterdbsda}")
    private String mongoDBName;
    @Value("${hrprojects.mongodb.user:MagdaK}")
    private String user;
    @Value("${hrprojects.mongodb.password:tramp1975}")
    private String password;
    @Override
    protected String getDatabaseName() {
        return mongoDBName;
    }
    public @Bean(name = MONGODB_BEAN_NAME)

    Mongo mongo() throws Exception {
        MongoCredential m = MongoCredential.createCredential(user, mongoDBName, password.toCharArray());
        List<ServerAddress> addresses = new ArrayList<>();
        addresses.add(new ServerAddress(mongoHost + ":" + mongoPort));
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(m);
        return new MongoClient(addresses, credentials);
    }
}
