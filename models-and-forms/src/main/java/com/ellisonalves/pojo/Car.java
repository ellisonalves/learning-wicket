package com.ellisonalves.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple pojo for this example.
 *
 * @author Ellison
 */
public class Car implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				id;
	private String				name;

	private Car(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static List<Car> getCarList() {
		return new ArrayList<Car>() {
			private static final long	serialVersionUID	= 1L;

			{
				add(new Car(1l, "Polo"));
				add(new Car(2l, "Duster"));
				add(new Car(3l, "306"));
				add(new Car(4l, "Brava"));
				add(new Car(5l, "Audi a4"));
				add(new Car(6l, "Astra"));
			}
		};
	}

}