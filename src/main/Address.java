package main;

public class Address {
    private String streetName;
    private int streetNumber;
    private int houseNumber;
    private String cityName;

    public Address(String streetName, int streetNumber, int houseNumber, String cityName){
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
    }
}
