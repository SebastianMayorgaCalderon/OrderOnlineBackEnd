package com.orderonline.backend.repository;
import java.util.Optional;

import com.orderonline.backend.domain.Category;
import com.orderonline.backend.domain.Restaurant;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Spring Data  repository for the Category entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByRestaurant(Pageable pageable, Restaurant restaurant);
}
