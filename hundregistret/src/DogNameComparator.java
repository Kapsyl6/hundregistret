// Frej Guste kagu7440 

import java.util.Comparator;

/** Jämförelsen matar ut en integer
 *      Ex)
 *     -1 => Första kommer tidigare i alfabetet
 *      0 => De har samma  lexikaliska plats
 *      1 => Andra kommer tidigare i alfabetet
 *   
 *  Multiplicera med 1000 för att avrunda till från double till int utan att förlora precision i jämförelsen. 
 * */ 

public class DogNameComparator implements Comparator <Dog> {

    public int compare(Dog firstDog, Dog secondDog){
        return firstDog.getName().compareTo(secondDog.getName());
    }
    

}
