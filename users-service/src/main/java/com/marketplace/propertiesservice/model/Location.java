package com.marketplace.propertiesservice.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Location {

    private String street;
    private String postCode;
    private String city;
    private String country;

    public Location() {
    }

    public Location(String street, String postCode, String city, String country) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append(street)
            .append(postCode)
            .append(city)
            .append(country)
            .toString();
    }
}
