package com.orderonline.backend.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Combos.class)
public abstract class Combos_ {

	public static volatile SetAttribute<Combos, Offers> offers;
	public static volatile SingularAttribute<Combos, Restaurant> restaurant;
	public static volatile SingularAttribute<Combos, String> name;
	public static volatile SingularAttribute<Combos, Boolean> available;
	public static volatile SetAttribute<Combos, PricePerProduct> pricePerProducts;
	public static volatile SingularAttribute<Combos, Orders> combos;
	public static volatile SetAttribute<Combos, Dishes> dishes;
	public static volatile SingularAttribute<Combos, Long> id;

}

