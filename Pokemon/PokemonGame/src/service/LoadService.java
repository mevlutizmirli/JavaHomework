package service;

import model.*;
import model.Character;

import java.util.ArrayList;

public class LoadService {
    public ArrayList<Character> loadCharacters(){
        SpecialPower strategy1 = new Strategy("Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);

        Character ash = new Ash(1,"Ash", strategy1);
        Character brooke = new Brooke(2,"Brooke", strategy2);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricty = new Electricty("Electricty", 3, 3);
        SpecialPower water = new Water("Water", 1, 3);
        SpecialPower fire = new Fire("Fire", 5, 3);
        SpecialPower earth = new Earth("Earth", 4, 3);

        Pokemon pokemon1 = new Pikachu(1,"Pikachu", 100, 50, TypeEnum.ELECTRICY, electricty);
        Pokemon pokemon2 = new Sqiurtle(2,"Squirtle", 120, 40, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander(3,"Charmender", 90, 50, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar(4,"Balbausar", 140, 40, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }

    public ArrayList<Weather> loadWeather(){
        Weather snow = new Weather("Snowy",2);
        Weather harshSun = new Weather("Harsh Sunny",3);
        Weather storm  = new Weather("Stormy",2);
        Weather rain = new Weather("Rainy",3);

        ArrayList<Weather> weatherList = new ArrayList<>();
        weatherList.add(snow);
        weatherList.add(harshSun);
        weatherList.add(storm);
        weatherList.add(rain);

        return weatherList;
    }

}
