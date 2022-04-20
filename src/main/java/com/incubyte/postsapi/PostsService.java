package com.incubyte.postsapi;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PostsService {

  private final JsonPlaceholderGateway jsonPlaceholderGateway;

  public PostsService(JsonPlaceholderGateway jsonPlaceholderGateway) {
    this.jsonPlaceholderGateway = jsonPlaceholderGateway;
  }

  public Mono<List<Post>> getAllPosts() {
    return jsonPlaceholderGateway.getAllPosts();
  }
}
