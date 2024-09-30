package com.semicolon.africa.services.ServiceImplementations;
import com.semicolon.africa.data.repositories.TrackItemQuantityRepository;
import com.semicolon.africa.dtos.requests.AddItemRequest;
import com.semicolon.africa.dtos.requests.AddItemTrackRequest;
import com.semicolon.africa.dtos.requests.GetAllItemCurrentStateRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryRequest;
import com.semicolon.africa.dtos.response.AddItemResponse;
import com.semicolon.africa.dtos.response.AddItemTrackResponse;
import com.semicolon.africa.dtos.response.GetAllItemCurrentStateResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static com.semicolon.africa.data.type.CategoryType.ELECTRONICS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InventoryReportServicesImplTest {
    @Autowired
    private InventoryReportServicesImpl inventoryReportServices;

    @Autowired
    private ItemServicesImpl itemServices;

    @Autowired
    private TrackItemQuantityServicesImpl trackItemQuantityServices;

    @Autowired
    TrackItemQuantityRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    public void testThatGetAllCurrentStateOfAllItems() {
        AddItemRequest request = new AddItemRequest();
        request.setName("Stock");
        request.setCategory("ELECTRONICS");
        request.setStock(15L);
        request.setInventoryId(1L);
        request.setUnitPrice(205L);
        request.setUserId(5L);
        AddItemResponse response = itemServices.addItem(request);
        assertThat(response.getMessage()).isEqualTo("Item added successfully");

        AddItemRequest request1 = new AddItemRequest();
        request1.setName("Stock");
        request1.setCategory("COMPUTER");
        request1.setStock(16L);
        request1.setInventoryId(2L);
        request1.setUnitPrice(215L);
        request1.setUserId(5L);
        AddItemResponse response1 = itemServices.addItem(request1);
        assertThat(response1.getMessage()).isEqualTo("Item added successfully");

        GetAllItemCurrentStateRequest request2 = new GetAllItemCurrentStateRequest();
        request2.setUserId(5L);
        List<GetAllItemCurrentStateResponse> response3 = inventoryReportServices.getAllItemCurrentState(request2);
        assertThat(response3.size()).isEqualTo(2);
    }

    @Test
    public void testThatUserCanGetAllItemHistory() {
        AddItemTrackRequest request = new AddItemTrackRequest();
        request.setName("Stock");
        request.setCategory(ELECTRONICS);
        request.setStock(15L);
        request.setUnitPrice(205L);
        request.setUserId(5L);
        AddItemTrackResponse response = trackItemQuantityServices.addAllItemUpdate(request);
        assertThat(response.getMessage()).isEqualTo("Added Update");

        GetAllTrackItemHistoryRequest request1 = new GetAllTrackItemHistoryRequest();
        request1.setUserId(5L);
        List<GetAllItemHistoryResponse> response1 = inventoryReportServices.getAllItemHistory(request1);
        AssertionsForClassTypes.assertThat(response1.size()).isEqualTo(1);
    }
}