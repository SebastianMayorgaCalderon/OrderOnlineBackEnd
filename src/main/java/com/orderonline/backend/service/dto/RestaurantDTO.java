package com.orderonline.backend.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Restaurant entity.
 */
public class RestaurantDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private Long restaurantAdminId;

    private String restaurantAdminName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRestaurantAdminId() {
        return restaurantAdminId;
    }

    public void setRestaurantAdminId(Long restaurantAdminId) {
        this.restaurantAdminId = restaurantAdminId;
    }

    public String getRestaurantAdminName() {
        return restaurantAdminName;
    }

    public void setRestaurantAdminName(String restaurantAdminName) {
        this.restaurantAdminName = restaurantAdminName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RestaurantDTO restaurantDTO = (RestaurantDTO) o;
        if (restaurantDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), restaurantDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", restaurantAdmin=" + getRestaurantAdminId() +
            ", restaurantAdmin='" + getRestaurantAdminName() + "'" +
            "}";
    }
}
