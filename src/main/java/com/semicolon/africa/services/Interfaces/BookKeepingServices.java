package com.semicolon.africa.services.Interfaces;

import com.semicolon.africa.dtos.requests.AddTransactionRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionRequest;
import com.semicolon.africa.dtos.response.AddTransactionResponse;
import com.semicolon.africa.dtos.response.GetAllTransactionResponse;
import java.util.List;

public interface BookKeepingServices {
    AddTransactionResponse addTransaction(AddTransactionRequest request);

    List<GetAllTransactionResponse> getAllTransaction(GetAllTransactionRequest request);

    List<GetAllTransactionResponse> getAllTransactionByYear(GetAllTransactionByYearRequest request);

    List<GetAllTransactionResponse> getAllTransactionByMonth(GetAllTransactionByMonthRequest request);
}
