package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.Category;
import com.orderonline.backend.domain.Combos;
import com.orderonline.backend.domain.Dishes;
import com.orderonline.backend.domain.Offers;
import com.orderonline.backend.domain.Orders;
import com.orderonline.backend.domain.Restaurant;
import com.orderonline.backend.service.dto.CombosDTO;
import com.orderonline.backend.service.dto.DishesDTO;
import com.orderonline.backend.service.dto.OffersDTO;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DishesMapperImpl implements DishesMapper {

    @Autowired
    private CombosMapper combosMapper;
    @Autowired
    private OffersMapper offersMapper;
    @Autowired
    private RestaurantMapper restaurantMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Dishes> toEntity(List<DishesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Dishes> list = new ArrayList<Dishes>( dtoList.size() );
        for ( DishesDTO dishesDTO : dtoList ) {
            list.add( toEntity( dishesDTO ) );
        }

        return list;
    }

    @Override
    public List<DishesDTO> toDto(List<Dishes> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DishesDTO> list = new ArrayList<DishesDTO>( entityList.size() );
        for ( Dishes dishes : entityList ) {
            list.add( toDto( dishes ) );
        }

        return list;
    }

    @Override
    public DishesDTO toDto(Dishes dishes) {
        if ( dishes == null ) {
            return null;
        }

        DishesDTO dishesDTO = new DishesDTO();

        dishesDTO.setDishesName( dishes.getName() );
        Long id = dishesDishesId( dishes );
        if ( id != null ) {
            dishesDTO.setDishesId( id );
        }
        Long id1 = dishesRestaurantId( dishes );
        if ( id1 != null ) {
            dishesDTO.setRestaurantId( id1 );
        }
        String name = dishesCategoryName( dishes );
        if ( name != null ) {
            dishesDTO.setCategoryName( name );
        }
        Long id2 = dishesCategoryId( dishes );
        if ( id2 != null ) {
            dishesDTO.setCategoryId( id2 );
        }
        dishesDTO.setId( dishes.getId() );
        dishesDTO.setName( dishes.getName() );
        dishesDTO.setDescription( dishes.getDescription() );
        dishesDTO.setAvailable( dishes.isAvailable() );
        byte[] image = dishes.getImage();
        if ( image != null ) {
            dishesDTO.setImage( Arrays.copyOf( image, image.length ) );
        }
        dishesDTO.setImageContentType( dishes.getImageContentType() );
        dishesDTO.setCombos( combosSetToCombosDTOSet( dishes.getCombos() ) );
        dishesDTO.setOffers( offersSetToOffersDTOSet( dishes.getOffers() ) );

        return dishesDTO;
    }

    @Override
    public Dishes toEntity(DishesDTO dishesDTO) {
        if ( dishesDTO == null ) {
            return null;
        }

        Dishes dishes = new Dishes();

        dishes.setDishes( ordersMapper.fromId( dishesDTO.getDishesId() ) );
        dishes.setCategory( categoryMapper.fromId( dishesDTO.getCategoryId() ) );
        dishes.setRestaurant( restaurantMapper.fromId( dishesDTO.getRestaurantId() ) );
        dishes.setId( dishesDTO.getId() );
        dishes.setName( dishesDTO.getName() );
        dishes.setDescription( dishesDTO.getDescription() );
        dishes.setAvailable( dishesDTO.isAvailable() );
        byte[] image = dishesDTO.getImage();
        if ( image != null ) {
            dishes.setImage( Arrays.copyOf( image, image.length ) );
        }
        dishes.setImageContentType( dishesDTO.getImageContentType() );
        dishes.setCombos( combosDTOSetToCombosSet( dishesDTO.getCombos() ) );
        dishes.setOffers( offersDTOSetToOffersSet( dishesDTO.getOffers() ) );

        return dishes;
    }

    private Long dishesDishesId(Dishes dishes) {
        if ( dishes == null ) {
            return null;
        }
        Orders dishes1 = dishes.getDishes();
        if ( dishes1 == null ) {
            return null;
        }
        Long id = dishes1.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long dishesRestaurantId(Dishes dishes) {
        if ( dishes == null ) {
            return null;
        }
        Restaurant restaurant = dishes.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long id = restaurant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String dishesCategoryName(Dishes dishes) {
        if ( dishes == null ) {
            return null;
        }
        Category category = dishes.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long dishesCategoryId(Dishes dishes) {
        if ( dishes == null ) {
            return null;
        }
        Category category = dishes.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Set<CombosDTO> combosSetToCombosDTOSet(Set<Combos> set) {
        if ( set == null ) {
            return null;
        }

        Set<CombosDTO> set1 = new HashSet<CombosDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Combos combos : set ) {
            set1.add( combosMapper.toDto( combos ) );
        }

        return set1;
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

    protected Set<Combos> combosDTOSetToCombosSet(Set<CombosDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Combos> set1 = new HashSet<Combos>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CombosDTO combosDTO : set ) {
            set1.add( combosMapper.toEntity( combosDTO ) );
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
