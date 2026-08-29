package com.parcial.repository;

import com.parcial.model.*;
import java.util.*;

public interface IPostRepository {

    void init();

    List<Post> listAll();

    Post savePost(Post post);

    Post searchPost(int id);

}