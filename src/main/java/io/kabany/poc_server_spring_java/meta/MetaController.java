package io.kabany.poc_server_spring_java.meta;

import org.springframework.web.bind.annotation.RestController;

import io.kabany.poc_server_spring_java.response.JsonResponse;
import io.kabany.poc_server_spring_java.response.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class MetaController {

  @Value("${spring.application.version}")
  private String version;

  @Autowired
  private ResponseService responseService;

  @SuppressWarnings("rawtypes")
  @GetMapping("/meta/ping")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse ping() {
    return responseService.SuccessResponse(null, "pong!");
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/meta/health-check")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse healthCheck() {
    return responseService.SuccessResponse(null, "ok!");
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/meta/version")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendVersion() {
    return responseService.SuccessResponse(null, version);
  }
}
