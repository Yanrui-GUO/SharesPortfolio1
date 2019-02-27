package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

/**
 * Composed share represent a set of Shares.
 *
 * @see Share
 * @author navarre
 */
public class ComposedShare extends Share {

    /**
     * A map that stores simple shares and their rate within this composed
     * share.
     */
    private final Map<SimpleShare, Float> sharesBasket;

    /**
     * Build a composed share.
     *
     * @param name is a non null string
     */
    public ComposedShare(final String name) {
        super(name);
        this.sharesBasket = new HashMap();
    }

    /**
     * Register a simple share within a composed share according to a rate.
     *
     * @param simpleShare the simple share to store
     * @param percentage the corresponding rate
     */
    public final void registerComposition(
            final SimpleShare simpleShare,
            final float percentage) {
        this.sharesBasket.put(simpleShare, percentage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final float getPrice(final Day day) {
        float value;

        value = 0;
        for (SimpleShare simpleShare : this.sharesBasket.keySet()) {
            value += (simpleShare.getPrice(day)
                    * this.sharesBasket.get(simpleShare));
        }

        return value;
    }

}
