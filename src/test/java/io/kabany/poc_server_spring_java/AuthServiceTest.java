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
    assertEquals("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZXNzYWdlIjoiSGVsbG8gV29ybGQhIn0.IuiP9G4uZRbreQi4qWaZFlZMnvEtHig0AmYx-8NT7Q4", token);
  }

  @Test
  void shouldCreateJwtThenDecodeAndMustMatchWithOriginalMessage() {
    String message = "Hello World!";
    String token = authService.createJwtFromString(message);
    String decoded = authService.validateJwtFromToken(token);
    assertEquals(message, decoded);

    // From Ruby
    String decoded2 = authService.validateJwtFromToken("eyJhbGciOiJIUzI1NiJ9.eyJtZXNzYWdlIjoiSGVsbG8gV29ybGQhIn0.kiLVWiCroYBS-sgSmTP_u74OmiLt_l3UeUBGfM-lmE8");
    assertEquals(message, decoded2);
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
