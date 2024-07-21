package com.patika.model;

public class Villa extends House {

    public Villa(double price, double squareMeters, int numberOfRooms, int numberOfLivingRooms) {
        super(price, squareMeters, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() + "}";
    }

}
