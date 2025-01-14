// Frej Guste kagu7440
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class DogCollection {
    private ArrayList<Dog> dogs = new ArrayList<>();

    
    public DogCollection() {
    }

    public boolean addDog(Dog dog) {
        if (dog == null) return false;
        for (Dog d : dogs) {
            if (d.getName().equalsIgnoreCase(dog.getName())) {
                return false;
            }
        }
        dogs.add(dog);
        return true;
    }

    public boolean removeDog(Dog dog) {


        if(dog.getOwner() != null){
            return false;
        } 
        return dogs.remove(dog);
    }

    public boolean removeDog(String name) {

        if(getDog(name).isPresent() && getDog(name).get().getOwner() != null){
            return false;
        } 
        return dogs.removeIf(dog -> dog.getName().equalsIgnoreCase(name));
    }

    public boolean containsDog(Dog insertDog) {
        if (insertDog == null) return false;
        for (Dog i : dogs) {
            if (insertDog.getName().equalsIgnoreCase(i.getName())) {
                System.out.println(insertDog + " exists within the system.");
                return true;
            }
        }
        System.out.println("This dog does not exist.");
        return false;
    }

    public boolean containsDog(String insertDog) {
        if (insertDog == null) return false;
        for (Dog i : dogs) {
            if (insertDog.equalsIgnoreCase(i.getName())) {
                System.out.println(insertDog + " exists within the system.");
                return true;
            }
        }
        System.out.println("This dog does not exist.");
        return false;
    }

    public Optional<Dog> getDog(String name) {
        if (name == null) return Optional.empty();
        return dogs.stream()
                  .filter(dog -> dog.getName().equalsIgnoreCase(name))
                  .findFirst();
    }

    public ArrayList<Dog> getDogs() {
        ArrayList<Dog> returnList = new ArrayList<>(dogs);
        DogSorter.sortDogs(new DogNameComparator(), returnList);
        return returnList;
    }

    public ArrayList<Dog> getFilteredDogsByTailLength(double minimumTailLength) {
        ArrayList<Dog> filteredDogs = new ArrayList<>();
        for (Dog dog : dogs) {
            if (dog.getTailLength() >= minimumTailLength) {
                filteredDogs.add(dog);
            }
        }
    
        DogSorter.sortDogs(
            (firstDog, secondDog) -> {
                int result = Double.compare(firstDog.getTailLength(), secondDog.getTailLength());
                if (result == 0) { 
                    result = firstDog.getName().compareToIgnoreCase(secondDog.getName());
                }
                return result;
            }, 
            filteredDogs
        );
        return filteredDogs;
    }
    

   // Behövs dessa?
    public boolean isEmpty() {
        return dogs.isEmpty();
    }

    public int size() {
        return dogs.size();
    }

    public Iterator<Dog> iterator() {
        return dogs.iterator();
    }
}