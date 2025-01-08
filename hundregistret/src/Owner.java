// Frej Guste kagu7440


public class Owner implements Comparable <Owner>{

    private final String name;

    public Owner(String name){

        this.name = name.toUpperCase();   
    }

    public String getName(){

        return this.name;
    }

    public int compareTo(Owner comparedOwner){

        return getName().compareTo(comparedOwner.getName());
    }

    public String toString(){

        return "Owner{name='" + name + "'}";
    }
    

}
