package fr.ut1c.m2ipm.portfolio;

public class Price {

    private Day day;

    private float value;

    public float getValue() {
        return value;
    }

    public Day getDay() {
        return day;
    }

    public Price(Day day, float value) {
        this.day = day;
        this.value = value;
    }
}
