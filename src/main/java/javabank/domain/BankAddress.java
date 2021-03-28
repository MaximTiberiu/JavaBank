package javabank.domain;

import java.util.Objects;

public class BankAddress {
    private String streetName;
    private int number;
    private String cityName;
    private String countyName;
    private int postalCode;
    private String countryName;

    /**
     * Constructor that creates a new BankAddress
     * @param streetName String,    representing the name of the street name where the bank is located
     * @param number int,           representing the number of the bank building
     * @param cityName String,      representing the name of the city where the bank is located
     * @param countyName String,    representing the county name where the bank is located
     * @param postalCode int,       representing the postal code of the bank
     * @param countryName String,   representing the country name where the bank is located
     */
    public BankAddress(String streetName, int number, String cityName, String countyName, int postalCode, String countryName) {
        this.streetName = streetName;
        this.number = number;
        this.cityName = cityName;
        this.countyName = countyName;
        this.postalCode = postalCode;
        this.countryName = countryName;
    }

    /**
     * @return String, representing the street name where the bank is located
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName String, representing the new street name where the bank is located
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return int, representing the number of the bank building
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number int, representing the new number of the bank building
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return String, representing the name of the city where the bank is located
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName String, representing the new name of the city where the bank is located
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return String, representing the county name where the bank is located
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * @param countyName String, representing the new county name where the bank is located
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /**
     * @return int, representing the postal code of the bank
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode int, representing the new postal code of the bank
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return String, representing the country name where the bank is located
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName String, representing the new country name where the bank is located
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return String, representing the serialization of a BankAddress  | TODO: Implement Serialization
     */
    @Override
    public String toString() {
        return "BankAddress{" +
                "streetName='" + streetName + '\'' +
                ", number=" + number +
                ", cityName='" + cityName + '\'' +
                ", countyName='" + countyName + '\'' +
                ", postalCode=" + postalCode +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    /**
     * Method that verifies if two BankAddress objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the address of the BankAddress is equal to the address of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAddress that = (BankAddress) obj;
        return number == that.number && postalCode == that.postalCode && streetName.equals(that.streetName)
                && cityName.equals(that.cityName) && countyName.equals(that.countyName) && countryName.equals(that.countryName);
    }

    /**
     * Method that gets the hashCode of the BankAddress
     * @return int, representing the hashCode of the BankAddress
     */
    @Override
    public int hashCode() {
        return Objects.hash(streetName, number, cityName, countyName, postalCode, countryName);
    }
}
