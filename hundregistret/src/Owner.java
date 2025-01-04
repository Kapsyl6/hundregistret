// Frej Guste kagu7440


public class Owner {

    private final String name;

    public Owner(String name){

        this.name = name.toUpperCase();   
    }

    public String getName(){

        return this.name;
    }

    public String toString(){

        return "Owner{name='" + name + "'}";
    }
    

}
