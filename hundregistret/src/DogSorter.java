// Frej Guste kagu7440

import java.util.ArrayList;

public class DogSorter {
    

    private static void swapDogs(ArrayList <Dog> dogList, int firstIndex, int secondIndex ){

        Dog firstDog = dogList.get(firstIndex);

        Dog secondDog = dogList.get(secondIndex);

        dogList.set(firstIndex, secondDog);

        dogList.set(secondIndex, firstDog);

    }
}
