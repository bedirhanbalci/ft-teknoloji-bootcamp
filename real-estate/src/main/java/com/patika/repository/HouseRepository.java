package com.patika.repository;

import com.patika.model.House;
import com.patika.model.SummerHouse;
import com.patika.model.Villa;

import java.util.ArrayList;
import java.util.List;

/**
 * Farklı türdeki evleri (evler, villalar ve yazlık evler) yöneten ve depolayan sınıf.
 * Bu sınıf, ev listelerini almak için yöntemler sağlar.
 */
public class HouseRepository {

    private List<House> houseList = new ArrayList<>();

    private List<Villa> villaList = new ArrayList<>();

    private List<SummerHouse> summerHouseList = new ArrayList<>();

    // Yapıcı metod, listeleri örnek verilerle başlatır
    public HouseRepository() {

        // Örnek Evler eklenir
        houseList.add(new House(500000, 150, 5, 1));
        houseList.add(new House(300000, 120, 4, 1));
        houseList.add(new House(150000, 90, 3, 2));

        // Örnek Villalar eklenir
        villaList.add(new Villa(700000, 275, 6, 1));
        villaList.add(new Villa(350000, 200, 5, 2));
        villaList.add(new Villa(535000, 300, 4, 2));

        // Örnek Yazlık Evler eklenir
        summerHouseList.add(new SummerHouse(100000, 100, 3, 1));
        summerHouseList.add(new SummerHouse(75000, 60, 1, 1));
        summerHouseList.add(new SummerHouse(200000, 200, 3, 2));
    }

    // Ev listeleri için getter metodları
    public List<House> getHouseList() {
        return houseList;
    }

    public List<Villa> getVillaList() {
        return villaList;
    }

    public List<SummerHouse> getSummerHouseList() {
        return summerHouseList;
    }

}
