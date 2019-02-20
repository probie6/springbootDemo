package com.start.boot.child;

import com.start.boot.Parent.Animal;

public class Main {
    public static void main(String[] args) throws Exception {

        Animal cat = new Cat();
        Animal dog = new Dog();
        cat.shout();
        dog.shout();

    }

}
