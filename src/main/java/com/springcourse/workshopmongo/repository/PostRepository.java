package com.springcourse.workshopmongo.repository;

import com.springcourse.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //Implemetenta as operações CRUD  com o mongo repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    //?0 diz que a expressão regular é o primeiro paramêtro da chamada da função
    List<Post> searchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text); //faz com que o spring data crie para gente a query do mongodb


}
