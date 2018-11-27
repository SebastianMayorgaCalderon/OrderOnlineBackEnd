package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.Restaurant;
import com.orderonline.backend.domain.RestaurantAdmin;
import com.orderonline.backend.service.dto.RestaurantDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-27T08:34:53-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Autowired
    private RestaurantAdminMapper restaurantAdminMapper;

    @Override
    public List<Restaurant> toEntity(List<RestaurantDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Restaurant> list = new ArrayList<Restaurant>( dtoList.size() );
        for ( RestaurantDTO restaurantDTO : dtoList ) {
            list.add( toEntity( restaurantDTO ) );
        }

        return list;
    }

    @Override
    public List<RestaurantDTO> toDto(List<Restaurant> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RestaurantDTO> list = new ArrayList<RestaurantDTO>( entityList.size() );
        for ( Restaurant restaurant : entityList ) {
            list.add( toDto( restaurant ) );
        }

        return list;
    }

    @Override
    public RestaurantDTO toDto(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantDTO restaurantDTO = new RestaurantDTO();

        Long id = restaurantRestaurantAdminId( restaurant );
        if ( id != null ) {
            restaurantDTO.setRestaurantAdminId( id );
        }
        String name = restaurantRestaurantAdminName( restaurant );
        if ( name != null ) {
            restaurantDTO.setRestaurantAdminName( name );
        }
        restaurantDTO.setId( restaurant.getId() );
        restaurantDTO.setName( restaurant.getName() );

        return restaurantDTO;
    }

    @Override
    public Restaurant toEntity(RestaurantDTO restaurantDTO) {
        if ( restaurantDTO == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantAdmin( restaurantAdminMapper.fromId( restaurantDTO.getRestaurantAdminId() ) );
        restaurant.setId( restaurantDTO.getId() );
        restaurant.setName( restaurantDTO.getName() );

        return restaurant;
    }

    private Long restaurantRestaurantAdminId(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }
        RestaurantAdmin restaurantAdmin = restaurant.getRestaurantAdmin();
        if ( restaurantAdmin == null ) {
            return null;
        }
        Long id = restaurantAdmin.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String restaurantRestaurantAdminName(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }
        RestaurantAdmin restaurantAdmin = restaurant.getRestaurantAdmin();
        if ( restaurantAdmin == null ) {
            return null;
        }
        String name = restaurantAdmin.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
