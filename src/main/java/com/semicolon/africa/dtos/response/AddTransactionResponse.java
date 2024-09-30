package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.type.PaymentMethod;
import com.semicolon.africa.data.type.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddTransactionResponse {

    private Long id;

    private Long userId;

    private String receiverName;

    private String senderName;

    private PaymentMethod paymentMethod;

    private TransactionType type;

    private String message;

    private int year;

    private int month;

    private int day;

    private String time;
}
