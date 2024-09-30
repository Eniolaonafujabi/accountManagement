package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.type.PaymentMethod;
import com.semicolon.africa.data.type.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllTransactionResponse {
    private Long id;

    private Long userId;

    private String receiverName;

    private String senderName;

    private PaymentMethod paymentMethod;

    private TransactionType transactionType;

    private int year;

    private int month;

    private int day;

    private String time;
}
