import java.util.Scanner;
import java.util.ArrayList;

public class DogRegister {
    private static final int COMMAND_REGISTER_NEW_OWNER = 1;
    private static final int COMMAND_REMOVE_OWNER = 2; 
    private static final int COMMAND_REGISTER_NEW_DOG = 3;
    private static final int COMMAND_REMOVE_DOG = 4;
    private static final int COMMAND_LIST_DOGS = 5;
    private static final int COMMAND_LIST_OWNERS = 6;
    private static final int COMMAND_INCREASE_AGE = 7;
    private static final int COMMAND_GIVE_DOG_TO_OWNER = 8;
    private static final int COMMAND_REMOVE_DOG_FROM_OWNER = 9;
    private static final int EXIT_COMMAND = 0; 

    private InputReader input;
    private ArrayList<Owner> owners;
    private ArrayList<Dog> dogs;
    
    public DogRegister() {
        input = new InputReader(System.in);
        owners = new ArrayList<>();
        dogs = new ArrayList<>();
    }
    
    private void start() {
        initialize();
        runCommandLoop();
        shutDown();
    }

    private void initialize() {
        System.out.println("Initializing program");
        System.out.print("?> ");
    }

    private void runCommandLoop() {
        int command;
        do {
            command = readCommand();
            handleCommand(command);
            if (command != EXIT_COMMAND) {
                System.out.print("?> ");
            }
        } while (command != EXIT_COMMAND);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private int readCommand() {
        String commandStr = input.readString("Enter command:").trim();
        
        if (commandStr.equalsIgnoreCase("exit")) {
            return EXIT_COMMAND;
        }
        
        if (isNumeric(commandStr)) {
            return Integer.parseInt(commandStr);
        }
        
        System.out.println("Error: illegal command!");
        return -1;
    }

    private void handleCommand(int command) {
        switch(command) {
            case COMMAND_REGISTER_NEW_OWNER:
                registerNewOwner();
                break;
            case COMMAND_REMOVE_OWNER:
                removeOwner();
                break;
            case COMMAND_REGISTER_NEW_DOG:
                registerNewDog();
                break;
            case COMMAND_REMOVE_DOG:
                removeDog();
                break;
            case COMMAND_LIST_DOGS:
                listDogs();
                break;
            case COMMAND_LIST_OWNERS:
                listOwners();
                break;
            case COMMAND_INCREASE_AGE:
                increaseAge();
                break;
            case COMMAND_GIVE_DOG_TO_OWNER:
                giveDogToOwner();
                break;
            case COMMAND_REMOVE_DOG_FROM_OWNER:
                removeDogFromOwner();
                break;
            case EXIT_COMMAND:
                break;
            case -1:
                break;
            default:
                System.out.println("Error: illegal command!");
        }
    }

    private void registerNewOwner() {
        String name;
        do {
            name = input.readString("Enter owner's name:").trim();
            if (name.isEmpty()) {
                System.out.println("Error: A blank string is not allowed, try again.");
            } else if (isOwnerExists(name)) {
                System.out.println("Error: Owner " + name + " already exists in the register.");
                name = ""; // Tvinga om frågan om ett nytt namn
            }
        } while (name.isEmpty());
        owners.add(new Owner(name));
        System.out.println("The owner " + name + " has been added to the register.");
    }
    
    private boolean isOwnerExists(String name) {
        for (Owner owner : owners) {
            if (owner.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    

    private void removeOwner() {
        String name = input.readString("Enter owner's name:").trim();
        // Implementera logik för att ta bort ägare
    }

    private void registerNewDog() {
        String name = input.readString("Enter dog's name:");
        String breed = input.readString("Enter dog's breed:");
        int age = input.readInteger("Enter dog's age:");
        int weight = input.readInteger("Enter dog's weight:");
        double tailLength = input.readDouble("Enter dog's tail length:");
        dogs.add(new Dog(name, breed, age, weight, tailLength));
        System.out.println("Dog " + name + " registered.");
    }

    private void removeDog() {
        String name = input.readString("Enter dog's name:");
        // Implementera logik för att ta bort hund
    }

    private void listDogs() {
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    private void listOwners() {
        for (Owner owner : owners) {
            System.out.println(owner);
        }
    }

    private void increaseAge() {
        System.out.println("Enter dog's name:");
        String name = input.readString().trim();
        // Implementera logik för att öka en hunds ålder
    }

    private void giveDogToOwner() {
        System.out.println("Enter dog's name:");
        String dogName = input.readString().trim();
        System.out.println("Enter owner's name:");
        String ownerName = input.readString().trim();
        // Implementera logik för att ge en hund till en ägare
    }

    private void removeDogFromOwner() {
        System.out.println("Enter dog's name:");
        String dogName = input.readString().trim();
        System.out.println("Enter owner's name:");
        String ownerName = input.readString().trim();
        // Implementera logik för att ta bort en hund från en ägare
    }

    private void shutDown() {
        System.out.println("Shutting down");
    }

    public static void main(String[] args) {
        new DogRegister().start();
    }
}

class Owner {
    private String name;

    public Owner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{name='" + name + "'}";
    }
}

class Dog {
    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength;

    public Dog(String name, String breed, int age, int weight, double tailLength) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return String.format("%s är en %s som är %d år gammal och väger %d kilo med en svanslängd på %.1f valfria enheter",
                name, breed, age, weight, tailLength);
    }
}
