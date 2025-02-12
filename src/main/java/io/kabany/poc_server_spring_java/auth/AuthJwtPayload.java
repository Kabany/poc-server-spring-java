package io.kabany.poc_server_spring_java.auth;

public class AuthJwtPayload {

  private String message;

  public AuthJwtPayload(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
