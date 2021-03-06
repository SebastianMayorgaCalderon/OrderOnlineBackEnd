package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.*;
import com.orderonline.backend.service.dto.RestaurantAdminDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RestaurantAdmin and its DTO RestaurantAdminDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RestaurantAdminMapper extends EntityMapper<RestaurantAdminDTO, RestaurantAdmin> {



    default RestaurantAdmin fromId(Long id) {
        if (id == null) {
            return null;
        }
        RestaurantAdmin restaurantAdmin = new RestaurantAdmin();
        restaurantAdmin.setId(id);
        return restaurantAdmin;
    }
}
