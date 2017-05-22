package com.marketplace.propertiesservice.model;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {

    private BigDecimal value;
    private Currency currency;

    public Price() {
    }

    public Price(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @ApiModelProperty(value = "ISO 4217 currency code", example = "GBP")
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append(value)
            .append(currency)
            .toString();
    }
}
