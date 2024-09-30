package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.data.models.Item;
import com.semicolon.africa.data.repositories.ItemRepository;
import com.semicolon.africa.data.type.CategoryType;
import com.semicolon.africa.dtos.requests.AddItemRequest;
import com.semicolon.africa.dtos.requests.AddItemTrackRequest;
import com.semicolon.africa.dtos.requests.GetAllItemCurrentStateRequest;
import com.semicolon.africa.dtos.requests.RemoveItemRequest;
import com.semicolon.africa.dtos.response.AddItemResponse;
import com.semicolon.africa.dtos.response.AddItemTrackResponse;
import com.semicolon.africa.dtos.response.GetAllItemCurrentStateResponse;
import com.semicolon.africa.dtos.response.RemoveItemResponse;
import com.semicolon.africa.exception.ItemException;
import com.semicolon.africa.services.Interfaces.ItemServices;
import com.semicolon.africa.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemServicesImpl implements ItemServices {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    TrackItemQuantityServicesImpl trackItemQuantityServices = new TrackItemQuantityServicesImpl();

    @Override
    public AddItemResponse addItem(AddItemRequest request) {
        Item newItem = new Item();
        if(findItemByName(request.getName()) && findItemByCategory(request.getCategory()) && findItemByUserId(request.getUserId()) ){
            return updateItem(request);
        }
        Item mappedItem  = Mapper.map(newItem,request);
        itemRepository.save(mappedItem);
        AddItemResponse addItemResponse = new AddItemResponse();
        AddItemTrackRequest request1 = new AddItemTrackRequest();
        Mapper.map(request1,mappedItem);
        AddItemTrackResponse response = trackItemQuantityServices.addAllItemUpdate(request1);
        return Mapper.map(addItemResponse,mappedItem,response);
    }

    private boolean findItemByUserId(Long userId) {
        return itemRepository.existsByUserId(userId);
    }

    private AddItemResponse updateItem(AddItemRequest request) {
        CategoryType categoryType = CategoryType.valueOf(request.getCategory());
        Item item = itemRepository.getItemsByNameAndCategoryAndUserId(request.getName(),categoryType,request.getUserId())
                .orElseThrow(()->new ItemException("item not found"));
        item.setStock(request.getStock()+item.getStock());
        itemRepository.save(item);
        AddItemTrackRequest request1 = new AddItemTrackRequest();
        Mapper.map(request1,item);
        AddItemTrackResponse response = trackItemQuantityServices.addAllItemUpdate(request1);
        AddItemResponse addItemResponse = new AddItemResponse();
        return Mapper.map(addItemResponse, item, response);
    }

    private boolean findItemByCategory(String category) {
        CategoryType newCategory=  CategoryType.valueOf(category.toUpperCase());
        return itemRepository.existsByCategory(newCategory);
    }

    private boolean findItemByName(String name) {

        return itemRepository.existsByName(name);
    }

    @Override
    public RemoveItemResponse removeItem(RemoveItemRequest request) {
        RemoveItemResponse removeItemResponse = new RemoveItemResponse();
        AddItemTrackResponse response = new AddItemTrackResponse();
        if(findItemByName(request.getName()) && findItemByCategory(request.getCategory()) && findItemByUserId(request.getUserId()) ){
            CategoryType categoryType = CategoryType.valueOf(request.getCategory());
            Item item = itemRepository.getItemsByNameAndCategoryAndUserId(request.getName(),categoryType,request.getUserId())
                    .orElseThrow(()->new ItemException("item not found"));
            if(request.getStock() <= item.getStock()) {
                item.setStock(item.getStock() - request.getStock());
                itemRepository.save(item);
                AddItemTrackRequest request1 = new AddItemTrackRequest();
                Mapper.map(request1,item);
                response = trackItemQuantityServices.addAllItemUpdate(request1);
            }
            else throw new ItemException("Can,t remove more than the what you have");
            removeItemResponse.setStock(item.getStock());
            removeItemResponse.setItemId(item.getId());
            removeItemResponse.setUserId(item.getUserId());
            removeItemResponse.setUnitPrice(item.getUnitPrice());
            removeItemResponse.setMessage("Successfully removed item");

            removeItemResponse.setMessageFromTrackItemHistory(response.getMessage());
        }else {
            throw new ItemException("item not found");
        }
        return removeItemResponse;
    }

    @Override
    public List<GetAllItemCurrentStateResponse> getAllItemCurrentState(GetAllItemCurrentStateRequest request) {
        List<Item> items = itemRepository.getItemsByUserId(request.getUserId());
        List<GetAllItemCurrentStateResponse> getAllItemCurrentStateResponse = new ArrayList<>();
        return mapAllItemIntoGetAllItemCurrentStateResponse(items,getAllItemCurrentStateResponse);
    }

    private List<GetAllItemCurrentStateResponse> mapAllItemIntoGetAllItemCurrentStateResponse(List<Item> items, List<GetAllItemCurrentStateResponse> getAllItemCurrentStateResponse) {
        for (Item item : items) {
            GetAllItemCurrentStateResponse response = new GetAllItemCurrentStateResponse();
            response.setId(item.getId());
            response.setName(item.getName());
            response.setCategory(item.getCategory());
            response.setStock(item.getStock());
            response.setUnitPrice(item.getUnitPrice());
            response.setInventoryId(item.getInventoryId());
            response.setUserId(item.getUserId());
            getAllItemCurrentStateResponse.add(response);
        }
        return getAllItemCurrentStateResponse;
    }
}
