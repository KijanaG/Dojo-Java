package oop.advanced.pokemon;
import java.util.ArrayList;
public class Pokemon {
	private String name;
	private int health;
	private String type;
	private ArrayList<String> listOfNames = new ArrayList<String>();
	public Pokemon(String name, int health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
		listOfNames.add(this.name);
	}
	public ArrayList<String> listPokemon() {
		return listOfNames;
	}
	void attackPokemon(Pokemon pokemon) {
		pokemon.health -= 10;
	}
	public String getName() {
		return this.name;
	}
	public int getHealth() {
		return this.health;
	}
	public String getType() {
		return this.type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
}
