package com.springcourse.workshopmongo.services;

import com.springcourse.workshopmongo.domain.Post;
import com.springcourse.workshopmongo.repository.PostRepository;
import com.springcourse.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); //o date cria uma data naquele dia a meia noite. Como a busca é menor ou
        //igual, precisamos adicionar 24h a data informada para o maxDate ser incluido na busca $$ 24h em milissegundos
        return repo.fullSearch(text, minDate, maxDate);
    }
}