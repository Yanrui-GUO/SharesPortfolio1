package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

/**
 * Portfolio allows to create a set of shares with associated quantities. It
 * allows buy, sell and compute the value of a set of shares.
 *
 * @author David Navarre
 */
public class Portfolio {

    /**
     * This collection stores shares and their quantity.
     */
    Map<Share, PortfolioLine> mapLines;

    /**
     * Build an empty Portfolio.
     */
    public Portfolio() {
        this.mapLines = new HashMap();
    }

    public void buy(Share share, int quantity) {
        if (this.mapLines.containsKey(share) == false) {
            this.mapLines.put(share, new PortfolioLine(share, quantity));
        } else {
            this.mapLines.get(share).setQuantity(this.mapLines.get(share).getQuantity() + quantity);
        }
    }

    public void sell(Share a, int q) {
        if (this.mapLines.containsKey(a) == true) {
            if (this.mapLines.get(a).getQuantity() > q) {
                this.mapLines.get(a).setQuantity(this.mapLines.get(a).getQuantity() - q);
            } else if (this.mapLines.get(a).getQuantity() == q) {
                this.mapLines.remove(a);
            }
        }
    }

    public String toString() {
        return this.mapLines.toString();
    }

    public float getValue(Day j) {
        float total = 0;
        for (PortfolioLine lp : this.mapLines.values()) {
            total = total + (lp.getQuantity() * lp.getShare().getPrice(j));
        }
        return total;
    }

    private class PortfolioLine {

        private Share share;

        private int quantity;

        public PortfolioLine(Share share, int quantity) {
            this.share = share;
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Share getShare() {
            return this.share;
        }

        public String toString() {
            return Integer.toString(quantity);
        }
    }
}
