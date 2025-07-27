// Frej Guste kagu7440 

import java.util.Comparator;

/** Jämförelsen matar ut en integer
 *      Ex)
 *     -1 => första  är större än andra
 *      0 => de har samma värde
 *      1 => andra är större än första
 *   
 *  Multiplicera med 1000 för att avrunda till från double till int utan att förlora precision i jämförelsen. 
 * */ 

public class DogTailComparator implements Comparator <Dog> {

        private final int multiplicator = 1000;
        public int compare(Dog firstDog, Dog secondDog) {
            return (int)(firstDog.getTailLength() * multiplicator - secondDog.getTailLength() * multiplicator) ;
        }
    
}
