import model.*;
import model.Character;
import service.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        CharacterService characterService = new CharacterService();
        PokemonService pokemonService = new PokemonService();
        Scanner input = new Scanner(System.in);

        // Load characters
        ArrayList<model.Character> characterList = loadService.loadCharacters();

        // Load Pokemon
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();



        System.out.println("Welcome! Are you ready !!!");

        // 1. Oyuncu

        boolean a = true;
        Player player1 = new Player();

        while (a){
            System.out.print("For Player 1: Enter your name: ");
            String name1 = input.nextLine();
            System.out.println("\nWelcome " + name1 + "\n");


            //Karakter1 seçimi yapıldı.

            System.out.print("Choose your character:\n");
            System.out.println("**************** Characters ****************");
            int indexC1 = 1;
            for (Character character : characterList) {

                System.out.println(indexC1 + character.toString());
                indexC1++;
            }
            int inputChar1 = input.nextInt();

            Character character1 = characterService.chooseCharacter(characterList, inputChar1);

            //Pokemon Seçimi yapıldı.

            System.out.println("Choose your pokemon: ");
            System.out.println("************ Pokemons ***********");
            int indexP1 = 1;
            for (Pokemon pokemon : pokemonList) {
                System.out.println(indexP1 + pokemon.toString());
                indexP1++;
            }
            int inputPoke1 = input.nextInt();
            Pokemon pokemon1 = pokemonService.choosePokemon(pokemonList, inputPoke1);


            System.out.println("\nGreat... You are character is " + character1.getName() + " and you are pokemon is " + pokemon1.getName());
            System.out.println("Choose 1 to continue, 2 to re-enter.");
            int choice1 = input.nextInt();
            input.nextLine();

            switch (choice1){
                case 1:
                    System.out.println("Awesome! The game continues!");
                    characterList.remove(character1);
                    pokemonList.remove(pokemon1);
                    character1.getPokemonList().add(pokemon1);
                    player1 = playerService.createPlayer(name1, character1);
                    a = false;
                    break;

                case 2:
                    System.out.println("Please re-enter your information.");
                    break;

                default:
                    System.out.println("Wrong input, try again.");
                    break;
            }


        }
        //2.Oyuncu

        boolean b = true;
        Player player2 = new Player();
        while (b){
            System.out.println("");
            System.out.print("For Player 2: Enter your name: ");
            String name2 = input.nextLine();
            System.out.println("Welcome " + name2 + "\n");


            //Karakter2 seçimi yapıldı.

            System.out.print("Choose your character:\n");
            System.out.println("**************** Characters ****************");
            int indexC2 = 1;
            for (Character character : characterList) {

                System.out.println(indexC2 + character.toString());
                indexC2++;
            }

            int inputChar2 = input.nextInt();

            Character character2 = characterService.chooseCharacter(characterList, inputChar2);


            //Pokemon2 seçimi yapıldı.
            System.out.println("Choose your pokemon: ");
            System.out.println("*************** Pokemon ************");
            int indexP2 = 1;
            for (Pokemon pokemon : pokemonList) {
                System.out.println(indexP2 + pokemon.toString());
                indexP2++;
            }
            int inputPoke2 = input.nextInt();
            Pokemon pokemon2 = pokemonService.choosePokemon(pokemonList, inputPoke2);


            System.out.println("Great... You are character is " + character2.getName() + " and you are pokemon is " + pokemon2.getName());
            System.out.println("Choose 1 to continue, 2 to re-enter.");
            int choice2 = input.nextInt();
            input.nextLine();

            switch (choice2){
                case 1:

                    characterList.remove(character2);
                    pokemonList.remove(pokemon2);
                    character2.getPokemonList().add(pokemon2);
                    player2 = playerService.createPlayer(name2, character2);
                    b = false;
                    break;

                case 2:
                    System.out.println("Please re-enter your information.");
                    break;

                default:
                    System.out.println("Wrong input, try again.");
                    break;
            }


        }

        System.out.println("\n Let the Pokemon battle begin \n");
        System.out.println("ROUND 1 ");

        //Player currentPlayer = gameService.chooseBegginer(player1, player2);

        Player attacker1 = new Player();
        Player defender1 = new Player();

        if (gameService.isBegginer(player1)){
            attacker1 = player1;
            defender1 = player2;
        }else {
            attacker1 = player2;
            defender1 = player1;
        }

        Player winner1 = new Player();
        Player loser1 = new Player();

        boolean c = true;
        while (c){
            System.out.println("\n" + attacker1.getName() + " is turn.\n");
            System.out.println("Do you want to use the special power of your character?");
            System.out.println("1- YES 2- NO");
            int charPower = input.nextInt();
            boolean useCharPower = false;
            if (charPower == 1){
                useCharPower = true;
            }

            System.out.println("Do you want to use to special power of your pokemon");
            System.out.println("1: YES 2: NO");

            int pokePower = input.nextInt();
            boolean usePokePower = false;
            if (pokePower == 1){
                usePokePower = true;

            }
            gameService.attack(attacker1,defender1,usePokePower,useCharPower);

            if (!gameService.healthCheck(defender1)){
                System.out.println(defender1.getName() + " has been defeated " + attacker1.getName() + " has won the first round");
                winner1 = attacker1;
                loser1 = defender1;
                c = false;
                break;
            }

            System.out.println(attacker1.getName() + " has made their move. The game continues ! ");

            Player[] players = {attacker1, defender1};
            gameService.switchRoles(players);
            attacker1 = players[0];
            defender1  =players[1];

        }

        System.out.println("ROUND 2");

        loser1.getCharacter().getPokemonList().get(0).setHealth(100);
        winner1.getCharacter().getPokemonList().add(loser1.getCharacter().getPokemonList().get(0));
        loser1.getCharacter().getPokemonList().remove(0);
        Pokemon weakestPokemon = gameService.chooseWeakestPokemon(pokemonList);
        loser1.getCharacter().getPokemonList().add(weakestPokemon);

        Player attacker2 = new Player();
        Player defender2 = new Player();

        if (gameService.isBegginer(winner1)){
            attacker2 = winner1;
            defender2 = loser1;
        }else {
            attacker2 = loser1;
            defender2 = winner1;
        }

        Player winner2 = new Player();
        Player loser2 = new Player();

        boolean d = true;
        while (d){
            System.out.println("\n" + attacker2.getName() +  " is turn.\n");
            System.out.println("Do you want to use the special power of your character?");
            System.out.println("1- YES 2- NO");
            int charPower = input.nextInt();
            boolean useCharPower = false;
            if (charPower == 1){
                useCharPower = true;
            }

            System.out.println("Do you want to use to special power of your pokemon");
            System.out.println("1: YES 2: NO");

            int pokePower = input.nextInt();
            boolean usePokePower = false;
            if (pokePower == 1){
                usePokePower = true;

            }
            gameService.attack(attacker2,defender2,usePokePower,useCharPower);

            if (!gameService.healthCheck(defender2)){
                if (defender2==winner1){
                    defender2.getCharacter().getPokemonList().remove(0);
                    if (defender2.getCharacter().getPokemonList().isEmpty()){
                        System.out.println(defender2.getName() + " has been defeated. " + attacker2.getName() + " has won the first round !!");
                        winner2 = attacker2;
                        loser2 = defender2;
                        d = false;
                        break;
                    }

                }else {
                    System.out.println(defender2.getName() + " has been defeated " + attacker2.getName() + " has won the second round");
                    winner2 = attacker2;
                    loser2 = defender2;
                    c = false;
                    break;

                }

            }

            System.out.println(attacker2.getName() + " has made their move. The game continues ! ");

            Player[] players = {attacker2, defender2};
            gameService.switchRoles(players);
            attacker2 = players[0];
            defender2  =players[1];

        }

        System.out.println("\n THE END");
        if (winner1 == winner2){
            System.out.println(winner1.getName() + "has become the new Pokemon master !!");
        }else {
            System.out.println("It is tie ' No one became the Pokemon master. ");
        }

        



    }
}

