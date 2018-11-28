package com.orderonline.backend.service.mapper;

import com.orderonline.backend.domain.Orders;
import com.orderonline.backend.domain.Restaurant;
import com.orderonline.backend.service.dto.OrdersDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-28T09:07:04-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public List<Orders> toEntity(List<OrdersDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Orders> list = new ArrayList<Orders>( dtoList.size() );
        for ( OrdersDTO ordersDTO : dtoList ) {
            list.add( toEntity( ordersDTO ) );
        }

        return list;
    }

    @Override
    public List<OrdersDTO> toDto(List<Orders> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrdersDTO> list = new ArrayList<OrdersDTO>( entityList.size() );
        for ( Orders orders : entityList ) {
            list.add( toDto( orders ) );
        }

        return list;
    }

    @Override
    public OrdersDTO toDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        Long id = ordersRestaurantId( orders );
        if ( id != null ) {
            ordersDTO.setRestaurantId( id );
        }
        ordersDTO.setId( orders.getId() );
        ordersDTO.setTotalPrice( orders.getTotalPrice() );
        ordersDTO.setSubTotalPrice( orders.getSubTotalPrice() );
        ordersDTO.setIvi( orders.getIvi() );
        ordersDTO.setDate( orders.getDate() );
        ordersDTO.setAvailable( orders.isAvailable() );

        return ordersDTO;
    }

    @Override
    public Orders toEntity(OrdersDTO ordersDTO) {
        if ( ordersDTO == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setRestaurant( restaurantMapper.fromId( ordersDTO.getRestaurantId() ) );
        orders.setId( ordersDTO.getId() );
        orders.setTotalPrice( ordersDTO.getTotalPrice() );
        orders.setSubTotalPrice( ordersDTO.getSubTotalPrice() );
        orders.setIvi( ordersDTO.getIvi() );
        orders.setDate( ordersDTO.getDate() );
        orders.setAvailable( ordersDTO.isAvailable() );

        return orders;
    }

    private Long ordersRestaurantId(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Restaurant restaurant = orders.getRestaurant();
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
