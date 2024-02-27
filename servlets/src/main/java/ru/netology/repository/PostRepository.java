package ru.netology.repository;

import ru.netology.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

// Stub
public class PostRepository {

  private final Map<Long, String> posts = new ConcurrentSkipListMap<>();

  public List<Post> all() {
    List<Post> res = new ArrayList<>();

    posts.forEach((k,v) -> res.add(new Post(k,v)));

    return res;
  }

  public Optional<Post> getById(long id) {
    Optional<Post> post = Optional.empty();

    if (posts.get(id) != null) {
      Post post1 = new Post(id, posts.get(id));
      post = Optional.of(post1);
    }

    return post;
  }

  public Post save(Post post) {
    posts.put(post.getId(), post.getContent());

    return post;
  }

  public void removeById(long id) {
    posts.remove(id);
  }
}
