package com.springcourse.workshopmongo.services;

import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.dto.UserDTO;
import com.springcourse.workshopmongo.repository.UserRepository;
import com.springcourse.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){

        Optional<User> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id); //ele vai procurar primeiro, se não achar lança exceção
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}

