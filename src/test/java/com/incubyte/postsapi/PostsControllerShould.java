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
    postsController.getAll();
    verify(postsService).getAll();
  }

  @Test
  void get_post_by_id() {
    Integer id = 1;
    postsController.getById(id);
    verify(postsService).getById(id);
  }

  @Test
  void get_comments_for_post() {
    Integer id = 1;
    postsController.getCommentsForPostById(id);
    verify(postsService).getCommentsForPostById(id);
  }
}
