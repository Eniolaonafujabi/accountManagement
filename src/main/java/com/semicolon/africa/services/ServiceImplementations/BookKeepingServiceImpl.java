package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.data.models.BookKeeping;
import com.semicolon.africa.data.repositories.BookKeepingRepo;
import com.semicolon.africa.dtos.requests.AddTransactionRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionRequest;
import com.semicolon.africa.dtos.response.AddTransactionResponse;
import com.semicolon.africa.dtos.response.GetAllTransactionResponse;
import com.semicolon.africa.exception.BookKeepingException;
import com.semicolon.africa.services.Interfaces.BookKeepingServices;
import com.semicolon.africa.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookKeepingServiceImpl implements BookKeepingServices {

    @Autowired
    BookKeepingRepo bookKeepingRepo;

    private LocalDateTime generateLocalDate(){
        return  LocalDateTime.now();
    }

    private int generateYear(){
        return generateLocalDate().getYear();
    }

    private int generateMonth(){
        return generateLocalDate().getMonthValue();
    }

    private int generateDay(){
        return generateLocalDate().getDayOfMonth();
    }

    private String generateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = generateLocalDate();
        return now.format(formatter);
    }

    @Override
    public AddTransactionResponse addTransaction(AddTransactionRequest request) {
        validateInputAreNotEmpty(request.getReceiverName());
        validateInputAreNotEmpty(request.getSenderName());
        BookKeeping bookKeeping = new BookKeeping(generateYear(),generateMonth(),generateDay(),generateTime());
        Mapper.map(bookKeeping,request);
        bookKeepingRepo.save(bookKeeping);
        AddTransactionResponse response = new AddTransactionResponse();
        Mapper.map(bookKeeping,response);
        return response;
    }

    @Override
    public List<GetAllTransactionResponse> getAllTransaction(GetAllTransactionRequest request) {
        List<BookKeeping> transactions = bookKeepingRepo.getBookKeepingByUserId(request.getUserId());
        List<GetAllTransactionResponse> responses = new ArrayList<>();
        return mapTransactions(responses,transactions);
    }

    @Override
    public List<GetAllTransactionResponse> getAllTransactionByYear(GetAllTransactionByYearRequest request) {
        List<BookKeeping> transactions = bookKeepingRepo.getBookKeepingByUserIdAndYear(request.getUserId(),request.getYear());
        List<GetAllTransactionResponse> responses = new ArrayList<>();
        return mapTransactions(responses,transactions);
    }

    @Override
    public List<GetAllTransactionResponse> getAllTransactionByMonth(GetAllTransactionByMonthRequest request) {
        List<BookKeeping> transactions = bookKeepingRepo.getBookKeepingByUserIdAndMonth(request.getUserId(),request.getMonth());
        List<GetAllTransactionResponse> responses = new ArrayList<>();
        return mapTransactions(responses,transactions);
    }

    private List<GetAllTransactionResponse> mapTransactions(List<GetAllTransactionResponse> responses, List<BookKeeping> transactions) {
        for (BookKeeping transaction : transactions) {
            GetAllTransactionResponse response = new GetAllTransactionResponse();
            response.setUserId(transaction.getUserId());
            response.setReceiverName(transaction.getReceiverName());
            response.setSenderName(transaction.getSenderName());
            response.setYear(transaction.getYear());
            response.setMonth(transaction.getMonth());
            response.setDay(transaction.getDay());
            response.setTime(transaction.getTime());
            response.setPaymentMethod(transaction.getPaymentMethod());
            response.setTransactionType(transaction.getTransactionType());
            response.setId(transaction.getId());
            responses.add(response);
        }
        return responses;
    }


    private void validateInputAreNotEmpty(String details) {
        if(details == null || details.isEmpty())throw new BookKeepingException("Put a valid input");
    }
}
