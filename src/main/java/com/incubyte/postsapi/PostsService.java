package com.incubyte.postsapi;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PostsService {

  private final JsonPlaceholderPostsGateway jsonPlaceholderPostsGateway;

  public PostsService(JsonPlaceholderPostsGateway jsonPlaceholderPostsGateway) {
    this.jsonPlaceholderPostsGateway = jsonPlaceholderPostsGateway;
  }

  public Mono<List<Post>> getAll() {
    return jsonPlaceholderPostsGateway.getAll();
  }

  public Mono<Post> getById(Integer id) {
    return jsonPlaceholderPostsGateway.getById(id);
  }

  public Mono<List<Comment>> getCommentsForPostById(Integer id) {
    return jsonPlaceholderPostsGateway.getCommentsForPostById(id);
  }
}
