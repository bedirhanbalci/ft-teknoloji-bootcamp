package com.patika;

import com.patika.model.House;
import com.patika.repository.HouseRepository;
import com.patika.service.HouseService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HouseRepository houseRepository = new HouseRepository();

        HouseService houseService = new HouseService(houseRepository);

        System.out.println("Evlerin toplam fiyatı: " + houseService.getTotalPriceOfHouses());
        System.out.println("Villaların toplam fiyatı: " + houseService.getTotalPriceOfVillas());
        System.out.println("Yazlık evlerin toplam fiyatı: " + houseService.getTotalPriceOfSummerHouses());
        System.out.println("Tüm evlerin toplam fiyatı: " + houseService.getTotalPriceOfAllHouses());

        System.out.println("Evlerin ortalama metrekaresi: " + houseService.getAverageSquareMetersOfHouses());
        System.out.println("Villaların ortalama metrekaresi: " + houseService.getAverageSquareMetersOfVillas());
        System.out.println("Yazlık evlerin ortalama metrekaresi: " + houseService.getAverageSquareMetersOfSummerHouses());
        System.out.println("Tüm evlerin ortalama metrekaresi: " + houseService.getAverageSquareMetersOfAllHouses());

        int rooms = 5;
        int livingRooms = 2;
        List<House> filteredHouses = houseService.filterHousesByRoomAndLivingRoom(rooms, livingRooms);
        System.out.println(rooms + " oda ve " + livingRooms + " salon bulunan filtrelenmiş evler: " + filteredHouses);
    }
}