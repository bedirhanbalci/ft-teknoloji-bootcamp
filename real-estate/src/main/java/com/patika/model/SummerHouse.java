package com.patika.model;

/**
 * Yazlık evleri temsil eder. SummerHouse sınıfı, House sınıfından türetilmiştir.
 * Yazlık türündeki evler için ek özellikler eklenmemiştir.
 */
public class SummerHouse extends House {

    // Yazlık ev özelliklerini başlatmak için üst sınıfın yapıcısı kullanılır
    public SummerHouse(double price, double squareMeters, int numberOfRooms, int numberOfLivingRooms) {
        super(price, squareMeters, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public String toString() {
        return "SummerHouse{" + super.toString() + "}";
    }

}
