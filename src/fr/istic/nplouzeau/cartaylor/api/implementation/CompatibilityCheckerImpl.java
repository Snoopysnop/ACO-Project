package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.*;


public class CompatibilityCheckerImpl implements CompatibilityChecker{

	Set<PartType> incompatibilities ;
	Set<PartType> requirements ;

	public CompatibilityCheckerImpl(Set<PartType> incompatibilities, Set<PartType> requirements ) {
		this.incompatibilities=incompatibilities;
		this.requirements=requirements;
	}

	public Set<PartType> getIncompatibilities(PartType reference){
		return incompatibilities;
	}

	public Set<PartType> getRequirements(PartType reference){
		return requirements;
	}


}
