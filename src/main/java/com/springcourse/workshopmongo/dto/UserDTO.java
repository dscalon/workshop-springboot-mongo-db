package com.springcourse.workshopmongo.dto;

import com.springcourse.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {  //Uma classe DTO é uma classe de Data Transfer Object. É uma forma de customizar os objetos trafegados de acordo com a necessidade
//    reduzindo assim o tráfego de dados e protegendo os dados trafegados



    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User obj) {  //forma automatizada de instanciar um UserDTO a partir de um user
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
