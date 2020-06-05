package com.springcourse.workshopmongo.resources;

import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.dto.UserDTO;
import com.springcourse.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController //Diz que é um recurso REST
@RequestMapping(value = "/users") //Qual o caminho do endpoint?
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //diz que esse método é um endpoint também pode ser o @Getmapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        //converte a lista numa stream para poder trabalhar com expressões lambda  e diz que para cada elemento x da minha lista vai ser instanciado um elemento
        // UserDTO com as informações do elemento. Depois a stream é reconvertida para list

        return ResponseEntity.ok().body(listDto); //retorna o código http de sucesso mais o corpo da resposta

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

            User obj = service.findById(id);

            return ResponseEntity.ok().body(new UserDTO(obj));
    }
}