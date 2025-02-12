package io.kabany.poc_server_spring_java.response;

public class JsonResponse<T> {
  private boolean success;
  private String message;
  private T data;

  public JsonResponse(T data, String message) {
    this.success = false;
    this.data = data;
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }
  public void setSuccess(boolean success) {
    this.success = success;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }

  
}
