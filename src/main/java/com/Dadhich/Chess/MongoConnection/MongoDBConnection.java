package com.Dadhich.Chess.MongoConnection;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MongoDBConnection {

    private static volatile MongoClient mongoClient;
    private static String databaseName;

    private MongoDBConnection() {
    }

    private static void init() {
        Properties properties = new Properties();
        try (InputStream input = MongoDBConnection.class.getClassLoader().getResourceAsStream("mongo-config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find mongo-config.properties");
            }
            properties.load(input);

            // Load the connection URI
            String connectionString = properties.getProperty("mongo.connection.uri");
            databaseName = properties.getProperty("mongo.database");

            // Create settings using the connection string
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .build();

            mongoClient = MongoClients.create(settings);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to initialize MongoDB connection", ex);
        }
    }

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            synchronized (MongoDBConnection.class) {
                if (mongoClient == null) {
                    init();
                }
            }
        }
        return mongoClient.getDatabase(databaseName);
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}