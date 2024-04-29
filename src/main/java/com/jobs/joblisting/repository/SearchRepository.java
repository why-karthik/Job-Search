package com.jobs.joblisting.repository;

import com.jobs.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
