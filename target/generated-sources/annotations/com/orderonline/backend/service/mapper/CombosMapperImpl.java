package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.Combos;
import com.orderonline.backend.domain.Offers;
import com.orderonline.backend.domain.Orders;
import com.orderonline.backend.domain.Restaurant;
import com.orderonline.backend.service.dto.CombosDTO;
import com.orderonline.backend.service.dto.OffersDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-29T15:16:58-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class CombosMapperImpl implements CombosMapper {

    @Autowired
    private OffersMapper offersMapper;
    @Autowired
    private RestaurantMapper restaurantMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Combos> toEntity(List<CombosDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Combos> list = new ArrayList<Combos>( dtoList.size() );
        for ( CombosDTO combosDTO : dtoList ) {
            list.add( toEntity( combosDTO ) );
        }

        return list;
    }

    @Override
    public List<CombosDTO> toDto(List<Combos> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CombosDTO> list = new ArrayList<CombosDTO>( entityList.size() );
        for ( Combos combos : entityList ) {
            list.add( toDto( combos ) );
        }

        return list;
    }

    @Override
    public CombosDTO toDto(Combos combos) {
        if ( combos == null ) {
            return null;
        }

        CombosDTO combosDTO = new CombosDTO();

        Long id = combosCombosId( combos );
        if ( id != null ) {
            combosDTO.setCombosId( id );
        }
        combosDTO.setCombosName( combos.getName() );
        Long id1 = combosRestaurantId( combos );
        if ( id1 != null ) {
            combosDTO.setRestaurantId( id1 );
        }
        combosDTO.setId( combos.getId() );
        combosDTO.setName( combos.getName() );
        combosDTO.setAvailable( combos.isAvailable() );
        combosDTO.setOffers( offersSetToOffersDTOSet( combos.getOffers() ) );

        return combosDTO;
    }

    @Override
    public Combos toEntity(CombosDTO combosDTO) {
        if ( combosDTO == null ) {
            return null;
        }

        Combos combos = new Combos();

        combos.setCombos( ordersMapper.fromId( combosDTO.getCombosId() ) );
        combos.setRestaurant( restaurantMapper.fromId( combosDTO.getRestaurantId() ) );
        combos.setId( combosDTO.getId() );
        combos.setName( combosDTO.getName() );
        combos.setAvailable( combosDTO.isAvailable() );
        combos.setOffers( offersDTOSetToOffersSet( combosDTO.getOffers() ) );

        return combos;
    }

    private Long combosCombosId(Combos combos) {
        if ( combos == null ) {
            return null;
        }
        Orders combos1 = combos.getCombos();
        if ( combos1 == null ) {
            return null;
        }
        Long id = combos1.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long combosRestaurantId(Combos combos) {
        if ( combos == null ) {
            return null;
        }
        Restaurant restaurant = combos.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long id = restaurant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Set<OffersDTO> offersSetToOffersDTOSet(Set<Offers> set) {
        if ( set == null ) {
            return null;
        }

        Set<OffersDTO> set1 = new HashSet<OffersDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Offers offers : set ) {
            set1.add( offersMapper.toDto( offers ) );
        }

        return set1;
    }

    protected Set<Offers> offersDTOSetToOffersSet(Set<OffersDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Offers> set1 = new HashSet<Offers>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OffersDTO offersDTO : set ) {
            set1.add( offersMapper.toEntity( offersDTO ) );
        }

        return set1;
    }
}
