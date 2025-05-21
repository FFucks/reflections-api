import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Dog extends Animal implements Locomotion{

    @DefaultName("Solo")
    private String name;

    @DefaultBreed("salsicha")
    private String breed;

    public Dog() {
        this.name = "Spike";
        this.breed = "vira-lata";
    }

    public Dog(String name, String breed) throws Exception {
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

    @Override
    public String getLocomotion() {
        return "walks";
    }

    @Override
    public String eats() {
        return "meat";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface DefaultName {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface DefaultBreed {
        String value();
    }
}
