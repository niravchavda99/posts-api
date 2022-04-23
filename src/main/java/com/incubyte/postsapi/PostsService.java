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

  public Mono<List<Post>> getAllPosts() {
    return jsonPlaceholderPostsGateway.getAllPosts();
  }
}
