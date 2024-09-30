package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.TrackItemQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackItemQuantityRepository extends JpaRepository<TrackItemQuantity, Long> {
    List<TrackItemQuantity> findTrackItemQuantitiesByUserId(long userId);

    List<TrackItemQuantity> findTrackItemQuantitiesByUserIdAndYear(long userId, int year);

    List<TrackItemQuantity> findTrackItemQuantitiesByUserIdAndMonth(long userId, int month);
}
