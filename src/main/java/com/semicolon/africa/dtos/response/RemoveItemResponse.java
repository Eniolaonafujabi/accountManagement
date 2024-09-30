package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemoveItemResponse {
    private Long itemId;
    private String itemName;
    private Long userId;
    private Long stock;
    private String message;
    private String messageFromTrackItemHistory;
    private Long unitPrice;
}
