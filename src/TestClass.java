import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
    public static void main(String[] args) {
        Dog dog;
        String name = "Molle";
        String breed = "Golden Retriever";
        int age = 17;
        int weight = 25;

        dog = new Dog(name, breed, age, weight);

        System.out.println(dog);

        System.out.println("Taillength should be: " + (dog.getAge() * (dog.getWeight() / 10.0)));

         testDogTailComparator();


    }

    public static void testDogTailComparator(){

        DogTailComparator sut = new DogTailComparator();



    }
}
