// Frej Guste kagu7440
import java.util.ArrayList;
import java.util.Comparator;


public class DogSorter {
    
    private static void swapDogs(ArrayList<Dog> dogList, int firstIndex, int secondIndex) {
        Dog firstDog = dogList.get(firstIndex);
        Dog secondDog = dogList.get(secondIndex);

        dogList.set(firstIndex, secondDog);
        dogList.set(secondIndex, firstDog);
    }

    /**  
     *  1. Listan av hundar som ska sökas igenom
     *  2. Varifrån metoden ska börja söka   
     */
    private static int nextDog(Comparator<Dog> comparator, ArrayList<Dog> dogList, int startIndex) {
        int bestIndex = startIndex;
        for (int i = startIndex + 1; i < dogList.size(); i++) {
            if (comparator.compare(dogList.get(i), dogList.get(bestIndex)) < 0) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    public static int sortDogs(Comparator<Dog> comparator, ArrayList<Dog> dogList) {
        int swapCount = 0;

        for (int i = 0; i < dogList.size() - 1; i++){
            int minIndex = nextDog(comparator, dogList, i);
            if (minIndex != i){
                swapDogs(dogList, i, minIndex);
                swapCount++;
            }
        }
                return swapCount;
    

    }

}
