package com.parcial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.parcial.repository.IAuthorRepository;
import com.parcial.repository.IPostRepository;
import com.parcial.repository.impl.AuthorRepositoryImpl;
import com.parcial.repository.impl.PostRepositoryImpl;
import com.parcial.service.IAuthorService;
import com.parcial.service.IPostService;
import com.parcial.service.impl.AuthorServiceImpl;
import com.parcial.service.impl.PostServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(initMethod = "init") // Sin punto y coma al final
    public IAuthorRepository authorRepository() {
        return new AuthorRepositoryImpl();
    }

    @Bean(initMethod = "init") // Pasa authorRepository como parámetro
    public IPostRepository postRepository(IAuthorRepository authorRepository) {
        return new PostRepositoryImpl(authorRepository);
    }

    @Bean
    public IAuthorService authorService(IAuthorRepository authorRepository) {
        return new AuthorServiceImpl(authorRepository);
    }

    @Bean
    public IPostService postService(IPostRepository postRepository, IAuthorRepository authorRepository) {
        return new PostServiceImpl(postRepository, authorRepository);
    }

}
