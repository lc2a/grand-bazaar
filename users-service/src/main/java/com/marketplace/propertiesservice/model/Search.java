package com.marketplace.propertiesservice.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;

public class Search {

    @Id
    private String id;
    private String userId;
    private Price minimumPrice;
    private Price maximumPrice;
    private int minimumBedrooms;
    private int maximumBedrooms;
    private Contract contract;
    private Location location;

    public Search() {
    }

    public Search(String userId, Price minimumPrice, Price maximumPrice, int minimumBedrooms, int maximumBedrooms,
                  Contract contract, Location location) {
        this.userId = userId;
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
        this.minimumBedrooms = minimumBedrooms;
        this.maximumBedrooms = maximumBedrooms;
        this.contract = contract;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Price getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Price minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Price getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(Price maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public int getMinimumBedrooms() {
        return minimumBedrooms;
    }

    public void setMinimumBedrooms(int minimumBedrooms) {
        this.minimumBedrooms = minimumBedrooms;
    }

    public int getMaximumBedrooms() {
        return maximumBedrooms;
    }

    public void setMaximumBedrooms(int maximumBedrooms) {
        this.maximumBedrooms = maximumBedrooms;
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
            .append(userId)
            .append(minimumPrice)
            .append(maximumPrice)
            .append(minimumBedrooms)
            .append(maximumBedrooms)
            .append(contract)
            .append(location)
            .toString();
    }
}
