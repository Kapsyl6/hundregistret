import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    private static String USER_INPUT_TAG = " ?> ";
    private static ArrayList<InputStream> INPUT_STREAMS_IN_USE = new ArrayList<InputStream>();

    private Scanner input;
    private InputStream inputStream;

    public InputReader() {
        this(System.in);
    }

    public InputReader(InputStream source) {
        if (INPUT_STREAMS_IN_USE.contains(source)) {
            throw new IllegalStateException("Cannot create more than one instance for the same InputStream");
        }
        INPUT_STREAMS_IN_USE.add(source);
        inputStream = source;
        input = new Scanner(source);
    }

    public int readInteger(String prompt) {
        System.out.print(prompt + USER_INPUT_TAG);
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    public double readDouble(String prompt) {
        System.out.print(prompt + USER_INPUT_TAG);
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }

    public String readString(String prompt) {
        System.out.print(prompt + USER_INPUT_TAG);
        String userInput = input.nextLine();
        return userInput;
    }

    public void close() {
        INPUT_STREAMS_IN_USE.remove(inputStream);
        input.close();
    }
}
