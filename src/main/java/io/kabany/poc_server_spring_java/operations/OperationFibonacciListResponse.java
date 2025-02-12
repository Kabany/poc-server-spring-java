package io.kabany.poc_server_spring_java.operations;

import java.util.List;

public class OperationFibonacciListResponse {
  private List<Long> list;

  public OperationFibonacciListResponse(List<Long> list) {
    this.list = list;
  }

  public List<Long> getList() {
    return list;
  }

  public void setList(List<Long> list) {
    this.list = list;
  }

  
}
