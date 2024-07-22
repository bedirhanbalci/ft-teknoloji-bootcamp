package com.patika.service;

import com.patika.model.House;
import com.patika.model.SummerHouse;
import com.patika.model.Villa;
import com.patika.repository.HouseRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Evlerle ilgili iş mantığını sağlar. Fiyat ve alan hesaplamaları yapar.
 * Oda sayısı ile oturma odası sayısına göre filtreleme yapar.
 */
public class HouseService {

    private HouseRepository houseRepository;

    // Servisi bir repository örneği ile başlatan yapıcı metod
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    // Evlerin toplam fiyatını hesaplar
    public double getTotalPriceOfHouses() {
        return houseRepository.getHouseList().stream().mapToDouble(House::getPrice).sum();
    }

    // Villaların toplam fiyatını hesaplar
    public double getTotalPriceOfVillas() {
        return houseRepository.getVillaList().stream().mapToDouble(Villa::getPrice).sum();
    }

    // Yazlık evlerin toplam fiyatını hesaplar
    public double getTotalPriceOfSummerHouses() {
        return houseRepository.getSummerHouseList().stream().mapToDouble(SummerHouse::getPrice).sum();
    }

    // Tüm ev türlerinin toplam fiyatını hesaplar
    public double getTotalPriceOfAllHouses() {
        return getTotalPriceOfHouses() + getTotalPriceOfVillas() + getTotalPriceOfSummerHouses();
    }

    // Evlerin ortalama metrekare alanını hesaplar
    public double getAverageSquareMetersOfHouses() {
        return houseRepository.getHouseList().stream().mapToDouble(House::getSquareMeters).average().orElse(0);
    }

    // Villaların ortalama metrekare alanını hesaplar
    public double getAverageSquareMetersOfVillas() {
        return houseRepository.getVillaList().stream().mapToDouble(Villa::getSquareMeters).average().orElse(0);
    }

    // Yazlık evlerin ortalama metrekare alanını hesaplar
    public double getAverageSquareMetersOfSummerHouses() {
        return houseRepository.getSummerHouseList().stream().mapToDouble(SummerHouse::getSquareMeters).average().orElse(0);
    }

    // Tüm ev türlerinin ortalama metrekare alanını hesaplar
    public double getAverageSquareMetersOfAllHouses() {
        double totalSquareMeters = 0;
        int count = 0;

        List<House> allHouses = houseRepository.getHouseList();
        totalSquareMeters += allHouses.stream().mapToDouble(House::getSquareMeters).sum();
        count += allHouses.size();

        List<Villa> allVillas = houseRepository.getVillaList();
        totalSquareMeters += allVillas.stream().mapToDouble(Villa::getSquareMeters).sum();
        count += allVillas.size();

        List<SummerHouse> allSummerHouses = houseRepository.getSummerHouseList();
        totalSquareMeters += allSummerHouses.stream().mapToDouble(SummerHouse::getSquareMeters).sum();
        count += allSummerHouses.size();

        return count > 0 ? totalSquareMeters / count : 0;

    }

    // Oda sayısı ve oturma odası sayısına göre evleri filtreler
    public List<House> filterHousesByRoomAndLivingRoom(int rooms, int livingRooms) {
        return Stream.concat(
                        Stream.concat(
                                houseRepository.getHouseList().stream(),
                                houseRepository.getVillaList().stream()
                        ),
                        houseRepository.getSummerHouseList().stream()
                ).filter(h -> h.getNumberOfRooms() == rooms && h.getNumberOfLivingRooms() == livingRooms)
                .collect(Collectors.toList());
    }

}
