package io.kabany.poc_server_spring_java.response;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {

  @SuppressWarnings("rawtypes")
  public <T>JsonResponse SuccessResponse(T data, String message) {
    return new JsonResponse<T>(data, message);
  }
}
