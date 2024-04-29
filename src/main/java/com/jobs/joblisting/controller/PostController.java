package com.jobs.joblisting.controller;
import com.jobs.joblisting.model.Post;
import com.jobs.joblisting.repository.PostRepository;
//import com.jobs.joblisting.repository.SearchRepository;
import com.jobs.joblisting.repository.SearchRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController
{
    @Autowired
    PostRepository repo; 

    @Autowired
    SearchRepositoryImpl sRepo;

    @ApiIgnore
    @CrossOrigin
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }

    @GetMapping("posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return sRepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

}