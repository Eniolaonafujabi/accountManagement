package com.semicolon.africa.data.models;

import com.semicolon.africa.data.type.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class TrackItemQuantity {
    @Id
    @Setter
    @GeneratedValue
    private Long id;

    @Setter
    private long userId;

    @Setter
    private String name;

    @Setter
    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @Setter
    private Long stock;

    @Setter
    private Long itemId;

    @Setter
    private Long unitPrice;

    private int year;

    private int month;

    private int day;

    private String time;

    public TrackItemQuantity(int year, int month, int day, String time) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
    }
}

