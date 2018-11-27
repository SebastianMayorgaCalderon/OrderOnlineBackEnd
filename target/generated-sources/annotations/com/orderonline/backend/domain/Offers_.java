package com.orderonline.backend.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Offers.class)
public abstract class Offers_ {

	public static volatile SingularAttribute<Offers, Orders> offers;
	public static volatile SingularAttribute<Offers, byte[]> image;
	public static volatile SingularAttribute<Offers, Double> price;
	public static volatile SingularAttribute<Offers, String> imageContentType;
	public static volatile SingularAttribute<Offers, Restaurant> restaurant;
	public static volatile SingularAttribute<Offers, String> name;
	public static volatile SetAttribute<Offers, Dishes> dishes;
	public static volatile SetAttribute<Offers, Combos> combos;
	public static volatile SingularAttribute<Offers, Long> id;

}

