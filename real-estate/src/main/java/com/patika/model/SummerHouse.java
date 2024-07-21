package com.patika.model;

public class SummerHouse extends House {

    public SummerHouse(double price, double squareMeters, int numberOfRooms, int numberOfLivingRooms) {
        super(price, squareMeters, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public String toString() {
        return "SummerHouse{" + super.toString() + "}";
    }

}
