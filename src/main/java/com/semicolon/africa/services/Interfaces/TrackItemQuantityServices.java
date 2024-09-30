package com.semicolon.africa.services.Interfaces;

import com.semicolon.africa.dtos.requests.AddItemTrackRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryRequest;
import com.semicolon.africa.dtos.response.AddItemTrackResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;

import java.util.List;

public interface TrackItemQuantityServices {

    AddItemTrackResponse addAllItemUpdate(AddItemTrackRequest request);

    List<GetAllItemHistoryResponse> getAllTrackItemHistory(GetAllTrackItemHistoryRequest request);

    List<GetAllItemHistoryResponse> getAllTrackItemHistoryByYear(GetAllTrackItemHistoryByYearRequest request);

    List<GetAllItemHistoryResponse> getAllTrackItemHistoryByMonth(GetAllTrackItemHistoryByMonthRequest request);
}
