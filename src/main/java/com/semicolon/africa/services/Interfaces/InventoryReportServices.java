package com.semicolon.africa.services.Interfaces;
import com.semicolon.africa.dtos.requests.GetAllItemCurrentStateRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryRequest;
import com.semicolon.africa.dtos.response.GetAllItemCurrentStateResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;

import java.util.List;

public interface InventoryReportServices {
    List<GetAllItemCurrentStateResponse> getAllItemCurrentState(GetAllItemCurrentStateRequest request);
    List<GetAllItemHistoryResponse> getAllItemHistory(GetAllTrackItemHistoryRequest request);
    List<GetAllItemHistoryResponse> getAllItemHistoryByYear(GetAllTrackItemHistoryByYearRequest request);
    List<GetAllItemHistoryResponse> getAllItemHistoryByMonth(GetAllTrackItemHistoryByMonthRequest request);
}
