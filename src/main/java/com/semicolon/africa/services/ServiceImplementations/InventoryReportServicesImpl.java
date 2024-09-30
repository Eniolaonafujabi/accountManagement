package com.semicolon.africa.services.ServiceImplementations;
import com.semicolon.africa.dtos.requests.GetAllItemCurrentStateRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryRequest;
import com.semicolon.africa.dtos.response.GetAllItemCurrentStateResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;
import com.semicolon.africa.services.Interfaces.InventoryReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryReportServicesImpl implements InventoryReportServices {

    @Autowired
    private ItemServicesImpl itemServices;

    @Autowired
    private TrackItemQuantityServicesImpl trackItemQuantityServices;

    @Override
    public List<GetAllItemCurrentStateResponse> getAllItemCurrentState(GetAllItemCurrentStateRequest request) {
        return itemServices.getAllItemCurrentState(request);
    }

    @Override
    public List<GetAllItemHistoryResponse> getAllItemHistory(GetAllTrackItemHistoryRequest request) {
        return trackItemQuantityServices.getAllTrackItemHistory(request);
    }

    @Override
    public List<GetAllItemHistoryResponse> getAllItemHistoryByYear(GetAllTrackItemHistoryByYearRequest request) {
        return trackItemQuantityServices.getAllTrackItemHistoryByYear(request);
    }

    @Override
    public List<GetAllItemHistoryResponse> getAllItemHistoryByMonth(GetAllTrackItemHistoryByMonthRequest request) {
        return trackItemQuantityServices.getAllTrackItemHistoryByMonth(request);
    }

}
