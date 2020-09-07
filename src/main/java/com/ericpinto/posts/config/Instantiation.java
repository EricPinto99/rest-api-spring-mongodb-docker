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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User eric = new User(null, "Éric Pinto", "eric@gmail.com");
        User regis = new User(null, "Régis S Pinto", "regispinto@gmail.com");
        User mel = new User(null, "Melania Grando", "mel123@gmail.com");

        userRepository.saveAll(Arrays.asList(eric, regis, mel));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(eric));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(eric));

        postRepository.saveAll(Arrays.asList(post1, post2));

        eric.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(eric);
    }
}
