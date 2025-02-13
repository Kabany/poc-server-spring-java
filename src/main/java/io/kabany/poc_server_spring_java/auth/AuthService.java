package io.kabany.poc_server_spring_java.auth;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bastiaanjansen.otp.HMACAlgorithm;
import com.bastiaanjansen.otp.TOTPGenerator;
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

  public String createHash(String text) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-512");
      byte[] messageDigest = md.digest(text.getBytes());
      BigInteger no = new BigInteger(1, messageDigest);
      String hashtext = no.toString(16);
      while (hashtext.length() < 128) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }

  public String createTotp(String text) {
    TOTPGenerator totp = new TOTPGenerator.Builder(text).withHOTPGenerator(builder -> {
      builder.withAlgorithm(HMACAlgorithm.SHA512).withPasswordLength(8);
    }).withPeriod(Duration.ofSeconds(30)).build();
    return totp.now();
  }
}
 