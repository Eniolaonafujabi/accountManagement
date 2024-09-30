package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.dtos.requests.GetAllTransactionByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionRequest;
import com.semicolon.africa.dtos.response.GetAllTransactionResponse;
import com.semicolon.africa.services.Interfaces.TransactionStatementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionStatementServicesImpl implements TransactionStatementServices {

    @Autowired
    private BookKeepingServiceImpl bookKeepingService;

    @Override
    public List<GetAllTransactionResponse> getAllTransaction(GetAllTransactionRequest request) {
        return bookKeepingService.getAllTransaction(request);
    }

    @Override
    public List<GetAllTransactionResponse> getAllTransactionByYear(GetAllTransactionByYearRequest request) {
        return bookKeepingService.getAllTransactionByYear(request);
    }

    @Override
    public List<GetAllTransactionResponse> getAllTransactionByMonth(GetAllTransactionByMonthRequest request) {
        return bookKeepingService.getAllTransactionByMonth(request);
    }
}
