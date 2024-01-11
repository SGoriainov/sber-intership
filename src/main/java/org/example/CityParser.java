package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityParser {

    public static List<City> parseCitiesFromFile(String filePath) {
        List<City> cities = new ArrayList();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lines = line.split(";");
                City city = createCityFromData(lines);
                cities.add(city);
            }

            return cities;
        } catch (FileNotFoundException var7) {
            throw new RuntimeException(var7);
        }
    }

    private static City createCityFromData(String[] data) {
        String name = data[1];
        String region = data[2];
        String district = data[3];
        String population = data[4];
        String founded = parseFoundedDate(data);
        return new City(name, region, district, population, founded);
    }

    private static String parseFoundedDate(String[] data) {
        String founded = "";

        try {
            if (data.length == 6) {
                founded = data[5];
                if (founded.length() > 4) {
                    int endYear;
                    if ((founded.contains("—") || founded.contains("-")) && founded.contains("века")) {
                        founded = founded.replace("века", "").trim();
                        String[] parts = founded.split("—|-");
                        endYear = (Integer.parseInt(parts[0]) - 1) * 100 + 1;
                        endYear = Integer.parseInt(parts[1]) * 100;
                        String formattedStartYear = String.valueOf(endYear);
                        String formattedEndYear = String.valueOf(endYear);
                        founded = formattedStartYear + "-" + formattedEndYear;
                    }

                    if (founded.contains("век")) {
                        founded = founded.replaceAll(" век", "00");
                        int startYear = Integer.parseInt(founded) - 99;
                        endYear = startYear + 99;
                        String var10000 = String.valueOf(startYear);
                        founded = var10000 + "-" + String.valueOf(endYear);
                    }

                    if (founded.contains("-е")) {
                        founded = founded.substring(0, 4);
                    }
                }
            }

            return founded;
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }
}
