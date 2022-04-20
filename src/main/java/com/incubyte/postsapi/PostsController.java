package com.incubyte.postsapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping()
public class PostsController {

  private final PostsService postsService;

  public PostsController(PostsService postsService) {
    this.postsService = postsService;
  }

  @GetMapping("/posts")
  public Mono<List<Post>> getAllPosts() {
    return postsService.getAllPosts();
  }
}
