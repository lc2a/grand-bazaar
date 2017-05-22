package com.marketplace.propertiesservice.search;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Range<T> {

    private T min;
    private T max;

    public Range(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append(min)
            .append(max)
            .toString();
    }
}
