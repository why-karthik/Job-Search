package com.jobs.joblisting.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

import com.jobs.joblisting.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;



@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("KarthikJobs");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "default")
                        .append("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("profile", "desc", "techs")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));
        
        // for (Document document : result) {
        //     Post post = mapDocumentToPost(document);
        //     posts.add(post);
        // }

        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));

        return posts;
    }


    private Post mapDocumentToPost(Document document) {
        Post post = new Post();
        post.setProfile(document.getString("profile"));
        post.setDesc(document.getString("desc"));
        post.setExp(document.getInteger("exp"));

        // Assuming "techs" is an array of strings in the document
        List<String> techsList = document.getList("techs", String.class);
        if (techsList != null) {
            post.setTechs(techsList.toArray(new String[0]));
        }

        return post;
    }
}
