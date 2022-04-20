package com.incubyte.postsapi;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PostsControllerShould {
  private PostsService postsService = mock(PostsService.class);
  private final PostsController postsController = new PostsController(postsService);

  @Test
  void get_all_posts() {
    postsController.getAllPosts();
    verify(postsService).getAllPosts();
  }
}
