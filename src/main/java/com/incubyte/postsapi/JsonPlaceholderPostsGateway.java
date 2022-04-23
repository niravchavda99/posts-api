package com.incubyte.postsapi;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class JsonPlaceholderPostsGateway {
  public Mono<List<Post>> getAllPosts() {
    return CommonWebClientFactory.getCommonWebClient()
        .get()
        .uri("/posts")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<>() {});
  }
}
