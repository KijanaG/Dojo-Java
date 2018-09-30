package oop.advanced.pokemon;
import java.util.ArrayList;
public interface PokemonInterface {
	Pokemon createPokemon(String name, int health, String type);
	String pokemonInfo(Pokemon pokemon);
	ArrayList<String> listPokemon();
}
