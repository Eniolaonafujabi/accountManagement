package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllTransactionByYearRequest {

    private int year;

    private Long userId;
}
