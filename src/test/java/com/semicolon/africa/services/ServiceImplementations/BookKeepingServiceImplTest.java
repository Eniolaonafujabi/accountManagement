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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class BookKeepingServiceImplTest {

    @Autowired
    private BookKeepingRepo bookKeepingRepo;

    @BeforeEach
    void setUp() {
        bookKeepingRepo.deleteAll();
    }

    @Autowired
    private BookKeepingServiceImpl bookKeepingService;

    @Test
    public void testThatICanAddTransaction(){
        AddTransactionRequest request = new AddTransactionRequest();
        request.setSenderName("Eniola");
        request.setReceiverName("Alex");
        request.setTransactionType("DEBIT");
        request.setPaymentMethod("BANK_TRANSFER");
        request.setUserId(1L);
        AddTransactionResponse response = bookKeepingService.addTransaction(request);
        assertThat(response.getMessage()).isEqualTo("Transaction Added To Record");
    }

    @Test
    public void testThatICanGetAllTransaction(){
        AddTransactionRequest request = new AddTransactionRequest();
        request.setSenderName("Eniola");
        request.setReceiverName("Alex");
        request.setTransactionType("DEBIT");
        request.setPaymentMethod("BANK_TRANSFER");
        request.setUserId(1L);
        AddTransactionResponse response = bookKeepingService.addTransaction(request);
        assertThat(response.getMessage()).isEqualTo("Transaction Added To Record");
        GetAllTransactionRequest request1 = new GetAllTransactionRequest();
        request1.setUserId(1L);
        List<GetAllTransactionResponse> response1 = bookKeepingService.getAllTransaction(request1);
        assertThat(response1.size()).isEqualTo(1);
    }

}