package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItemRequest {
    private String name;
    private String category;
    private Long stock;
    private Long inventoryId;
    private Long userId;
    private Long unitPrice;
}
