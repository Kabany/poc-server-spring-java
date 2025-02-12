package io.kabany.poc_server_spring_java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.kabany.poc_server_spring_java.operations.OperationListItem;
import io.kabany.poc_server_spring_java.operations.OperationsService;

@SpringBootTest
public class OperationsServiceTest {

  @Autowired
  private OperationsService operationsService;

  @Test
  void shouldCreateListOfElements() {
    List<OperationListItem> list = operationsService.createList(1000);
    assertEquals(1000, list.size());
    // First item
    assertEquals(1, list.get(0).getId());
    assertEquals("This is the message number 1", list.get(0).getMessage());
    // 100th item
    assertEquals(100, list.get(99).getId());
    assertEquals("This is the message number 100", list.get(99).getMessage());
    // 1000th item
    assertEquals(1000, list.get(999).getId());
    assertEquals("This is the message number 1000", list.get(999).getMessage());
  }

  @Test
  void shouldAggregateItemsFromFibonacciSequence() {
    assertEquals(0, operationsService.fibonacciSum(-1));
    assertEquals(0, operationsService.fibonacciSum(0));
    assertEquals(1, operationsService.fibonacciSum(1));
    assertEquals(2, operationsService.fibonacciSum(2));
    assertEquals(4, operationsService.fibonacciSum(3));
    assertEquals(7, operationsService.fibonacciSum(4));
    assertEquals(12, operationsService.fibonacciSum(5));
    assertEquals(143, operationsService.fibonacciSum(10));
    assertEquals(32951280098L, operationsService.fibonacciSum(50));
    // assertEquals(927372692193078999175L, operationsService.fibonacciSum(100));
  }

  @Test
  void shouldGenerateFibonacciList() {
    assertEquals(0, operationsService.fibonacciList(-1).size());
    List<Long> list0 = operationsService.fibonacciList(0);
    assertEquals(1, list0.size());
    assertEquals(0, list0.get(0).longValue());
    List<Long> list1 = operationsService.fibonacciList(1);
    assertEquals(2, list1.size());
    assertEquals(1, list1.get(1).longValue());
    List<Long> list2 = operationsService.fibonacciList(2);
    assertEquals(3, list2.size());
    assertEquals(1, list2.get(2).longValue());
    List<Long> list3 = operationsService.fibonacciList(3);
    assertEquals(4, list3.size());
    assertEquals(2, list3.get(3).longValue());
    List<Long> list4 = operationsService.fibonacciList(4);
    assertEquals(5, list4.size());
    assertEquals(3, list4.get(4).longValue());
    List<Long> list5 = operationsService.fibonacciList(5);
    assertEquals(6, list5.size());
    assertEquals(5, list5.get(5).longValue());
    List<Long> list6 = operationsService.fibonacciList(6);
    assertEquals(7, list6.size());
    assertEquals(8, list6.get(6).longValue());
    List<Long> list7 = operationsService.fibonacciList(10);
    assertEquals(11, list7.size());
    assertEquals(55, list7.get(10).longValue());
    List<Long> list8 = operationsService.fibonacciList(50);
    assertEquals(51, list8.size());
    assertEquals(12586269025L, list8.get(50).longValue());
    List<Long> list9 = operationsService.fibonacciList(78);
    assertEquals(79, list9.size());
    assertEquals(8944394323791464L, list9.get(78).longValue());
  }
}
