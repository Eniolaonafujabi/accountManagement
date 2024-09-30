package com.semicolon.africa.data.models;

import com.semicolon.africa.data.type.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Item {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CategoryType category;
    private Long stock;
    private Long inventoryId;
    private Long userId;
    private Long unitPrice;
}
