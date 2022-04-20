package com.incubyte.postsapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PostsServiceShould {
  private final JsonPlaceholderGateway jsonPlaceholderGateway = mock(JsonPlaceholderGateway.class);
  private PostsService postsService;

  @BeforeEach
  public void init() {
    postsService = new PostsService(jsonPlaceholderGateway);
    when(postsService.getAllPosts()).thenReturn(Mono.just(List.of(new Post())));
  }

  @Test
  void get_all_posts() {
    postsService.getAllPosts();
    verify(jsonPlaceholderGateway).getAllPosts();
  }
}
