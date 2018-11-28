package com.orderonline.backend.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orders.class)
public abstract class Orders_ {

	public static volatile SingularAttribute<Orders, Instant> date;
	public static volatile SetAttribute<Orders, Offers> offers;
	public static volatile SingularAttribute<Orders, Double> totalPrice;
	public static volatile SingularAttribute<Orders, Restaurant> restaurant;
	public static volatile SingularAttribute<Orders, Boolean> available;
	public static volatile SingularAttribute<Orders, String> details;
	public static volatile SetAttribute<Orders, Dishes> dishes;
	public static volatile SetAttribute<Orders, Combos> combos;
	public static volatile SingularAttribute<Orders, Long> id;
	public static volatile SingularAttribute<Orders, Double> ivi;
	public static volatile SingularAttribute<Orders, Double> subTotalPrice;
	public static volatile SingularAttribute<Orders, Integer> tableNumber;

}

