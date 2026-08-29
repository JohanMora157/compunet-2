package com.parcial.service;

import java.util.List;

import com.parcial.model.Post;

public interface IPostService {

    List<Post> listAll();

    Post savePost(Post post, int id);

    Post searchPost(int id);

}
