package oop.advanced.pokemon;

import java.util.ArrayList;

public abstract class AbstractPokemon implements PokemonInterface{
		String name;
		String type;
		int health;
		protected ArrayList<String> listOfNames = new ArrayList<String>();
	public void createPokemon(String name, String type, int health) {
		this.name = name;
		this.health = health;
		this.type = type;
		listOfNames.add(this.name);
	}
	public String pokemonInfo(AbstractPokemon pokemon) {
		return "Name: "+name+"Health: "+health+" Type: "+type;
	}
	
}
