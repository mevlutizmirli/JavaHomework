package service;

import model.Ash;
import model.Character;
import model.SpecialPower;

import java.util.ArrayList;

public class CharacterService {

    public Character chooseCharacter(ArrayList<Character> characterList, int id){
        Character character = new Character();
      if (id <= characterList.size()){
          character=characterList.get(id-1);

        }else{
          System.out.println("Wrong input");
      }
      return character;

    }

}
