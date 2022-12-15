package com.big3anime.database;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoBulkWriteException;
import com.mongodb.client.MongoClient;


/**
 * @author Divyanshu Tiwari
 * @brief Singleton class, will initialize DB Connection from app , can be used in other methods.
 */

public class DataBaseUtil {
    private MongoClient dbClient;
    private ConnectionString dbUri;
    private String dbUser;
    private String dbPass;
    private String dbCluster;
    private static MongoDatabase db;
    private String dbSchema;
    private static final Logger LOGGER = LogManager.getLogger(DataBaseUtil.class);

    /**
     * @brief - Static Object to be used for Imports
     */
    public static DataBaseUtil INSTANCE = new DataBaseUtil();

    private DataBaseUtil() {
        try {
            JSONObject dbDetails = new JSONObject(
                    new JSONTokener(DataBaseUtil.class.getResourceAsStream("/dbDetails.json")));
            this.dbCluster = dbDetails.getString("dbCluster");
            this.dbUser = URLEncoder.encode(dbDetails.getString("dbUserName"), "UTF-8");
            this.dbPass = URLEncoder.encode(dbDetails.getString("dbPassword"), "UTF-8");
            this.dbSchema = dbDetails.getString("dbSchema");
        } catch (JSONException ex) {
            LOGGER.error("Error while reading DataBase Details file -> {}", ex);
            return;
        } catch (UnsupportedEncodingException ex) {
            LOGGER.error("Error while encoding DataBase Details for URI -> {}", ex);
            return;
        }
        this.dbUri = new ConnectionString("mongodb+srv://" + this.dbUser + ":" + this.dbPass + "@" + this.dbCluster
                + "/?retryWrites=true&w=majority");

        this.dbClient = MongoClients.create(this.dbUri);

        DataBaseUtil.db = this.dbClient.getDatabase(this.dbSchema);

    }


    /**
     * 
     * @param collectionName type String - collectionname present in DB
     * @param doc type Document (org.bson.Document) - document Object you want to insert into DataBase
     * @return true if Document addition is succeeded, false if any error occurs
     */

    public boolean addDocumentToCollection(String collectionName, Document doc) {

        if (collectionName == null || doc == null) {
            throw new NullPointerException("Collection Name and Document cannot be Null");
        }

        try {
            MongoCollection<Document> collection = DataBaseUtil.db.getCollection(collectionName);
            collection.insertOne(doc);
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Caught Exception while writing document to Collection name : {} -> {}, ", collectionName, ex);
            return false;
        } catch (Exception ex){
            LOGGER.error("Caught Exception while writing document to Collection name : {} -> {}, ", collectionName, ex);
            return false;
        }
        return true;
    }

    public boolean addDocumentsToCollection(String collectionName, List<Document> docs) {
        if (collectionName == null || docs == null) {
            throw new NullPointerException("Collection Name and Documents cannot be Null");
        }

        try {
            MongoCollection<Document> collection = DataBaseUtil.db.getCollection(collectionName);
            collection.insertMany(docs);
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Caught Exception while writing documents to Collection name : {} -> {}, ", collectionName,
                    ex);
            return false;
        } catch (MongoBulkWriteException mbwe) {
            LOGGER.error("Caught Exception from Mongo while Bulk Writing the docs to Collection Name : {} ->  {}",
                    collectionName, mbwe);
            return false;
        }

        return true;
    }


    public List<Document> getDocumentsFromCollection(String collectionName, Map<String, Object> conditions){
        List<Document> results = new ArrayList<>();
        try {
            MongoCollection<Document> collection = DataBaseUtil.db.getCollection(collectionName);
            BasicDBObject whereQuery = new BasicDBObject(conditions);

            MongoCursor<Document> dbCursor =  collection.find(whereQuery).iterator();

            while(dbCursor.hasNext()){
                results.add(dbCursor.next());
            }

        } catch (IllegalArgumentException ex) {
            LOGGER.error("Caught Exception while fetching Documents from Collection name : {} -> {} ", collectionName,
                    ex);
            return null;
        }

        return results;
    }

    public Long deleteDocumentsFromCollection(String collectionName, Map<String, Object> conditions){
        Long resultSize;
        try {
            MongoCollection<Document> collection = DataBaseUtil.db.getCollection(collectionName);
            BasicDBObject whereQuery = new BasicDBObject(conditions);

            resultSize = collection.deleteMany(whereQuery).getDeletedCount();


        } catch (IllegalArgumentException ex) {
            LOGGER.error("Caught Exception while fetching Documents from Collection name : {} -> {} ", collectionName,
                    ex);
            return null;
        }

        return resultSize;
    }

    public boolean updateDocumentFromCollection(String collectionName, Map<String, Object> conditions, Document updates){
        try {
            MongoCollection<Document> collection = DataBaseUtil.db.getCollection(collectionName);
            BasicDBObject whereQuery = new BasicDBObject(conditions);

            collection.updateOne(whereQuery,updates);


        } catch (IllegalArgumentException ex) {
            LOGGER.error("Caught Exception while fetching Documents from Collection name : {} -> {} ", collectionName,
                    ex);
            return false;
        } 

        return true;
    }

}
