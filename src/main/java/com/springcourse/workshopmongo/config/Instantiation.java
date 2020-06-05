package com.springcourse.workshopmongo.config;

import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.repository.UserRepository;
import org.apache.maven.shared.utils.cli.CommandLineCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration  //dizer para o Spring que isso é uma configuração
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll(); //limpar a coleção no mongoDB
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));


    }
}
