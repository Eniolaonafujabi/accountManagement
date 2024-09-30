package com.semicolon.africa.web;

import com.semicolon.africa.dtos.requests.AddItemTrackRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByYearRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryRequest;
import com.semicolon.africa.dtos.response.AddItemTrackResponse;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;
import com.semicolon.africa.services.ServiceImplementations.TrackItemQuantityServicesImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/trackItemQuantity/")
public class TrackItemQuantityController {

    private final TrackItemQuantityServicesImpl trackItemQuantityServices;

    public TrackItemQuantityController(TrackItemQuantityServicesImpl trackItemQuantityServices) {
        this.trackItemQuantityServices = trackItemQuantityServices;
    }

    @PostMapping("addAllItemUpdate")
    ResponseEntity<?> addAllItemUpdate(@RequestBody AddItemTrackRequest addItemTrackRequest) {
        try {
            AddItemTrackResponse addItemTrackResponse =trackItemQuantityServices.addAllItemUpdate(addItemTrackRequest);
            return new ResponseEntity<>(new ApiResponse(true,addItemTrackResponse),CREATED);
        }catch (Exception errorMessage) {
            return new ResponseEntity<>(new ApiResponse(false,errorMessage.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("getAllHistoryByYear")
    ResponseEntity<?> getAllHistoryByYear(@RequestBody GetAllTrackItemHistoryByYearRequest getAllTrackItemHistoryByYearRequest) {
        try {
            List<GetAllItemHistoryResponse> responses = trackItemQuantityServices.getAllTrackItemHistoryByYear(getAllTrackItemHistoryByYearRequest);
            return new ResponseEntity<>(new ApiResponse(true,responses),OK);
        }catch (Exception errorMessage) {
            return new ResponseEntity<>(new ApiResponse(false,errorMessage.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("getAllHistory/{userId}")
    ResponseEntity<?> getAllHistory(@PathVariable("userId") Long userId) {
        GetAllTrackItemHistoryRequest getAllTrackItemHistoryRequest= new GetAllTrackItemHistoryRequest();
        getAllTrackItemHistoryRequest.setUserId(userId);
        try {
            List<GetAllItemHistoryResponse> responses = trackItemQuantityServices.getAllTrackItemHistory(getAllTrackItemHistoryRequest);
            return new ResponseEntity<>(new ApiResponse(true,responses),OK);
        }catch (Exception errorMessage) {
            return new ResponseEntity<>(new ApiResponse(false,errorMessage.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("getAllHistoryByMonth")
    ResponseEntity<?> getAllHistoryByMonth(@RequestBody GetAllTrackItemHistoryByMonthRequest getAllTrackItemHistoryByMonthRequest ) {
        try {
            List<GetAllItemHistoryResponse> responses = trackItemQuantityServices.getAllTrackItemHistoryByMonth(getAllTrackItemHistoryByMonthRequest);
            return new ResponseEntity<>(new ApiResponse(true,responses),OK);
        }catch (Exception errorMessage) {
            return new ResponseEntity<>(new ApiResponse(false,errorMessage.getMessage()),BAD_REQUEST);
        }
    }
}
