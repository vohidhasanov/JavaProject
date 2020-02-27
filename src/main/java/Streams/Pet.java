package Streams;

public class Pet {
    private PetType type;
    private String name;
    private int age;

    public Pet(PetType cat, String name, int age) {
        this.type = cat;
        this.name = name;
        this.age = age;
    }

    public PetType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("The type: %s   The name of Pet: %s   Age of pet: %d",
                type,
               name,
               age
        );
    }
}
