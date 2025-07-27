import java.util.ArrayList;

public class DogRegister {
    private InputReader input;
    private ArrayList<Owner> owners;
    private ArrayList<Dog> dogs;

    public DogRegister() {
        input = new InputReader();
        owners = new ArrayList<>();
        dogs = new ArrayList<>();
    }

    private void start() {
        runCommandLoop();
    }

    private void runCommandLoop() {
        String command;
        do {
            System.out.print("?> ");
            command = readCommand();
            handleCommand(command);
        } while (!command.equalsIgnoreCase("EXIT"));
    }

    private String readCommand() {
        return input.readString("").trim();
    }

    private void handleCommand(String command) {
        command = command.toUpperCase();

        if (command.equals("REGISTER NEW OWNER")) {
            registerNewOwner();
        } else if (command.equals("REMOVE OWNER")) {
            removeOwner();
        } else if (command.equals("REGISTER NEW DOG")) {
            registerNewDog();
        } else if (command.equals("REMOVE DOG")) {
            removeDog();
        } else if (command.equals("LIST DOGS")) {
            listDogs();
        } else if (command.equals("LIST OWNERS")) {
            listOwners();
        } else if (command.equals("INCREASE AGE")) {
            increaseAge();
        } else if (command.equals("GIVE DOG TO OWNER")) {
            giveDogToOwner();
        } else if (command.equals("REMOVE DOG FROM OWNER")) {
            removeDogFromOwner();
        } else if (command.equals("EXIT")) {
            // Do nothing, loop will exit
        } else {
            System.out.println("Error: Unknown command");
        }
    }

    private void registerNewOwner() {
        String name;
        do {
            name = input.readString("Name:").trim();
            if (name.isEmpty()) {
                System.out.println("Error: the name cannot be empty");
            } else if (isOwnerExists(name)) {
                System.out.println("Error: owner " + name + " already exists");
                name = "";
            }
        } while (name.isEmpty());

        owners.add(new Owner(name));
        System.out.println(name + " added to the register");
    }

    private boolean isOwnerExists(String name) {
        return owners.stream().anyMatch(owner ->
                owner.getName().equalsIgnoreCase(name));
    }

    private void removeOwner() {
        if (owners.isEmpty()) {
            System.out.println("Error: no owners to remove");
            return;
        }

        String name = input.readString("Which owner:").trim();
        Owner ownerToRemove = findOwner(name);

        if (ownerToRemove == null) {
            System.out.println("Error: no such owner");
        } else {
            // Remove dogs owned by this owner
            ArrayList<Dog> ownedDogs = new ArrayList<>(ownerToRemove.getDogs());
            for (Dog dog : ownedDogs) {
                dogs.remove(dog);
            }
            owners.remove(ownerToRemove);
            System.out.println(name + " is removed");
        }
    }

    private void registerNewDog() {
        String name;
        do {
            name = input.readString("Name:").trim();
            if (name.isEmpty()) {
                System.out.println("Error: the name cannot be empty");
            } else if (isDogExists(name)) {
                System.out.println("Error: dog " + name + " already exists");
                name = "";
            }
        } while (name.isEmpty());

        String breed;
        do {
            breed = input.readString("Breed:").trim();
            if (breed.isEmpty()) {
                System.out.println("Error: the breed cannot be empty");
            }
        } while (breed.isEmpty());

        int age = input.readInteger("Age:");
        int weight = input.readInteger("Weight:");

        dogs.add(new Dog(name, breed, age, weight));
        System.out.println(name + " added to the register");
    }

    private boolean isDogExists(String name) {
        return dogs.stream().anyMatch(dog ->
                dog.getName().equalsIgnoreCase(name));
    }

    private void removeDog() {
        if (dogs.isEmpty()) {
            System.out.println("Error: no dogs to remove");
            return;
        }

        String name = input.readString("Which dog:").trim();
        Dog dogToRemove = findDog(name);

        if (dogToRemove == null) {
            System.out.println("Error: no such dog");
        } else {
            // Remove from owner if owned
            Owner owner = dogToRemove.getOwner();
            if (owner != null) {
                owner.removeDog(dogToRemove);
            }
            dogs.remove(dogToRemove);
            System.out.println(name + " is removed");
        }
    }

    private void listDogs() {
        if (dogs.isEmpty()) {
            System.out.println("Error: no dogs in register");
            return;
        }

        double minTailLength = 0;
        String tailInput = input.readString("Smallest tail length to display:").trim();
        if (!tailInput.isEmpty()) {
            minTailLength = Double.parseDouble(tailInput);
        }

        for (Dog dog : dogs) {
            if (dog.getTailLength() >= minTailLength) {
                System.out.println(dog);
            }
        }
    }

    private void listOwners() {
        if (owners.isEmpty()) {
            System.out.println("Error: no owners in register");
            return;
        }

        for (Owner owner : owners) {
            System.out.println(owner);
        }
    }

    private void increaseAge() {
        if (dogs.isEmpty()) {
            System.out.println("Error: no dogs in register");
            return;
        }

        String name = input.readString("Enter the name of the dog:").trim();
        Dog dog = findDog(name);

        if (dog == null) {
            System.out.println("Error: no dog with that name");
        } else {
            dog.increaseAge();
            System.out.println(name + " is now one year older");
        }
    }

    private void giveDogToOwner() {
        if (dogs.isEmpty()) {
            System.out.println("Error: no dogs in register");
            return;
        }
        if (owners.isEmpty()) {
            System.out.println("Error: no owners in register");
            return;
        }

        String dogName = input.readString("Enter the name of the dog:").trim();
        Dog dog = findDog(dogName);

        if (dog == null) {
            System.out.println("Error: no dog with that name");
            return;
        }

        if (dog.getOwner() != null) {
            System.out.println("Error: dog already owned by " + dog.getOwner().getName());
            return;
        }

        String ownerName = input.readString("Enter the name of the new owner:").trim();
        Owner owner = findOwner(ownerName);

        if (owner == null) {
            System.out.println("Error: no owner with that name");
        } else {
            dog.setOwner(owner);
            System.out.println(dogName + " now belongs to " + ownerName);
        }
    }

    private void removeDogFromOwner() {
        if (dogs.isEmpty()) {
            System.out.println("Error: no dogs in register");
            return;
        }

        String dogName = input.readString("Enter the name of the dog:").trim();
        Dog dog = findDog(dogName);

        if (dog == null) {
            System.out.println("Error: no dog with that name");
        } else if (dog.getOwner() == null) {
            System.out.println("Error: " + dogName + " owned by no one");
        } else {
            String ownerName = dog.getOwner().getName();
            dog.setOwner(null);
            System.out.println(dogName + " is now ownerless");
        }
    }

    private Dog findDog(String name) {
        return dogs.stream()
                .filter(dog -> dog.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private Owner findOwner(String name) {
        return owners.stream()
                .filter(owner -> owner.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        new DogRegister().start();
    }
}