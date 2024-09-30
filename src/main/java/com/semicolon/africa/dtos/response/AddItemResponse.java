package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddItemResponse {
    private Long itemId;
    private String itemName;
    private CategoryType categoryType;
    private Long stock;
    private String message;
    private String messageFromTrackHistory;
    private Long unitPrice;
}
