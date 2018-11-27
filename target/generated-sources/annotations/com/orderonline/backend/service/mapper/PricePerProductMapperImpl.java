package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.Combos;
import com.orderonline.backend.domain.Dishes;
import com.orderonline.backend.domain.PricePerProduct;
import com.orderonline.backend.service.dto.PricePerProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-27T12:53:31-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class PricePerProductMapperImpl implements PricePerProductMapper {

    @Autowired
    private DishesMapper dishesMapper;
    @Autowired
    private CombosMapper combosMapper;

    @Override
    public List<PricePerProduct> toEntity(List<PricePerProductDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PricePerProduct> list = new ArrayList<PricePerProduct>( dtoList.size() );
        for ( PricePerProductDTO pricePerProductDTO : dtoList ) {
            list.add( toEntity( pricePerProductDTO ) );
        }

        return list;
    }

    @Override
    public List<PricePerProductDTO> toDto(List<PricePerProduct> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PricePerProductDTO> list = new ArrayList<PricePerProductDTO>( entityList.size() );
        for ( PricePerProduct pricePerProduct : entityList ) {
            list.add( toDto( pricePerProduct ) );
        }

        return list;
    }

    @Override
    public PricePerProductDTO toDto(PricePerProduct pricePerProduct) {
        if ( pricePerProduct == null ) {
            return null;
        }

        PricePerProductDTO pricePerProductDTO = new PricePerProductDTO();

        Long id = pricePerProductProductDishId( pricePerProduct );
        if ( id != null ) {
            pricePerProductDTO.setProductDishId( id );
        }
        Long id1 = pricePerProductProductComboId( pricePerProduct );
        if ( id1 != null ) {
            pricePerProductDTO.setProductComboId( id1 );
        }
        pricePerProductDTO.setId( pricePerProduct.getId() );
        pricePerProductDTO.setPrice( pricePerProduct.getPrice() );
        pricePerProductDTO.setDate( pricePerProduct.getDate() );

        return pricePerProductDTO;
    }

    @Override
    public PricePerProduct toEntity(PricePerProductDTO pricePerProductDTO) {
        if ( pricePerProductDTO == null ) {
            return null;
        }

        PricePerProduct pricePerProduct = new PricePerProduct();

        pricePerProduct.setProductDish( dishesMapper.fromId( pricePerProductDTO.getProductDishId() ) );
        pricePerProduct.setProductCombo( combosMapper.fromId( pricePerProductDTO.getProductComboId() ) );
        pricePerProduct.setId( pricePerProductDTO.getId() );
        pricePerProduct.setPrice( pricePerProductDTO.getPrice() );
        pricePerProduct.setDate( pricePerProductDTO.getDate() );

        return pricePerProduct;
    }

    private Long pricePerProductProductDishId(PricePerProduct pricePerProduct) {
        if ( pricePerProduct == null ) {
            return null;
        }
        Dishes productDish = pricePerProduct.getProductDish();
        if ( productDish == null ) {
            return null;
        }
        Long id = productDish.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long pricePerProductProductComboId(PricePerProduct pricePerProduct) {
        if ( pricePerProduct == null ) {
            return null;
        }
        Combos productCombo = pricePerProduct.getProductCombo();
        if ( productCombo == null ) {
            return null;
        }
        Long id = productCombo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
