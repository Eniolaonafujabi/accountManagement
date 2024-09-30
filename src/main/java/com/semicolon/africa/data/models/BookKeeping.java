package com.semicolon.africa.data.models;

import com.semicolon.africa.data.type.PaymentMethod;
import com.semicolon.africa.data.type.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class BookKeeping {

    @Id
    @Setter
    @GeneratedValue
    private Long id;

    @Setter
    private String receiverName;

    @Setter
    private String senderName;

    @Enumerated(EnumType.STRING)
    @Setter
    private PaymentMethod paymentMethod;

    @Setter
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Setter
    private TransactionType transactionType;

    private int year;

    private int month;

    private int day;

    private String time;

    public BookKeeping(int year, int month, int day, String time) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
    }
}
