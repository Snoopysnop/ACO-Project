package fr.istic.nplouzeau.cartaylor.api.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.*;



public class ConfigurationImpl implements Configuration {

	private Set<Part> config = new HashSet<Part>();
	
	private ConfiguratorImpl configurator;
	private CompatibilityChecker checker;
	
	public ConfigurationImpl(ConfiguratorImpl configurator) {
		this.configurator=configurator;				
	}
    public boolean isValid() {
    	checker=configurator.getCompatibilityChecker();
    	for(Part part: config) {
    		Set<PartType> listIncompatibilities = checker.getIncompatibilities(part.getType());
    		if(!listIncompatibilities.isEmpty()){
    			for(Part p: config) {
    				if(p.getType().getName()!=part.getType().getName()) {
    					if(listIncompatibilities.contains(p.getType())) {
    						return false;
    					}
    				}
    			}
    		}
    		Set<PartType> listRequierements = checker.getRequirements(part.getType());
    		if(!listRequierements.isEmpty()) {
    			for(PartType p: listRequierements) {
    				boolean present = false;
    				for(Part p2:config) {
    					if(p2.getType().getName() != part.getType().getName()) {
    						if(p2.getType().getName() == p.getName()) {
    							present = true;
    						}
    					}
    				}
    				if (!present) {
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }

    
    public boolean isComplete() {
    	
    	return config.size()==configurator.getCategories().size();
    	
    }

    public Set<Part> getSelectedParts(){
    	return Collections.unmodifiableSet(config);
    }

    public void selectPart(PartType chosenPart) {

    	if(!chosenPart.equals(null)) {
    		PartImpl part = chosenPart.newInstance();
    		if(!getSelectionForCategory(chosenPart.getCategory()).isPresent()) {
    			part.setType(chosenPart);

    			config.add(part);
    		}
    		else {
    			throw new IllegalArgumentException("Erreur, le partType voulant être ajouté à la config"
    					+ " ne peut pas etre ajouté car un partType de la même categorie est déjà dans la configuration");
    		}
    	}
    	else {
    		throw new IllegalArgumentException("Erreur, le partType voulant être ajouté à la config ne peut pas etre null");
    	}

    }

    public Optional<Part> getSelectionForCategory(Category category) {//return la piece associee a la category donnee en parametre
    	for(Part piece: config) {
    		if(piece.getCategory().getName().equals(category.getName())) return Optional.of(piece);
    	}
    	return Optional.empty();
    }

    
    public void unselectPartType(Category categoryToClear) {    
        if(categoryToClear != null) {
            ArrayList<Part> arrayPart = new ArrayList<>(config);
            int i=0;
            boolean breakBool = false;
            while(i<arrayPart.size() && breakBool == false) {
                if (arrayPart.get(i).getCategory().equals(categoryToClear)){    
                    arrayPart.remove(i);
                    breakBool=true;
                }
                i++;
            }
            config = new HashSet<>(arrayPart);
        }
        else {
            throw new IllegalArgumentException("Erreur, le partType voulant être enlevé de la config ne peut pas etre null");
        }
    }

    @Override
    public void clear() {
    	config.clear();
    }
    
    
    public String printHtmlConfiguration() {
    	String htmlCode = "";
    	if(isValid() && isComplete()) {
    		htmlCode += "<!DOCTYPE html>\n";
    		htmlCode += "<html>\n";
    		htmlCode += "<head>\n";
    		htmlCode += "<title> Your Configuration </title>\n";
    		htmlCode += "</head>\n";
    		htmlCode += "<body>\n";

    		for (Part p:config) {
    			String category = p.getType().getCategory().getName();
    			String partName = p.getType().getName();
    			String price = p.getProperty("price").get();
    			String description = p.getProperty("description").get();


    				htmlCode += "<h1>" + category + "</h1>\n";
    				htmlCode += "<p>" + partName + "</p>\n";
    				htmlCode += "<p>" + description + "</p>\n";
    				
    				if (p.getType().getCategory().getName()== "Exterior") {
    					String color = p.getProperty("color").get();
    					htmlCode += "<p>" + color + "</p>\n";
    				}
    				
    				htmlCode += "<p>" + price + "€ </p>\n";
    				
    		}
    		htmlCode += "<h2>Total Price: " + getPrice() + "€</h1>\n";
    		
    		htmlCode += "</body>\n";
    		htmlCode += "</html>\n";
    	}
    	return htmlCode;
    }
    
    
    
    
    public double getPrice() {
    	double res = 0.0;
    	if(isValid()) {
    		for(Part p:config) {
    			double price = Double.parseDouble(p.getProperty("price").get());
    			if(price<0.0) {
    				throw new IllegalArgumentException("The price of the Part of the category  "
    												+ p.getCategory().getName() + " is negative");
    			}
    			res += price;
    		}
    	}
    	return res;
    }
    
    public void chooseColor(String s) {
    	for (Part p:config) {
    		if(p.getType().getCategory().getName() == "Exterior") {
    			Set<String> possibleColors = p.getAvailablePropertyValues("color");
    			if(!possibleColors.contains(s)) {
    				throw new IllegalArgumentException("La couleur " + s + " n'existe pas");
    			}
    			p.setProperty("color", s);
    		}
    	}
    }
}
