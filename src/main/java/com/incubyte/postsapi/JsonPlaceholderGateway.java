package com.incubyte.postsapi;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class JsonPlaceholderGateway {
  public Mono<List<Post>> getAllPosts() {
    throw new UnsupportedOperationException();
  }
}
