package com.springcourse.workshopmongo.repository;

import com.springcourse.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //Implemetenta as operações CRUD  com o mongo repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text); //faz com que o spring data crie para gente a query do mongodb
}
