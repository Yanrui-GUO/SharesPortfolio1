package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple share is a share that holds a list of prices defined amongst a set
 * of days.
 *
 * @see Share
 * @see Day
 * @see Price
 * @author David Navarre
 */
public class SimpleShare extends Share {

    /**
     * A collection that maps a day into a price.
     */
    private Map<Day, Price> mapPrices;

    /**
     * Build a simple share.
     *
     * @param name a non null string
     */
    public SimpleShare(final String name) {
        super(name);
        this.mapPrices = new HashMap<>();
    }

    /**
     * Defines the price for a given day if the price is not already defined.
     * This method is not designed to be overriden.
     *
     * @param aDay a non null day
     * @param aValue a strictly positive value
     */
    public final void setPrice(final Day aDay, final float aValue) {
        if (!this.mapPrices.containsKey(aDay)) {
            this.mapPrices.put(aDay, new Price(aDay, aValue));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final float getPrice(final Day aDay) {
        if (this.mapPrices.containsKey(aDay)) {
            return this.mapPrices.get(aDay).getValue();
        } else {
            return 0.0F;
        }
    }
}
