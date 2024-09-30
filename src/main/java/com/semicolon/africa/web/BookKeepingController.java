package com.semicolon.africa.web;

import com.semicolon.africa.dtos.requests.AddTransactionRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionRequest;
import com.semicolon.africa.dtos.response.AddTransactionResponse;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.GetAllTransactionResponse;
import com.semicolon.africa.services.ServiceImplementations.BookKeepingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/item/")
public class BookKeepingController {

    private final BookKeepingServiceImpl bookKeepingService;

    public BookKeepingController(BookKeepingServiceImpl bookKeepingService) {
        this.bookKeepingService = bookKeepingService;
    }

    @PostMapping("addTransaction")
    ResponseEntity<?> addTransaction(@RequestBody AddTransactionRequest request){
        try {
            AddTransactionResponse response = bookKeepingService.addTransaction(request);
            return new ResponseEntity<>(new ApiResponse(true,response),CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("getAllTransaction/{userId}")
    ResponseEntity<?> getAllTransactions(@PathVariable("userId") Long userId){
        GetAllTransactionRequest getAllTransactionRequest = new GetAllTransactionRequest();
        getAllTransactionRequest.setUserId(userId);
        try{
            List<GetAllTransactionResponse> responses = bookKeepingService.getAllTransaction(getAllTransactionRequest);
            return new ResponseEntity<>(new ApiResponse(true , responses),CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("getAllTransactionByYear")
    ResponseEntity<?> getAllTransactionByYear(@RequestBody GetAllTransactionByYearRequest request){
        try {
            List<GetAllTransactionResponse> responses = bookKeepingService.getAllTransactionByYear(request);
            return new ResponseEntity<>(new ApiResponse(true , responses),CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("getAllTransactionByMonth")
    ResponseEntity<?> getAllTransactionByMonth(@RequestBody GetAllTransactionByMonthRequest request){
        try {
            List<GetAllTransactionResponse> responses = bookKeepingService.getAllTransactionByMonth(request);
            return new ResponseEntity<>(new ApiResponse(true , responses),CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()),BAD_REQUEST);
        }
    }
}
