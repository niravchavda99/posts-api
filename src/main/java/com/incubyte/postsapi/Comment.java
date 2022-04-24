package com.incubyte.postsapi;

public class Comment {

  private Integer id;
  private Integer postId;
  private String name;
  private String email;
  private String body;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setPostId(Integer postId) {
    this.postId = postId;
  }

  public Integer getPostId() {
    return postId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getBody() {
    return body;
  }
}
