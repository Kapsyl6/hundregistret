// Frej Guste kagu7440 

import java.util.Comparator;

public class DogTailNameComparator implements Comparator <Dog> {

    private final int multiplicator = 1000;
    public int compare(Dog firstDog, Dog secondDog) {
       
        int comparedDog = (int)(firstDog.getTailLength() * multiplicator - secondDog.getTailLength() * multiplicator);

        if (comparedDog == 0) {
            comparedDog = firstDog.getName().compareTo(secondDog.getName());
        }
        
        return comparedDog;
    }


    
} 