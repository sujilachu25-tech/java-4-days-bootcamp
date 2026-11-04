class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }

    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {

    void meow() {
        System.out.println("Cat is meowing");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        System.out.println("Dog:");
        dog.eat();
        dog.sleep();
        dog.bark();

        System.out.println();

        System.out.println("Cat:");
        cat.eat();
        cat.sleep();
        cat.meow();
    }
}
