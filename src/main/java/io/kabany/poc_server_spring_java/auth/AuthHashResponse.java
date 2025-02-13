package io.kabany.poc_server_spring_java.auth;

public class AuthHashResponse {
  
  private String hash;

  public AuthHashResponse(String hash) {
    this.hash = hash;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }
}
