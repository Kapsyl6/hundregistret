// Frej Guste kagu7440
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Optional;

public class OwnerCollection {

    private Owner[] owners;
    private int size;

    public OwnerCollection(){
        owners = new Owner[10];
    }

    public boolean addOwner(Owner owner){
        if (owner == null) return false;
        for (int i = 0; i < size; i++) {
            if (owners[i].getName().equalsIgnoreCase(owner.getName())) {
                return false;
            }
        }
        if (size == owners.length){
            owners = Arrays.copyOf(owners, size * 2); 
        }
        owners[size] = owner;
        size++;
        return true;
    }

    public boolean removeOwner(String name){
        if (name == null || name.isEmpty()) return false; 

        if (!(getOwner(name).isPresent() && getOwner(name).get().getDogs().isEmpty()))
         return false;
        
        int index = -1; 
        for (int i = 0; i < size; i++) { 
            if (owners[i].getName().equalsIgnoreCase(name)) { 
                index = i; 
                break; 
            } 
        } 
        
        if (index == -1) return false; 
        for (int i = index; i < size - 1; i++) { 
            owners[i] = owners[i + 1]; 
        } 
        owners[size - 1] = null; 
        size--;
        return true;
    }

    public boolean removeOwner(Owner owner) {
        if (owner == null) return false;
    
        if (!owner.getDogs().isEmpty()) return false;

        int index = -1;
        for (int i = 0; i < size; i++) {
            if (owners[i].equals(owner)) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
    
        for (int i = index; i < size - 1; i++) {
            owners[i] = owners[i + 1];
        }
        owners[size - 1] = null;
        size--;
        return true;
    }
    

    public boolean containsOwner(String name){
        if (name == null) return false;
        for (int i = 0; i < size; i++) {
            if (name.equalsIgnoreCase(owners[i].getName())) {
                System.out.println(name + " exists within the system.");
                return true;
            }
        }
        System.out.println("This owner does not exist.");
        return false;
    }

    public boolean containsOwner(Owner owner){
        if (owner == null) return false;
        for (int i = 0; i < size; i++) {
            if (owner.getName().equalsIgnoreCase(owners[i].getName())) {
                System.out.println(owner + " exists within the system.");
                return true;
            }
        }
        System.out.println("This owner does not exist.");
        return false;
    }

    public Optional<Owner> getOwner(String name){
        if (name == null) return Optional.empty();
        for (int i = 0; i < size; i++){
            if (name.equalsIgnoreCase(owners[i].getName())){
                return Optional.of(owners[i]);
            }
        }

        return Optional.empty();
    }

    public ArrayList<Owner> getOwners(){
        ArrayList<Owner> ownerList = new ArrayList<>(Arrays.asList(Arrays.copyOf(owners, size)));
        ownerList.sort(Comparator.comparing(Owner::getName,String.CASE_INSENSITIVE_ORDER));
        return ownerList;
    }
}
