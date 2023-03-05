public class PetsAnimals extends Animals {
    protected PetsAnimals(String name, Integer age) {
        super(name, age);
    }
}

class Cats extends PetsAnimals {
    String type = "Кот";
    public Cats(String name, Integer age) {
        super(name, age);
    }
}

class Dogs extends PetsAnimals {
    public Dogs(String name, Integer age) {
        super(name, age);
    }
}

class Humsters extends PetsAnimals {
    public Humsters(String name, Integer age) {
        super(name, age);
    }
}
