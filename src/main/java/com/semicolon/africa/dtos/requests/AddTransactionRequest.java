package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.type.PaymentMethod;
import com.semicolon.africa.data.type.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddTransactionRequest {

    private Long userId;

    private String receiverName;

    private String senderName;

    private String paymentMethod;

    private String transactionType;
}
