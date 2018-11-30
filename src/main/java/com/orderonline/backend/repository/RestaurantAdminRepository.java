package com.orderonline.backend.repository;

import java.util.Optional;

import com.orderonline.backend.domain.RestaurantAdmin;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the RestaurantAdmin entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RestaurantAdminRepository extends JpaRepository<RestaurantAdmin, Long> {
    Optional<RestaurantAdmin> findOneByUserEmail(String email);
}
