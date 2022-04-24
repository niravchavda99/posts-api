package com.incubyte.postsapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/posts/{id}/comments")
  public Mono<List<Comment>> getCommentsForPostById(@PathVariable("id") Integer id) {
    return postsService.getCommentsForPostById(id);
  }

  @GetMapping("/posts/{id}")
  public Mono<Post> getById(@PathVariable("id") Integer id) {
    return postsService.getById(id);
  }

  @GetMapping("/posts")
  public Mono<List<Post>> getAll() {
    return postsService.getAll();
  }
}
