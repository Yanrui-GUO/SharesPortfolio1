package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

public class SimpleShare extends Share {

    private Map<Day, Price> mapPrices;

    public SimpleShare(String name) {
        super(name);
        this.mapPrices = new HashMap();
    }

    public void setPrice(Day day, float value) {
        if (this.mapPrices.containsKey(day) == false) {
            this.mapPrices.put(day, new Price(day, value));
        }
    }

    @Override
    public float getPrice(Day day) {
        if (this.mapPrices.containsKey(day) == true) {
            return this.mapPrices.get(day).getValue();
        } else {
            return 0.0F;
        }
    }
}
