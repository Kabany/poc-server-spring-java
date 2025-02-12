package io.kabany.poc_server_spring_java.operations;

public class OperationFibonacciSumResponse {
  private long sum;

  public OperationFibonacciSumResponse(long sum) {
    this.sum = sum;
  }

  public long getSum() {
    return sum;
  }

  public void setSum(long sum) {
    this.sum = sum;
  }
}
