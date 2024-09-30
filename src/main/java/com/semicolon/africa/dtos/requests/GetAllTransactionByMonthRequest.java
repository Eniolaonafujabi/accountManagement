package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllTransactionByMonthRequest {
    private int month;

    private long userId;
}