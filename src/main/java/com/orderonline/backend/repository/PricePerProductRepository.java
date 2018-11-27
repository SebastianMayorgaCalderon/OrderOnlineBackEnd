package com.orderonline.backend.repository;

import com.orderonline.backend.domain.PricePerProduct;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PricePerProduct entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PricePerProductRepository extends JpaRepository<PricePerProduct, Long> {

}
