package com.orderonline.backend.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PricePerProduct.class)
public abstract class PricePerProduct_ {

	public static volatile SingularAttribute<PricePerProduct, Instant> date;
	public static volatile SingularAttribute<PricePerProduct, Combos> productCombo;
	public static volatile SingularAttribute<PricePerProduct, Double> price;
	public static volatile SingularAttribute<PricePerProduct, Dishes> productDish;
	public static volatile SingularAttribute<PricePerProduct, Long> id;

}

