package com.ericpinto.posts.config;

import com.ericpinto.posts.domain.model.User;
import com.ericpinto.posts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User eric = new User(null, "Éric Pinto", "eric@gmail.com");
        User regis = new User(null, "Régis Pinto", "regis@gmail.com");
        User melania = new User(null, "Melânia", "mel@gmail.com");

        userRepository.insert(Arrays.asList(eric, regis, melania));
    }
}
