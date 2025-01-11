// Frej Guste kagu7440

import java.util.ArrayList;
import java.util.Optional;

public class DogCollection {
    
    private ArrayList<Dog> dogList = new ArrayList<>();

        //Lägger till en hund till samlingen
    public boolean addDog(Dog d){ 
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(d.getName())){
                return false;
            }
        }
        dogList.add(d);
        return true;
    }
        // Tar bort en hund från samlingen om denna existerar
    public boolean removeDog(Dog d){ 
        if (dogList.contains(d)){
            dogList.remove(d);
            return true;
        }
        return false;
    }
    
        // Returnerar om samlingen innehåller den givna hunden eller inte
    public boolean containsDog(Dog insertDog){ 
        for (Dog i : dogList){
            if (insertDog.getName().equals(i.getName())){
                System.out.println(insertDog + " exists within the system.");
                return true;
            }
        }
        System.out.println("This dog does not exist.");
        return false;
    }
    public boolean containsDog(String insertDog){
        for (Dog i : dogList){
            if (insertDog.equalsIgnoreCase(i.getName())){
                System.out.println(insertDog + " exists within the system.");
                return true;
            }
        }
        System.out.println( "This dog does not exist.");
        return false;
    }

        // Returnerar hunden med det givna namnet, annars null
    public Optional<Dog> getDog(String name){
        for (Dog dog : dogList){
            if (dog.getName().equals(name)){
                return Optional.of(dog);
            }
        }
        return Optional.empty();
    }

        // Returnerar samtliga hundar
    public ArrayList<Dog> getDogs(){
        ArrayList<Dog> returnList = new ArrayList<Dog>(dogList);
        DogSorter.sortDogs(new DogNameComparator(), returnList);
        return returnList;
    }

    public ArrayList<Dog> getDogsWithTail(int minimumTailLength, ArrayList<Dog> dogList){

        ArrayList<Dog> filteredDogs = new ArrayList<>();
        for (Dog dog : dogList) {
            if (dog.getTailLength() >= minimumTailLength) {
                filteredDogs.add(dog);
            }
        }
        DogSorter.sortDogs((firstDog, secondDog) -> Double.compare(firstDog.getTailLength() ,secondDog.getTailLength()), filteredDogs);
        return filteredDogs;
    }
        


}   
