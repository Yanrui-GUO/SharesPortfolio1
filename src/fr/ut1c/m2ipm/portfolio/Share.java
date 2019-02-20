package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

public abstract class Share {

    private String name;

    public String getName() {
        return name;
    }

    public Share(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("The share name must be defined.");
        }
        this.name = name;
    }

    public abstract float getPrice(Day day);

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Share other = (Share) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return this.getName();
    }
}
