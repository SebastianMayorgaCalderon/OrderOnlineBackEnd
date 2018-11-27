package com.orderonline.backend.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Restaurant.class)
public abstract class Restaurant_ {

	public static volatile SetAttribute<Restaurant, Offers> offers;
	public static volatile SingularAttribute<Restaurant, RestaurantAdmin> restaurantAdmin;
	public static volatile SingularAttribute<Restaurant, String> name;
	public static volatile SetAttribute<Restaurant, Dishes> dishes;
	public static volatile SetAttribute<Restaurant, Orders> orders;
	public static volatile SetAttribute<Restaurant, Combos> combos;
	public static volatile SingularAttribute<Restaurant, Long> id;
	public static volatile SetAttribute<Restaurant, Category> categories;

}

