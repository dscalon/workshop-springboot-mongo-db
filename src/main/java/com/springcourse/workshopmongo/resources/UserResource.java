package com.springcourse.workshopmongo.resources;

import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //Diz que é um recurso REST
@RequestMapping(value = "/users") //Qual o caminho do endpoint?
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //diz que esse método é um endpoint também pode ser o @Getmapping
    public ResponseEntity<List<User>> findAll(){

        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); //retorna o código http de sucesso mais o corpo da resposta



    }

}
