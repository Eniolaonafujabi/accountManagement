package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddItemTrackResponse {
    private String name;
    private CategoryType category;
    private Long stock;
    private String message;
    private Long unitPrice;
}
