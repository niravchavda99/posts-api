package com.incubyte.postsapi;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SuppressWarnings("NewClassNamingConvention")
class PostsServiceShould {
  private final JsonPlaceholderPostsGateway jsonPlaceholderPostsGateway =
      mock(JsonPlaceholderPostsGateway.class);

  @BeforeEach
  public void init() {
    when(jsonPlaceholderPostsGateway.getAll()).thenReturn(Mono.just(getFakePosts()));
    when(jsonPlaceholderPostsGateway.getById(1)).thenReturn(Mono.just(getFakePost()));
  }

  private List<Post> getFakePosts() {
    Post post1 = getFakePost();

    Post post2 = new Post();
    post2.setUserId(2);
    post2.setId(2);
    post2.setTitle("Title for Post 2");
    post2.setBody("Body of Post 2");

    return List.of(post1, post2);
  }

  private Post getFakePost() {
    Post post1 = new Post();
    post1.setUserId(1);
    post1.setId(1);
    post1.setTitle("This is the title for post 1");
    post1.setBody("This is the body of post 1");
    return post1;
  }

  @Test
  void get_all_posts() {
    PostsService postsService = new PostsService(jsonPlaceholderPostsGateway);
    List<Post> allPosts = postsService.getAll().block();
    verify(jsonPlaceholderPostsGateway).getAll();

    Assertions.assertNotNull(allPosts);
    assertThat(allPosts).hasSizeGreaterThan(0);

    Post post1 = allPosts.get(0);
    assertThat(post1.getUserId()).isEqualTo(1);
    assertThat(post1.getId()).isEqualTo(1);
    assertThat(post1.getTitle()).isEqualTo("This is the title for post 1");
    assertThat(post1.getBody()).isEqualTo("This is the body of post 1");
  }

  @Test
  void get_post_by_id() {
    PostsService postsService = new PostsService(jsonPlaceholderPostsGateway);
    postsService.getById(1).block();
    verify(jsonPlaceholderPostsGateway).getById(1);
  }
}
