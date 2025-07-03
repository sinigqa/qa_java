package com.example;

import java.util.List;

public class Lion {

    private final Predator predator;
    boolean hasMane;

    public Lion(String sex, Predator predator) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.predator = predator;
    }

    public int getKittens() throws Exception {
        return predator.getKittens();
    }

    public boolean hasMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
