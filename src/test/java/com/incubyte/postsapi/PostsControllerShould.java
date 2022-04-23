package com.incubyte.postsapi;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SuppressWarnings("NewClassNamingConvention")
class PostsControllerShould {
  private final PostsService postsService = mock(PostsService.class);
  private final PostsController postsController = new PostsController(postsService);

  @Test
  void get_all_posts() {
    postsController.getAll().block();
    verify(postsService).getAll();
  }

  @Test
  void get_post_by_id() {
    Integer id = 1;
    postsController.getById(id).block();
    verify(postsService).getById(id);
  }
}
