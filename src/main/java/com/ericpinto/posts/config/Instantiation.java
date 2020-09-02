package com.ericpinto.posts.config;

import com.ericpinto.posts.domain.model.Post;
import com.ericpinto.posts.domain.model.User;
import com.ericpinto.posts.domain.model.dto.AuthorDTO;
import com.ericpinto.posts.repository.PostRepository;
import com.ericpinto.posts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User eric = new User(null, "Éric Pinto", "eric@gmail.com");
        User regis = new User(null, "Régis Pinto", "regis@gmail.com");
        User melania = new User(null, "Melânia", "mel@gmail.com");

        userRepository.insert(Arrays.asList(eric, regis, melania));

        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP abraços!", new AuthorDTO(eric));
        Post post2 = new Post(null, simpleDateFormat.parse("23/03/2018"), "Bom dia", "Acordei feliz", new AuthorDTO(eric));

        postRepository.insert(Arrays.asList(post1, post2));
    }
}
