package com.patika.model;

public class House {

    private double price;

    private double squareMeters;

    private int numberOfRooms;

    private int numberOfLivingRooms;

    public House(double price, double squareMeters, int numberOfRooms, int numberOfLivingRooms) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.numberOfRooms = numberOfRooms;
        this.numberOfLivingRooms = numberOfLivingRooms;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfLivingRooms() {
        return numberOfLivingRooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "price=" + price +
                ", squareMeters=" + squareMeters +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfLivingRooms=" + numberOfLivingRooms +
                '}';
    }
}
