package org.example;

import java.util.List;

public class CitySorter {
    private static int[] convertListToPopulationArray(List<City> cities) {
        int[] arrayPopulation = new int[cities.size()];

        for(int i = 0; i < cities.size(); ++i) {
            arrayPopulation[i] = Integer.parseInt(((City)cities.get(i)).getPopulation());
        }

        return arrayPopulation;
    }

    public static void findCityWithMaxPopulation(List<City> cities) {
        int[] arrayPopulation = convertListToPopulationArray(cities);
        int maxPopulation = arrayPopulation[0];
        int maxPopulationIndex = 0;

        for(int i = 0; i < arrayPopulation.length - 1; ++i) {
            if (maxPopulation < arrayPopulation[i]) {
                maxPopulation = arrayPopulation[i];
                maxPopulationIndex = i;
            }
        }

        System.out.println("[" + maxPopulationIndex + "] = " + maxPopulation);
    }
}
