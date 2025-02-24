package io.kabany.poc_server_spring_java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.kabany.poc_server_spring_java.auth.AuthService;

@SpringBootTest
public class AuthServiceTest {

  @Autowired
  private AuthService authService;

  @Test
  void shouldCreateJwtFromString() {
    String message = "Hello World!";
    String token = authService.createJwtFromString(message);
    assertEquals("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZXNzYWdlIjoiSGVsbG8gV29ybGQhIn0.q_OAmeTO_BJ0X1_6SMzGEat8qHvcMZ6LtPhLg8yKXR4", token);
  }

  @Test
  void shouldCreateJwtThenDecodeAndMustMatchWithOriginalMessage() {
    String message = "Hello World!";
    String token = authService.createJwtFromString(message);
    String decoded = authService.validateJwtFromToken(token);
    assertEquals(message, decoded);
    
    // From Ruby & Python
    String decoded2 = authService.validateJwtFromToken("eyJhbGciOiJIUzI1NiJ9.eyJtZXNzYWdlIjoiSGVsbG8gV29ybGQhIn0.yX3llK_oxmp-qhJ7l-B0AL8wOlzCzsDHlw7xtCU2d4s");
    assertEquals(message, decoded2);
    // From Swift
    String decoded3 = authService.validateJwtFromToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXNzYWdlIjoiSGVsbG8gV29ybGQhIn0.Qn62lWxZ5VZKovUbE8KTu_xGeDSp739uapAuBDK360Y");
    assertEquals(message, decoded3);
  }

  @Test
  void shouldCreateHashWithSha512Algorithm() {
    String message = "Hello World!";
    String hash = authService.createHash(message);
    assertEquals("861844d6704e8573fec34d967e20bcfef3d424cf48be04e6dc08f2bd58c729743371015ead891cc3cf1c9d34b49264b510751b1ff9e537937bc46b5d6ff4ecc8", hash);
  }

  @Test
  void shouldCreateTotp() {
    String message = "JBSWY3DPEHPK3PXP";
    String token = authService.createTotp(message);
    String token2 = authService.createTotp(message);
    assertEquals(token, token2);
  }
}
