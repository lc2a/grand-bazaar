package com.marketplace.propertiesservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Contract {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public enum Type {
        rental, sale
    }

    private Type type;

    public Contract() {
    }

    public Contract(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append(type)
            .toString();
    }
}
