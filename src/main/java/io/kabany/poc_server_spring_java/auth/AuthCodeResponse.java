package io.kabany.poc_server_spring_java.auth;

public class AuthCodeResponse {

  private String code;

  public AuthCodeResponse(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
