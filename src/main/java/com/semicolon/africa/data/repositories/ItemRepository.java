package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Item;
import com.semicolon.africa.data.type.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsByName(String name);

    Optional<Item> getItemsByNameAndCategoryAndUserId(String name, CategoryType category, Long userId);

    boolean existsByCategory(CategoryType category);

    boolean existsByUserId(Long userId);

    List<Item> getItemsByUserId(Long userId);
}
