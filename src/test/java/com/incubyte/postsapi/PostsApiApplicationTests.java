package com.incubyte.postsapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class PostsApiApplicationTests {
  private final WebTestClient webTestClient;

  @Autowired
  public PostsApiApplicationTests(WebTestClient webTestClient) {
    this.webTestClient = webTestClient;
  }

  @Test
  void get_all_posts() {
    webTestClient
        .get()
        .uri(uriBuilder -> uriBuilder.path("/posts").build())
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  void get_post_by_id() {
    webTestClient
        .get()
        .uri(uriBuilder -> uriBuilder.path("/posts/1").build())
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  void get_comments_for_post() {
    webTestClient
        .get()
        .uri(uriBuilder -> uriBuilder.path("/posts/1/comments").build())
        .exchange()
        .expectStatus()
        .isOk();
  }
}
