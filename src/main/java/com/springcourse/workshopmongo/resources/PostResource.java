package com.springcourse.workshopmongo.resources;

import com.springcourse.workshopmongo.domain.Post;
import com.springcourse.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Diz que é um recurso REST
@RequestMapping(value = "/posts") //Qual o caminho do endpoint?
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}