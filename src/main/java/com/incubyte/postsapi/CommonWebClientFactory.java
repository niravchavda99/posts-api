package com.incubyte.postsapi;

import org.springframework.web.reactive.function.client.WebClient;

public class CommonWebClientFactory {

  private CommonWebClientFactory() {}

  public static WebClient getCommonWebClient() {
    return WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
  }
}
