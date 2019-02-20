package com.start.boot.child;

import com.start.boot.Parent.Animal;

public class Cat extends Animal{
    @Override
    public String getShout() {
        return "瞄";
    }
}
