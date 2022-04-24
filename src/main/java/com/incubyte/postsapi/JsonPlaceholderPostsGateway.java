package com.incubyte.postsapi;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

@Component
public class JsonPlaceholderPostsGateway {
  ResponseSpec getWebClient(String url) {
    return CommonWebClientFactory.getCommonWebClient()
        .get()
        .uri(url)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve();
  }

  public Mono<List<Post>> getAll() {
    return getWebClient("/posts").bodyToMono(new ParameterizedTypeReference<>() {});
  }

  public Mono<Post> getById(Integer id) {
    String url = String.format("/posts/%d", id);
    return getWebClient(url).bodyToMono(Post.class);
  }

  public Mono<List<Comment>> getCommentsForPostById(Integer id) {
    String url = String.format("/posts/%d/comments", id);
    return getWebClient(url).bodyToMono(new ParameterizedTypeReference<>() {});
  }
}
