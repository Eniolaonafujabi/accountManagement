package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllTrackItemHistoryByMonthRequest {
    private long userId;
    private int month;
}
