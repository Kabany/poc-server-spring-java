package io.kabany.poc_server_spring_java.auth;

public class AuthTokenResponse {

  private String token;

  public AuthTokenResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
