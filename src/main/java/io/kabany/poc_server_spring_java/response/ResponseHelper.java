package io.kabany.poc_server_spring_java.response;

public class ResponseHelper {

  @SuppressWarnings("rawtypes")
  public static <T>JsonResponse SuccessResponse(T data, String message) {
    return new JsonResponse<T>(data, message);
  }
}
