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
}
