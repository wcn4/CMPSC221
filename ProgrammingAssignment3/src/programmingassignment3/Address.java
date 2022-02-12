/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment3;

/**
 *
 * @author Yoshi
 */
public class Address {
    
    //Properties of the Address, assuming they do not change
    private final String street;
    private final String city;
    private final String state;
    private final String zipcode;
    
    //Creates an Address using the street, city, state, and zipcode (all as strings)
    public Address(String street, String city, String state, String zipcode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    //Getter function for Street
    public String getStreet(){
        return street;
    }
    
    //Getter function for City
    public String getCity(){
        return city;
    }
    
    //Getter function for State
    public String getState(){
        return state;
    }
    
    //Getter function for the Zip code
    public String getZipCode(){
        return zipcode;
    }
    
    @Override
    public String toString(){
        return String.format("Property Address:%n"
                + "\t%s %n"
                + "\t%s, %s %s%n", this.getStreet(), this.getCity(), this.getState(), this.getZipCode());
    }
}
