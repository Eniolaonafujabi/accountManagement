package com.semicolon.africa.dtos.response;

import java.time.LocalDateTime;
import com.semicolon.africa.data.type.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryReportResponse {
    private Long id;
    private CategoryType category;
    private Long quantity;
    private double unitPrice;
    private LocalDateTime createdAt;
    private Long userId;
}
