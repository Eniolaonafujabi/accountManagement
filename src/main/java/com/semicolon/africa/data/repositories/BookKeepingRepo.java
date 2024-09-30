package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.BookKeeping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookKeepingRepo extends JpaRepository<BookKeeping, Long>{
    List<BookKeeping> getBookKeepingByUserId(Long userId);

    List<BookKeeping> getBookKeepingByUserIdAndYear(Long userId, int year);

    List<BookKeeping> getBookKeepingByUserIdAndMonth(long userId, int month);

}
