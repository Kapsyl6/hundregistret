// Frej Guste kagu7440

public class Dog {

    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength;
    private final double dachshundTailLength = 3.7;

    public Dog(String name, String breed, int age, int weight){
        this.name = name.toUpperCase();
        this.breed = breed.substring(0, 1).toUpperCase() + breed.substring(1).toLowerCase();
        this.age = age;
        this.weight = weight;

        // Set tail length for dachshunds or other breeds
        if ("DACHSHUND".equalsIgnoreCase(breed) || "TAX".equalsIgnoreCase(breed)) {
            this.tailLength = dachshundTailLength;
        } else {
            this.tailLength = calculateTailLength();
        }
    }

    // Calculate the tail length based on age and weight
    private double calculateTailLength() {
        return Math.round(age * (weight / 10.0) * 10.0) / 10.0;
    }

    // Getter methods
    public String getName(){
        return this.name;
    }

    public String getBreed(){
        return this.breed;
    }

    public int getAge(){
        return this.age;
    }

    public int getWeight(){
        return this.weight;
    }

    public double getTailLength(){
        return this.tailLength;
    }


    public void increaseAge(){
        if (age < Integer.MAX_VALUE) {
            this.age++;
            // Only update tail length for non-dachshunds
            if (!"DACHSHUND".equalsIgnoreCase(breed) && !"TAX".equalsIgnoreCase(breed)) {
                this.tailLength = calculateTailLength();
            }
        }
    }

    public String toString(){
        return 
        "Dog{name='" + name + 
        "', breed='" + breed + 
        "', age=" + age + 
        ", weight=" + weight + 
        ", tailLength=" + tailLength + 
        "}";
    }
}
