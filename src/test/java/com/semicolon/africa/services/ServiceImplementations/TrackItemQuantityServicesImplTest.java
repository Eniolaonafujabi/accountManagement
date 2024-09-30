package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.data.repositories.TrackItemQuantityRepository;
import com.semicolon.africa.dtos.requests.AddItemTrackRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryByMonthRequest;
import com.semicolon.africa.dtos.requests.GetAllTrackItemHistoryRequest;
import com.semicolon.africa.dtos.response.AddItemTrackResponse;
import com.semicolon.africa.dtos.response.GetAllItemHistoryResponse;
import com.semicolon.africa.services.Interfaces.TrackItemQuantityServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.semicolon.africa.data.type.CategoryType.ELECTRONICS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TrackItemQuantityServicesImplTest {

    @Autowired
    TrackItemQuantityServices trackItemQuantityServices;

    @Autowired
    TrackItemQuantityRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    public void testThatYouCanKeepTrackOfItemAndReceiveAResponse() {
        AddItemTrackRequest request = new AddItemTrackRequest();
        request.setItemId(1L);
        request.setName("Test");
        request.setStock(6L);
        request.setUnitPrice(105L);
        request.setCategory(ELECTRONICS);
        request.setUserId(1L);
        AddItemTrackResponse response = trackItemQuantityServices.addAllItemUpdate(request);
        assertThat(response.getMessage()).isEqualTo("Added Update");
    }

    @Test
    public void testThatUserCanAddTwoHistoryOfSameItemAndCategoryAndUserId() {
        AddItemTrackRequest request = new AddItemTrackRequest();
        request.setItemId(1L);
        request.setName("Test");
        request.setStock(7L);
        request.setCategory(ELECTRONICS);
        request.setUnitPrice(105L);
        request.setUserId(1L);
        AddItemTrackResponse response = trackItemQuantityServices.addAllItemUpdate(request);
        assertThat(response.getMessage()).isEqualTo("Added Update");

        AddItemTrackRequest request1 = new AddItemTrackRequest();
        request1.setItemId(1L);
        request1.setName("Test");
        request.setUnitPrice(105L);
        request1.setStock(7L);
        request1.setCategory(ELECTRONICS);
        request1.setUserId(1L);
        AddItemTrackResponse response1 = trackItemQuantityServices.addAllItemUpdate(request1);
        assertThat(response1.getMessage()).isEqualTo("Added Update");
    }

    @Test
    public void testThatUserCanGetAllHistoryOfAUser(){
        AddItemTrackRequest request = new AddItemTrackRequest();
        request.setItemId(1L);
        request.setName("Test");
        request.setStock(7L);
        request.setCategory(ELECTRONICS);
        request.setUnitPrice(105L);
        request.setUserId(1L);
        AddItemTrackResponse response = trackItemQuantityServices.addAllItemUpdate(request);
        assertThat(response.getMessage()).isEqualTo("Added Update");

        AddItemTrackRequest request1 = new AddItemTrackRequest();
        request1.setItemId(1L);
        request.setUnitPrice(105L);
        request1.setName("Test");
        request1.setStock(7L);
        request1.setCategory(ELECTRONICS);
        request1.setUserId(1L);
        AddItemTrackResponse response1 = trackItemQuantityServices.addAllItemUpdate(request1);
        assertThat(response1.getMessage()).isEqualTo("Added Update");

        AddItemTrackRequest request2 = new AddItemTrackRequest();
        request2.setItemId(1L);
        request2.setName("Test");
        request.setUnitPrice(105L);
        request2.setStock(7L);
        request2.setCategory(ELECTRONICS);
        request2.setUserId(1L);
        AddItemTrackResponse response2 = trackItemQuantityServices.addAllItemUpdate(request2);
        assertThat(response2.getMessage()).isEqualTo("Added Update");

        GetAllTrackItemHistoryRequest request3 = new GetAllTrackItemHistoryRequest();
        request3.setUserId(1L);
        List<GetAllItemHistoryResponse> response3 = trackItemQuantityServices.getAllTrackItemHistory(request3);
        assertThat(response3.size()).isEqualTo(3);
    }

    //NEEDS DOMI FILE IN DB TO TEST
//    @Test
//    public void testThatICanGetItemHistoryOfYear_2024_UsingDomeData(){
//        GetAllTrackItemHistoryByYearRequest request = new GetAllTrackItemHistoryByYearRequest();
//        request.setUserId(1L);
//        request.setYear(2023);
//        request.setUnitPrice(105L);
//        List<GetAllItemHistoryResponse> response3 = trackItemQuantityServices.getAllTrackItemHistoryByDate(request);
//        assertThat(response3.size()).isEqualTo(2);
//    }

    @Test
    public void testThatICanGetItemHistoryOfYear_2024_UsingDomeData(){
        AddItemTrackRequest request1 = new AddItemTrackRequest();
        request1.setItemId(1L);
        request1.setName("Test");
        request1.setStock(7L);
        request1.setUnitPrice(105L);
        request1.setCategory(ELECTRONICS);
        request1.setUserId(1L);
        AddItemTrackResponse response1 = trackItemQuantityServices.addAllItemUpdate(request1);
        assertThat(response1.getMessage()).isEqualTo("Added Update");

        AddItemTrackRequest request2 = new AddItemTrackRequest();
        request2.setItemId(1L);
        request2.setName("Test");
        request2.setStock(7L);
        request2.setUnitPrice(105L);
        request2.setCategory(ELECTRONICS);
        request2.setUserId(1L);
        AddItemTrackResponse response2 = trackItemQuantityServices.addAllItemUpdate(request2);
        assertThat(response2.getMessage()).isEqualTo("Added Update");

        GetAllTrackItemHistoryByMonthRequest request = new GetAllTrackItemHistoryByMonthRequest();
        request.setUserId(1L);
        request2.setUnitPrice(105L);
        request.setMonth(9);
        List<GetAllItemHistoryResponse> response3 = trackItemQuantityServices.getAllTrackItemHistoryByMonth(request);
        assertThat(response3.size()).isEqualTo(2);
    }
}