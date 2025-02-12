package io.kabany.poc_server_spring_java.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.kabany.poc_server_spring_java.response.JsonResponse;
import io.kabany.poc_server_spring_java.response.ResponseService;

@RestController
public class OperationsController {

  @Autowired
  private OperationsService operationsService;

  @Autowired
  private ResponseService responseService;

  @SuppressWarnings("rawtypes")
  @GetMapping("/operations/list/params/{times}")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendListWithParams(@PathVariable int times) {
    List<OperationListItem> list = operationsService.createList(times);
    return responseService.SuccessResponse(list, null);
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/operations/list/query")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendListWithQuery(@RequestParam int times) {
    List<OperationListItem> list = operationsService.createList(times);
    return responseService.SuccessResponse(list, null);
  }

  @SuppressWarnings("rawtypes")
  @PostMapping("/operations/list/body")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendListWithBody(@RequestBody OperationTimesRequest body) {
    List<OperationListItem> list = operationsService.createList(body.getTimes());
    return responseService.SuccessResponse(list, null);
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/operations/list/headers")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendListWithHeaders(@RequestHeader int times) {
    List<OperationListItem> list = operationsService.createList(times);
    return responseService.SuccessResponse(list, null);
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/operations/fibonacci/sum/{times}")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendFibunacciSum(@PathVariable int times) {
    OperationFibonacciSumResponse response = new OperationFibonacciSumResponse(operationsService.fibonacciSum(times));
    return responseService.SuccessResponse(response, null);
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/operations/fibonacci/list/{times}")
  @ResponseStatus( HttpStatus.OK )
  JsonResponse sendFibunacciList(@PathVariable int times) {
    OperationFibonacciListResponse response = new OperationFibonacciListResponse(operationsService.fibonacciList(times));
    return responseService.SuccessResponse(response, null);
  }
}
