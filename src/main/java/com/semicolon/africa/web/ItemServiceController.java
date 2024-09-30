package com.semicolon.africa.web;

import com.semicolon.africa.dtos.requests.AddItemRequest;
import com.semicolon.africa.dtos.requests.GetAllItemCurrentStateRequest;
import com.semicolon.africa.dtos.requests.RemoveItemRequest;
import com.semicolon.africa.dtos.response.AddItemResponse;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.GetAllItemCurrentStateResponse;
import com.semicolon.africa.dtos.response.RemoveItemResponse;
import com.semicolon.africa.services.ServiceImplementations.ItemServicesImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/item/")
public class ItemServiceController {

    private final ItemServicesImpl itemServices;


    public ItemServiceController(ItemServicesImpl itemServices) {
        this.itemServices = itemServices;
    }

    @PostMapping("addItem")
    ResponseEntity<?> addItem(@RequestBody AddItemRequest addItemRequest) {
        try {
            AddItemResponse response = itemServices.addItem(addItemRequest);
            return new ResponseEntity<>((new ApiResponse(true ,response )),CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("removeItem")
    ResponseEntity<?> removeItem(@RequestBody RemoveItemRequest removeItemRequest) {
        try {
            RemoveItemResponse response = itemServices.removeItem(removeItemRequest);
            return new ResponseEntity<>((new ApiResponse(true ,response )),CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("getAllCurrentStateOfAllItem")
    ResponseEntity<?> getAllCurrentStateOfAllItem(@RequestBody GetAllItemCurrentStateRequest getAllItemCurrentStateRequest) {
        try {
            List<GetAllItemCurrentStateResponse> responses = itemServices.getAllItemCurrentState(getAllItemCurrentStateRequest);
            return new ResponseEntity<>(new ApiResponse(true,responses),CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()),BAD_REQUEST);
        }
    }
}
