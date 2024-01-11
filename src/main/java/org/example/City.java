package org.example;

public class City {
    String name;
    String region;
    String district;
    String population;
    String founded;

    public City(String name, String region, String district, String population, String founded) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.founded = founded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population='" + population + '\'' +
                ", founded='" + founded + '\'' +
                '}';
    }
}
