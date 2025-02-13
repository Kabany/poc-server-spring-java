package io.kabany.poc_server_spring_java.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.kabany.poc_server_spring_java.response.JsonResponse;
import io.kabany.poc_server_spring_java.response.ResponseService;

@RestController
public class AuthController {

  @Autowired
  private AuthService authService;

  @Autowired
  private ResponseService responseService;

  @SuppressWarnings("rawtypes")
  @PostMapping("/auth/jwt/string")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendJwtToken(@RequestBody AuthMessageRequest body) {
    String token = authService.createJwtFromString(body.getMessage());
    AuthTokenResponse response = new AuthTokenResponse(token);
    return responseService.SuccessResponse(response, null);
  }

  @SuppressWarnings("rawtypes")
  @PostMapping("/auth/hash/string")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendHash(@RequestBody AuthMessageRequest body) {
    String token = authService.createHash(body.getMessage());
    AuthHashResponse response = new AuthHashResponse(token);
    return responseService.SuccessResponse(response, null);
  }

  @SuppressWarnings("rawtypes")
  @PostMapping("/auth/totp/string")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendTotpCode(@RequestBody AuthMessageRequest body) {
    String token = authService.createTotp(body.getMessage());
    AuthCodeResponse response = new AuthCodeResponse(token);
    return responseService.SuccessResponse(response, null);
  }
}
