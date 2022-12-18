package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.istic.nplouzeau.cartaylor.api.*;

/*
 * Snippet to add to your PartTypeImpl to support
 * the V2 API
 */ 
public class PartTypeImpl implements PartType {
	private String name;
	private Class<? extends PartImpl> classRef;
	private Category category;
	public PartTypeImpl(String name, Class<? extends PartImpl> classRef, Category category) {
		this.name = name;
		this.classRef = classRef;
		this.category = category;
	}
	public PartImpl newInstance() {
		Constructor<? extends PartImpl> constructor;
		try {
			constructor = classRef.getConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "constructor call failed", e);
			System.exit(-1);
		}
		return null;
	}


	public String getName() {
		return null;
	}

	public CategoryImpl getCategory() {
		return null;
	}
}
