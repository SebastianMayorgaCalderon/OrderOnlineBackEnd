package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.Category;
import com.orderonline.backend.domain.Restaurant;
import com.orderonline.backend.service.dto.CategoryDTO;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public List<Category> toEntity(List<CategoryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDTO categoryDTO : dtoList ) {
            list.add( toEntity( categoryDTO ) );
        }

        return list;
    }

    @Override
    public List<CategoryDTO> toDto(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public CategoryDTO toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        Long id = categoryRestaurantId( category );
        if ( id != null ) {
            categoryDTO.setRestaurantId( id );
        }
        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setRestaurant( restaurantMapper.fromId( categoryDTO.getRestaurantId() ) );
        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    private Long categoryRestaurantId(Category category) {
        if ( category == null ) {
            return null;
        }
        Restaurant restaurant = category.getRestaurant();
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
