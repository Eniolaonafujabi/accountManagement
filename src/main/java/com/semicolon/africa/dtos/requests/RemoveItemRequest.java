package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemoveItemRequest {
    private String name;
    private String category;
    private Long stock;
    private Long inventoryId;
    private Long userId;
}
