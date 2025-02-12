package io.kabany.poc_server_spring_java.operations;

public class OperationListItem {
  private int id;
  private String message;

  public OperationListItem(int id, String message) {
    this.id = id;
    this.message = message;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
}
