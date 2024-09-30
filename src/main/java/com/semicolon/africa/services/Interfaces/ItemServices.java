package com.semicolon.africa.services.Interfaces;

import com.semicolon.africa.dtos.requests.AddItemRequest;
import com.semicolon.africa.dtos.requests.GetAllItemCurrentStateRequest;
import com.semicolon.africa.dtos.requests.RemoveItemRequest;
import com.semicolon.africa.dtos.response.AddItemResponse;
import com.semicolon.africa.dtos.response.GetAllItemCurrentStateResponse;
import com.semicolon.africa.dtos.response.RemoveItemResponse;

import java.util.List;

public interface ItemServices {
    AddItemResponse addItem(AddItemRequest request);

    RemoveItemResponse removeItem(RemoveItemRequest request);

    List<GetAllItemCurrentStateResponse> getAllItemCurrentState(GetAllItemCurrentStateRequest request);
}
