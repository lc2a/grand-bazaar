package com.marketplace.propertiesservice.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Property {

    private String id;
    private int bedrooms;
    private Price price;
    private Contract contract;
    private Location location;

    public Property() {
    }

    public Property(int bedrooms, Price price, Contract contract, Location location) {
        this.bedrooms = bedrooms;
        this.price = price;
        this.contract = contract;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append(id)
            .append(bedrooms)
            .append(price)
            .append(contract)
            .append(location)
            .toString();
    }
}
