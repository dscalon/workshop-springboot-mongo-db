package com.springcourse.workshopmongo.repository;

import com.springcourse.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository  //Implemetenta as operações CRUD  com o mongo repository
public interface PostRepository extends MongoRepository<Post, String> {
}
