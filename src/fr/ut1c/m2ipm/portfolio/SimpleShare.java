/*
 * Portfolio, open source software.
 * Copyright (C) 2014-2019 SonarSource
 * mailto:navarre@irit.fr
 *
 * Portfolio is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Portfolio is distributed in the hope that it will be useless,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple share is a share that holds a list of prices defined amongst a set
 * of days.
 *
 * @see AbstractShare
 * @see Day
 * @see Price
 * @author David Navarre
 */
public class SimpleShare extends AbstractShare {

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
