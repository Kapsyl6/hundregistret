/// Frej Guste kagu7440

import java.util.ArrayList;

public class Owner implements Comparable<Owner> {
    private String name;
    private final ArrayList<Dog> listedDogs;

    public Owner(String name) {
        this.listedDogs = new ArrayList<Dog>();
        this.name = name.toUpperCase();   
    }

    public String getName() {
        return this.name;
    }

    public int compareTo(Owner comparedOwner) {
        return getName().compareTo(comparedOwner.getName());
    }

    public boolean addDog(Dog dog) {
        
        if (dog == null){
            return false;
        }

        if (dog.getOwner() != null && dog.getOwner() != this) {
            return false;
        } else if (!listedDogs.contains(dog)){
            listedDogs.add(dog);
            if (dog.getOwner() == null){
                dog.setOwner(this);
            }
            return true;
        }
        return false;
    }

    public boolean removeDog(Dog dog) {
        // Äger ägaren den här dog
        if (dog == null) return false;

        if (listedDogs.contains(dog)){
            listedDogs.remove(dog);
            if (dog.getOwner() != null && dog.getOwner() == this){
                dog.setOwner(null);
            }
            return true;
        }

        return false;
    }

    public ArrayList<Dog> getDogs() {
        ArrayList<Dog> dogsCopy = new ArrayList<>(listedDogs);
        dogsCopy.sort((d1, d2) -> d1.getName().compareTo(d2.getName()));
        return dogsCopy;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Owner{name='" + name + "'");
        if (!listedDogs.isEmpty()) {
            result.append(", listedDogs=");
            result.append(listedDogs.stream()
                    .map(Dog::getName)
                    .sorted()
                    .toList());
        }
        result.append("}");
        return result.toString();
    }
}