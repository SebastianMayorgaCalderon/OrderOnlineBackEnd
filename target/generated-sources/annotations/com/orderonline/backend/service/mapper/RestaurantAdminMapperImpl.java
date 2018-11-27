package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.RestaurantAdmin;
import com.orderonline.backend.service.dto.RestaurantAdminDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-27T12:53:31-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class RestaurantAdminMapperImpl implements RestaurantAdminMapper {

    @Override
    public RestaurantAdmin toEntity(RestaurantAdminDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RestaurantAdmin restaurantAdmin = new RestaurantAdmin();

        restaurantAdmin.setId( dto.getId() );
        restaurantAdmin.setName( dto.getName() );

        return restaurantAdmin;
    }

    @Override
    public RestaurantAdminDTO toDto(RestaurantAdmin entity) {
        if ( entity == null ) {
            return null;
        }

        RestaurantAdminDTO restaurantAdminDTO = new RestaurantAdminDTO();

        restaurantAdminDTO.setId( entity.getId() );
        restaurantAdminDTO.setName( entity.getName() );

        return restaurantAdminDTO;
    }

    @Override
    public List<RestaurantAdmin> toEntity(List<RestaurantAdminDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RestaurantAdmin> list = new ArrayList<RestaurantAdmin>( dtoList.size() );
        for ( RestaurantAdminDTO restaurantAdminDTO : dtoList ) {
            list.add( toEntity( restaurantAdminDTO ) );
        }

        return list;
    }

    @Override
    public List<RestaurantAdminDTO> toDto(List<RestaurantAdmin> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RestaurantAdminDTO> list = new ArrayList<RestaurantAdminDTO>( entityList.size() );
        for ( RestaurantAdmin restaurantAdmin : entityList ) {
            list.add( toDto( restaurantAdmin ) );
        }

        return list;
    }
}
