package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.Offers;
import com.orderonline.backend.domain.Orders;
import com.orderonline.backend.domain.Restaurant;
import com.orderonline.backend.service.dto.OffersDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-28T12:36:50-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class OffersMapperImpl implements OffersMapper {

    @Autowired
    private RestaurantMapper restaurantMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Offers> toEntity(List<OffersDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Offers> list = new ArrayList<Offers>( dtoList.size() );
        for ( OffersDTO offersDTO : dtoList ) {
            list.add( toEntity( offersDTO ) );
        }

        return list;
    }

    @Override
    public List<OffersDTO> toDto(List<Offers> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OffersDTO> list = new ArrayList<OffersDTO>( entityList.size() );
        for ( Offers offers : entityList ) {
            list.add( toDto( offers ) );
        }

        return list;
    }

    @Override
    public OffersDTO toDto(Offers offers) {
        if ( offers == null ) {
            return null;
        }

        OffersDTO offersDTO = new OffersDTO();

        offersDTO.setOffersName( offers.getName() );
        Long id = offersOffersId( offers );
        if ( id != null ) {
            offersDTO.setOffersId( id );
        }
        Long id1 = offersRestaurantId( offers );
        if ( id1 != null ) {
            offersDTO.setRestaurantId( id1 );
        }
        offersDTO.setId( offers.getId() );
        offersDTO.setName( offers.getName() );
        offersDTO.setPrice( offers.getPrice() );
        byte[] image = offers.getImage();
        if ( image != null ) {
            offersDTO.setImage( Arrays.copyOf( image, image.length ) );
        }
        offersDTO.setImageContentType( offers.getImageContentType() );

        return offersDTO;
    }

    @Override
    public Offers toEntity(OffersDTO offersDTO) {
        if ( offersDTO == null ) {
            return null;
        }

        Offers offers = new Offers();

        offers.setOffers( ordersMapper.fromId( offersDTO.getOffersId() ) );
        offers.setRestaurant( restaurantMapper.fromId( offersDTO.getRestaurantId() ) );
        offers.setId( offersDTO.getId() );
        offers.setName( offersDTO.getName() );
        offers.setPrice( offersDTO.getPrice() );
        byte[] image = offersDTO.getImage();
        if ( image != null ) {
            offers.setImage( Arrays.copyOf( image, image.length ) );
        }
        offers.setImageContentType( offersDTO.getImageContentType() );

        return offers;
    }

    private Long offersOffersId(Offers offers) {
        if ( offers == null ) {
            return null;
        }
        Orders offers1 = offers.getOffers();
        if ( offers1 == null ) {
            return null;
        }
        Long id = offers1.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long offersRestaurantId(Offers offers) {
        if ( offers == null ) {
            return null;
        }
        Restaurant restaurant = offers.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long id = restaurant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
