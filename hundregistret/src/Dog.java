// Frej Guste kagu7440

public class Dog {

    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength;

    public Dog(String name, String breed, int age, int weight){

        this.name = name.toUpperCase();

        this.breed = breed.substring(0, 1).toUpperCase() + breed.substring(1).toLowerCase();

        this.age = age;

        this.weight = weight;
        
        if ("DACHSHUND".equalsIgnoreCase(breed)) {
            this.tailLength = 3.7;
        } else {
            this.tailLength = Math.round(age * (weight / 10.0) * 10.0) / 10.0;
        }
        
    }

    public String getName(){

        return this.name;
    } 

    public String getBreed(){

        return this.breed;
    }
    
    public int getAge(){

        return this.age;
    }

    public void increaseAge(){
        this.age++;
    }

    public void decreaseAge(){
        if (this.age > 0){
            this.age--;
        }
    }

    public int getWeight(){

        return this.weight;
    }

    public double getTailLength(){

        return this.tailLength;
    }

    public String toString(){

        return "Dog{name='" + name + "', breed='" + breed + "', age=" + age + ", weight=" + weight + ", tailLength=" + tailLength + "}";
    }

}
