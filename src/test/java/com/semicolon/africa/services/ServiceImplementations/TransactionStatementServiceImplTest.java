package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.data.repositories.BookKeepingRepo;
import com.semicolon.africa.dtos.requests.AddTransactionRequest;
import com.semicolon.africa.dtos.requests.GetAllTransactionRequest;
import com.semicolon.africa.dtos.response.AddTransactionResponse;
import com.semicolon.africa.dtos.response.GetAllTransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TransactionStatementServiceImplTest {

    @Autowired
    private BookKeepingRepo bookKeepingRepo;

    @BeforeEach
    void setUp() {
        bookKeepingRepo.deleteAll();
    }

    @Autowired
    private TransactionStatementServicesImpl transactionStatementServices;

    @Autowired
    private BookKeepingServiceImpl bookKeepingService;

    @Test
    public void testThatUserCanGetAllTransaction() {
        AddTransactionRequest request = new AddTransactionRequest();
        request.setSenderName("David");
        request.setReceiverName("Alex");
        request.setTransactionType("CREDIT");
        request.setPaymentMethod("BANK_TRANSFER");
        request.setUserId(1L);
        AddTransactionResponse response = bookKeepingService.addTransaction(request);
        assertThat(response.getMessage()).isEqualTo("Transaction Added To Record");
        GetAllTransactionRequest request1 = new GetAllTransactionRequest();
        request1.setUserId(1L);
        List<GetAllTransactionResponse> responses = transactionStatementServices.getAllTransaction(request1);
        assertThat(responses.size()).isEqualTo(1);
    }
}
