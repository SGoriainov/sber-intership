package org.example;


import java.util.List;


public class Main {
    public static void main(String[] args) {

        String filePath = "src/main/resources/Задача ВС Java Сбер.csv";

        List<City> cities = CityParser.parseCitiesFromFile(filePath);

        CitySorter.findCityWithMaxPopulation(cities);
    }
}
