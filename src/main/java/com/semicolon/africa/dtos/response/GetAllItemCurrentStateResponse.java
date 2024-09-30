package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllItemCurrentStateResponse {
    private Long id;
    private String name;
    private CategoryType category;
    private Long stock;
    private Long inventoryId;
    private Long userId;
    private Long unitPrice;
}
