// Frej Guste kagu7440 

import java.util.Scanner;

public class DogRegister {

    private static final int COMMAND_ONE = 1;
    private static final int COMMAND_TWO = 2; 
    private static final int EXIT_COMMAND = 0; 

    private Scanner input;
    
    public DogRegister() {
        input = new Scanner(System.in);
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
        String commandStr = input.nextLine().trim();
        
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
            case COMMAND_ONE:
                commandOneMethod();
                break;
            case COMMAND_TWO:
                commandTwoMethod();
                break;
            case EXIT_COMMAND:
                break;
            case -1:
                break;
            default:
                System.out.println("Error: illegal command!");
        }
    }

    private void commandOneMethod() {
        System.out.println("Command one executing");
    }

    private void commandTwoMethod() {
        System.out.println("Command two executing");
    }

    private void shutDown() {
        System.out.println("Shutting down");
    }

    public static void main(String[] args) {
        new DogRegister().start();
    }
}