package com.semicolon.africa.utilities;

import com.semicolon.africa.data.models.BookKeeping;
import com.semicolon.africa.data.models.Item;
import com.semicolon.africa.data.models.TrackItemQuantity;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.type.CategoryType;
import com.semicolon.africa.data.type.PaymentMethod;
import com.semicolon.africa.data.type.TransactionType;
import com.semicolon.africa.dtos.requests.AddItemRequest;
import com.semicolon.africa.dtos.requests.AddItemTrackRequest;
import com.semicolon.africa.dtos.requests.AddTransactionRequest;
import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.AddItemResponse;
import com.semicolon.africa.dtos.response.AddItemTrackResponse;
import com.semicolon.africa.dtos.response.AddTransactionResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;
import com.semicolon.africa.exception.InvalidEmailException;
import com.semicolon.africa.exception.InvalidNameException;

import java.util.Objects;

public class Mapper {


    public static Item map(Item newItem, AddItemRequest request) {
        newItem.setName(request.getName());
        CategoryType categoryType = CategoryType.valueOf(request.getCategory());
        newItem.setCategory(categoryType);
        newItem.setStock(request.getStock());
        newItem.setInventoryId(request.getInventoryId());
        newItem.setUserId(request.getUserId());
        newItem.setUnitPrice(request.getUnitPrice());
        return newItem;
    }

    public static AddItemResponse map(AddItemResponse addItemResponse, Item mappedItem, AddItemTrackResponse response) {
        addItemResponse.setItemId(mappedItem.getId());
        addItemResponse.setItemName(mappedItem.getName());
        addItemResponse.setCategoryType(mappedItem.getCategory());
        addItemResponse.setStock(mappedItem.getStock());
        addItemResponse.setMessage("Item added successfully");
        addItemResponse.setMessageFromTrackHistory(response.getMessage());
        addItemResponse.setUnitPrice(response.getUnitPrice());
        return addItemResponse;
    }

    public static void map(AddItemTrackRequest request1, Item mappedItem) {
        request1.setUserId(mappedItem.getUserId());
        request1.setItemId(mappedItem.getId());
        request1.setCategory(mappedItem.getCategory());
        request1.setStock(mappedItem.getStock());
        request1.setName(mappedItem.getName());
        request1.setUnitPrice(mappedItem.getUnitPrice());
    }

    public static void map(AddItemTrackRequest request, TrackItemQuantity trackItemQuantity) {
        trackItemQuantity.setItemId(request.getItemId());
        trackItemQuantity.setName(request.getName());
        trackItemQuantity.setUnitPrice(request.getUnitPrice());
        trackItemQuantity.setStock(request.getStock());
        trackItemQuantity.setCategory(request.getCategory());
        trackItemQuantity.setUserId(request.getUserId());
    }

    public static void map(AddItemTrackResponse response, TrackItemQuantity trackItemQuantity) {
        response.setName(trackItemQuantity.getName());
        response.setUnitPrice(trackItemQuantity.getUnitPrice());
        response.setStock(trackItemQuantity.getStock());
        response.setCategory(trackItemQuantity.getCategory());
        response.setMessage("Added Update");
    }

    public static void map(GetAllItemHistoryResponse mappedTrackedItemResponse, TrackItemQuantity trackItemQuantity1) {
        mappedTrackedItemResponse.setId(trackItemQuantity1.getId());
        mappedTrackedItemResponse.setName(trackItemQuantity1.getName());
        mappedTrackedItemResponse.setCategory(trackItemQuantity1.getCategory());
        mappedTrackedItemResponse.setStock(trackItemQuantity1.getStock());
        mappedTrackedItemResponse.setUserId(trackItemQuantity1.getUserId());
        mappedTrackedItemResponse.setDay(trackItemQuantity1.getDay());
        mappedTrackedItemResponse.setTime(trackItemQuantity1.getTime());
        mappedTrackedItemResponse.setMonth(trackItemQuantity1.getMonth());
        mappedTrackedItemResponse.setYear(trackItemQuantity1.getYear());
        mappedTrackedItemResponse.setItemId(trackItemQuantity1.getItemId());
    }

    public static void map(BookKeeping bookKeeping, AddTransactionRequest request) {
        bookKeeping.setReceiverName(request.getReceiverName());
        bookKeeping.setUserId(request.getUserId());
        bookKeeping.setSenderName(request.getSenderName());
        TransactionType newTransactionType = TransactionType.valueOf(request.getTransactionType());
        bookKeeping.setTransactionType(newTransactionType);
        PaymentMethod newPaymentMethod = PaymentMethod.valueOf(request.getPaymentMethod());
        bookKeeping.setPaymentMethod(newPaymentMethod);
    }

    public static void map(BookKeeping bookKeeping, AddTransactionResponse response) {
        response.setUserId(bookKeeping.getUserId());
        response.setReceiverName(bookKeeping.getReceiverName());
        response.setSenderName(bookKeeping.getSenderName());
        response.setPaymentMethod(bookKeeping.getPaymentMethod());
        response.setType(bookKeeping.getTransactionType());
        response.setYear(bookKeeping.getYear());
        response.setMonth(bookKeeping.getMonth());
        response.setDay(bookKeeping.getDay());
        response.setTime(bookKeeping.getTime());
        response.setMessage("Transaction Added To Record");
    }

    public User map(UserRegistrationRequest userRegistrationRequest, User user){
        user.setFirstName(userRegistrationRequest.getFirstName());
        user.setLastName(userRegistrationRequest.getLastName());
        user.setEmail(userRegistrationRequest.getEmail());
        user.setPassword(userRegistrationRequest.getPassword());
        user.setIndustry(userRegistrationRequest.getIndustry());
        user.setRole(userRegistrationRequest.getRole());
        return user;
    }

}
