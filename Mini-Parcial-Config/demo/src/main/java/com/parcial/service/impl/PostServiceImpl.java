package com.parcial.service.impl;

import java.util.List;

import com.parcial.model.Author;
import com.parcial.model.Post;
import com.parcial.repository.IAuthorRepository;
import com.parcial.repository.IPostRepository;
import com.parcial.service.IPostService;
import org.springframework.stereotype.Service;

public class PostServiceImpl implements IPostService {
    private IAuthorRepository authorRepository;

    private IPostRepository postRepository;

    public PostServiceImpl(IPostRepository postRepository, IAuthorRepository authorRepository) {

        this.postRepository = postRepository;
        this.authorRepository = authorRepository;

    }

    @Override
    public List<Post> listAll() {
        return postRepository.listAll();
    }

    @Override
    public Post savePost(Post post, int id) {

        Author author = authorRepository.searchAuthor(id);
        post.setAuthor(author);

        return postRepository.savePost(post);
    }

    @Override
    public Post searchPost(int id) {
        return postRepository.searchPost(id);
    }

}
