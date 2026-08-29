package com.parcial.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.parcial.model.Author;
import com.parcial.model.Post;
import com.parcial.repository.IAuthorRepository;
import com.parcial.repository.IPostRepository;

public class PostRepositoryImpl implements IPostRepository {

    private List<Post> posts = new ArrayList<>();
    private int idCounter = 1;

    private IAuthorRepository authorRepository;

    public PostRepositoryImpl(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void init() {

        posts.clear();
        savePost(new Post(0, "Post1", "Imagen").setAuthor(authorRepository.searchAuthor(1)));
        savePost(new Post(0, "Post2", "Video").setAuthor(authorRepository.searchAuthor(2)));
        savePost(new Post(0, "Post3", "Reel").setAuthor(authorRepository.searchAuthor(3)));
        savePost(new Post(0, "Post4", "TikTok").setAuthor(authorRepository.searchAuthor(4)));
        savePost(new Post(0, "Post5", "Boomerang").setAuthor(authorRepository.searchAuthor(5)));
        savePost(new Post(0, "Post6", "Nota").setAuthor(authorRepository.searchAuthor(6)));

    }

    @Override
    public List<Post> listAll() {

        return posts;

    }

    @Override
    public Post savePost(Post post) {

        if (post == null) {
            return null;
        } else {

            post.setId(idCounter++);
            posts.add(post);
            return post;

        }

    }

    @Override
    public Post searchPost(int id) {
        for (Post post : posts) {

            if (post.getId() == id) {
                return post;
            }
        }

        return null;

    }

}
