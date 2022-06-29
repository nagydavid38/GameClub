package gameclub.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.Embeddable;

@Embeddable
public class Limits {
    int min;
    int max;

    @JsonAlias("from")
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @JsonAlias("to")
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Limits(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Limits() {
    }

    @Override
    public String toString() {
        return "Limits{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
