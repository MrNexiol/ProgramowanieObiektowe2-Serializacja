package main;

public class Person {
    private String name;
    private String surname;
    private String birthDate;
    private Address address;

    public Person(String name, String surname, String birthDate, Address address){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }
}
