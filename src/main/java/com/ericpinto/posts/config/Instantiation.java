package com.ericpinto.posts.config;

import com.ericpinto.posts.domain.model.Post;
import com.ericpinto.posts.domain.model.User;
import com.ericpinto.posts.dto.AuthorDTO;
import com.ericpinto.posts.dto.CommentDTO;
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
        User regis = new User(null, "Régis S Pinto", "regispinto@gmail.com");
        User mel = new User(null, "Melania Grando", "mel123@gmail.com");

        userRepository.saveAll(Arrays.asList(eric, regis, mel));

        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(eric));
        Post post2 = new Post(null, simpleDateFormat.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(eric));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", simpleDateFormat.parse("21/03/2018"), new AuthorDTO(regis));
        CommentDTO comment2 = new CommentDTO("Aproveite!", simpleDateFormat.parse("22/03/2018"), new AuthorDTO(mel));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", simpleDateFormat.parse("23/03/2018"), new AuthorDTO(regis));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        eric.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(eric);
    }
}
