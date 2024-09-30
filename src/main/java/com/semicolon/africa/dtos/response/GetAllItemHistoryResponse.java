package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllItemHistoryResponse {
    private Long id;

    private long UserId;

    private String name;

    private CategoryType category;

    private Long stock;

    private Long itemId;

    private int year;

    private int month;

    private int day;

    private String time;
}
