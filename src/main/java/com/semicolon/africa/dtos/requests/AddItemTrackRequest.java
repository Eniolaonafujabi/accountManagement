package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddItemTrackRequest {
    private Long itemId;
    private Long userId;
    private String name;
    private CategoryType category;
    private Long stock;
    private Long unitPrice;
}
