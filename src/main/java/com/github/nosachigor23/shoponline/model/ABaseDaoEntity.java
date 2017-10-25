package com.github.nosachigor23.shoponline.model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public abstract class ABaseDaoEntity {

/*

	static private boolean validationDiscountAction(Class cla) {

		if (cla == AccessoriesEntity.class && ()) {
			return true;
		} else if (cla == DisplayEntity.class && (day.matches("MONDAY|TUESDAY|SUNDAY"))) {
			return true;
		} else if (cla == InputDeviceEntity.class && (day.matches("TUESDAY|WEDNESDAY"))) {
			return true;
		} else if (cla == PeripheralsEntity.class && (day.matches("WEDNESDAY|THURSDAY"))) {
			return true;
		} else return cla == StorageDeviceEntity.class && (day.matches("THURSDAY|FRIDAY|SATURADY"));

	}

	protected int calculateDiscount(Object object) {
		final Class objectClass = object.getClass();

		if (!validationDiscountAction(objectClass)) return 0;


		if (objectClass == InputDeviceEntity.class) {
			InputDeviceEntity inputDeviceEntity = InputDeviceEntity.class.cast(object);
			{

					defaultDiscount = 40;
				}
			}

		} else if (objectClass == DisplayEntity.class) {
			DisplayEntity displayEntity = DisplayEntity.class.cast(object);
			defaultDiscount = displayEntity.getDiagonal();

		} else if (objectClass == StorageDeviceEntity.class) {
			StorageDeviceEntity storageDeviceEntity = StorageDeviceEntity.class.cast(object);
			final int sde_defaultValue = 10;
			String localManufacturer = storageDeviceEntity.getManufacturer();
			if (localManufacturer.equalsIgnoreCase("kingston")) {
				defaultDiscount = sde_defaultValue / 2;
			} else if (localManufacturer.equalsIgnoreCase("samsung")) {
				defaultDiscount = sde_defaultValue / 3;
			} else defaultDiscount = sde_defaultValue;
		}

		return defaultDiscount;

	}

	*/


}
