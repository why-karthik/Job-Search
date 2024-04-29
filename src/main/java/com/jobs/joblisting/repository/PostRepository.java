package com.jobs.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobs.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
