package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.data.models.TrackItemQuantity;
import com.semicolon.africa.data.repositories.TrackItemQuantityRepository;
import com.semicolon.africa.dtos.requests.AddItemTrackRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryRequest;
import com.semicolon.africa.dtos.response.AddItemTrackResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;
import com.semicolon.africa.services.Interfaces.TrackItemQuantityServices;
import com.semicolon.africa.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackItemQuantityServicesImpl implements TrackItemQuantityServices {
    @Autowired
    private TrackItemQuantityRepository trackItemQuantityRepository;

    private LocalDateTime generateLocalDate(){
        return  LocalDateTime.now();
    }

     private int generateYear(){
        return generateLocalDate().getYear();
     }

     private int generateMonth(){
        return generateLocalDate().getMonthValue();
     }

     private int generateDay(){
        return generateLocalDate().getDayOfMonth();
     }

     private String generateTime(){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
         LocalDateTime now = generateLocalDate();
         return now.format(formatter);
     }

    @Override
    public AddItemTrackResponse addAllItemUpdate(AddItemTrackRequest request) {
        TrackItemQuantity trackItemQuantity = new TrackItemQuantity(generateYear(), generateMonth(), generateDay(), generateTime());
        Mapper.map(request,trackItemQuantity);
        trackItemQuantityRepository.save(trackItemQuantity);
        AddItemTrackResponse response = new AddItemTrackResponse();
        Mapper.map(response,trackItemQuantity);
        return response;
    }

    @Override
    public List<GetAllItemHistoryResponse> getAllTrackItemHistory(GetAllTrackItemHistoryRequest request) {
        List<TrackItemQuantity> trackItemQuantity = trackItemQuantityRepository.findTrackItemQuantitiesByUserId(request.getUserId());
        return getGetAllItemHistoryResponses(trackItemQuantity);
    }

    @Override
    public List<GetAllItemHistoryResponse> getAllTrackItemHistoryByYear(GetAllTrackItemHistoryByYearRequest request) {
        List<TrackItemQuantity> trackItemQuantities = trackItemQuantityRepository.findTrackItemQuantitiesByUserIdAndYear(request.getUserId(),request.getYear());
        return getGetAllItemHistoryResponses(trackItemQuantities);
    }

    @Override
    public List<GetAllItemHistoryResponse> getAllTrackItemHistoryByMonth(GetAllTrackItemHistoryByMonthRequest request) {
        List<TrackItemQuantity> trackItemQuantities = trackItemQuantityRepository.
                findTrackItemQuantitiesByUserIdAndMonth(request.getUserId(),request.getMonth());
        return getGetAllItemHistoryResponses(trackItemQuantities);
    }

    private List<GetAllItemHistoryResponse> getGetAllItemHistoryResponses(List<TrackItemQuantity> trackItemQuantities) {
        List<GetAllItemHistoryResponse> mappedTrackedItem = new ArrayList<>();
        for(TrackItemQuantity trackItemQuantity1 : trackItemQuantities){
            GetAllItemHistoryResponse mappedTrackedItemResponse = new GetAllItemHistoryResponse();
            Mapper.map(mappedTrackedItemResponse,trackItemQuantity1);
            mappedTrackedItem.add(mappedTrackedItemResponse);
        }
        return mappedTrackedItem;
    }
}
