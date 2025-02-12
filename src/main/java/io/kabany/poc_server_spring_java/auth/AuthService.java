package io.kabany.poc_server_spring_java.auth;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;

@Service
public class AuthService {

  private static String FIRST_JWT_SECRET = "ThisIsASuperSecret";
  private Gson gson = new Gson();

  public String createJwtFromString(String message) {
    Algorithm algorithm = Algorithm.HMAC256(FIRST_JWT_SECRET);
    AuthJwtPayload payload = new AuthJwtPayload(message);
    return JWT.create().withPayload(gson.toJson(payload)).sign(algorithm);
  }

  public String validateJwtFromToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(FIRST_JWT_SECRET);
    JWTVerifier verifier = JWT.require(algorithm).build();
    DecodedJWT decodedjwt = verifier.verify(token);
    Base64.Decoder decoder = Base64.getUrlDecoder();
    String payload = new String(decoder.decode(decodedjwt.getPayload()));
    AuthJwtPayload p = this.gson.fromJson(payload, AuthJwtPayload.class);
    return p.getMessage();
  }
}
 