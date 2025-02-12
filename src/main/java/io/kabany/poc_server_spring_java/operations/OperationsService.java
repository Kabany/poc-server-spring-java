package io.kabany.poc_server_spring_java.operations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OperationsService {

  public List<OperationListItem> createList(int times) {
    List<OperationListItem> list = new ArrayList<>();
    String template = "This is the message number %s";
    for (int x = 0; x < times; x++) {
      list.add(new OperationListItem(x + 1, String.format(template, x + 1)));
    }
    return list;
  }

  public long fibonacciSum(int n) {
    if (n <= 0) { return 0; }
  
    long[] fibo = new long[n+1];
    fibo[0] = 0; 
    fibo[1] = 1;
  
    // Initialize result
    long sum = fibo[0] + fibo[1];
  
    // Add remaining terms
    for (int i=2; i<=n; i++)
    {
      fibo[i] = fibo[i-1]+fibo[i-2];
      sum += fibo[i];
    }
  
    return sum;
  }

  public List<Long> fibonacciList(int n) {
    List<Long> fibo = new ArrayList<Long>();
    if (n < 0) {
      return fibo;
    } else if (n == 0) {
      fibo.add(Long.valueOf(0));
      return fibo;
    }
    fibo.add(Long.valueOf(0));
    fibo.add(Long.valueOf(1));
  
    // Add remaining terms
    for (int i=2; i<=n; i++) {
      fibo.add(fibo.get(i-1).longValue() + fibo.get(i-2).longValue());
    }
  
    return fibo;
  }
}
