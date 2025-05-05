


public class Dog extends Animal{

    private String name;
    private String breed;

    public Dog() {
        this.name = "Spike";
        this.breed = "vira-lata";
    }

    public Dog(String name, String breed) throws Exception{
        this.name = name;
        this.breed = breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    };

    private String getBreed() {
        return this.breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setBreed("salsicha");
    }
}
