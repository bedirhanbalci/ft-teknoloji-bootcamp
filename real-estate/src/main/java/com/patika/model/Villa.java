package com.patika.model;

/**
 * Villa sınıfı, genel bir evi temsil eden House sınıfından türetilmiştir.
 * Villa türündeki evler için ek özellikler eklenmemiştir.
 */
public class Villa extends House {

    // Villa özelliklerini başlatmak için üst sınıfın yapıcısı kullanılır
    public Villa(double price, double squareMeters, int numberOfRooms, int numberOfLivingRooms) {
        super(price, squareMeters, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() + "}";
    }

}
