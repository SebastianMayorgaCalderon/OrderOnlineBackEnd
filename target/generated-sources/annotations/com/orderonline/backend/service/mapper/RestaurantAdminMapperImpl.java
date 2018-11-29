package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.RestaurantAdmin;
import com.orderonline.backend.domain.User;
import com.orderonline.backend.service.dto.RestaurantAdminDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-29T15:16:58-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class RestaurantAdminMapperImpl implements RestaurantAdminMapper {

    @Autowired
    private UserMapper userMapper;

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

    @Override
    public RestaurantAdminDTO toDto(RestaurantAdmin restaurantAdmin) {
        if ( restaurantAdmin == null ) {
            return null;
        }

        RestaurantAdminDTO restaurantAdminDTO = new RestaurantAdminDTO();

        Long id = restaurantAdminUserId( restaurantAdmin );
        if ( id != null ) {
            restaurantAdminDTO.setUserId( id );
        }
        restaurantAdminDTO.setId( restaurantAdmin.getId() );
        restaurantAdminDTO.setName( restaurantAdmin.getName() );

        return restaurantAdminDTO;
    }

    @Override
    public RestaurantAdmin toEntity(RestaurantAdminDTO restaurantAdminDTO) {
        if ( restaurantAdminDTO == null ) {
            return null;
        }

        RestaurantAdmin restaurantAdmin = new RestaurantAdmin();

        restaurantAdmin.setUser( userMapper.userFromId( restaurantAdminDTO.getUserId() ) );
        restaurantAdmin.setId( restaurantAdminDTO.getId() );
        restaurantAdmin.setName( restaurantAdminDTO.getName() );

        return restaurantAdmin;
    }

    private Long restaurantAdminUserId(RestaurantAdmin restaurantAdmin) {
        if ( restaurantAdmin == null ) {
            return null;
        }
        User user = restaurantAdmin.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
