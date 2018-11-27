package com.orderonline.backend.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dishes.class)
public abstract class Dishes_ {

	public static volatile SetAttribute<Dishes, Offers> offers;
	public static volatile SingularAttribute<Dishes, byte[]> image;
	public static volatile SingularAttribute<Dishes, String> imageContentType;
	public static volatile SingularAttribute<Dishes, Restaurant> restaurant;
	public static volatile SingularAttribute<Dishes, String> name;
	public static volatile SingularAttribute<Dishes, Boolean> available;
	public static volatile SetAttribute<Dishes, PricePerProduct> pricePerProducts;
	public static volatile SingularAttribute<Dishes, String> description;
	public static volatile SetAttribute<Dishes, Combos> combos;
	public static volatile SingularAttribute<Dishes, Orders> dishes;
	public static volatile SingularAttribute<Dishes, Long> id;
	public static volatile SingularAttribute<Dishes, Category> category;

}

