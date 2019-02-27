package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

/**
 * Objects from this class allow to store the price of any share for a given
 * day.
 *
 * @author David Navarre
 */
public final class Price {

    /**
     * The day for the definition of a price cannot be null.
     */
    private final Day day;

    /**
     * The price cannot be negative or null.
     */
    private final float value;

    /**
     * Defines a Price with a float value for a given day.
     *
     * @param aDay is a non null value
     * @param aValue is a >0 value
     */
    public Price(final Day aDay, final float aValue) {
        if (Objects.isNull(aDay)) {
            throw new IllegalArgumentException("The day cannot be null");
        }
        if (aValue <= 0) {
            throw new IllegalArgumentException("The value cannot be negative or null");
        }
        this.day = aDay;
        this.value = aValue;
    }

    /**
     * Provide read access to the value of the price.
     *
     * @return the value of the price
     */
    public float getValue() {
        return value;
    }

    /**
     * Provide read access to the day of definition of the price.
     *
     * @return the day of definition of the price
     */
    public Day getDay() {
        return day;
    }
}
