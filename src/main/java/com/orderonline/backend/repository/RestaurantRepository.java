package com.orderonline.backend.repository;
import java.util.Optional;

import com.orderonline.backend.domain.Restaurant;
import com.orderonline.backend.domain.RestaurantAdmin;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Restaurant entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findOneByRestaurantAdmin(RestaurantAdmin restaurantAdmin);
}
