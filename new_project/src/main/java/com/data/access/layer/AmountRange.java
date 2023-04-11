package com.data.access.layer;

import java.util.List;
import java.util.Objects;

public class AmountRange {
    int startAmount;
    int endAmount;

    AmountRange(int startAmount, int endAmount){
        this.endAmount = endAmount;
        this.startAmount = startAmount;
    }

    AmountRange(List<Integer> range){
        this.endAmount = range.indexOf(1);
        this.startAmount = range.indexOf(0);
    }


    public int getEndAmount() {
        return endAmount;
    }

    public int getStartAmount() {
        return startAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmountRange that = (AmountRange) o;
        return startAmount == that.startAmount && endAmount == that.endAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startAmount, endAmount);
    }

    @Override
    public String toString() {
        return "AmountRange{" +
                startAmount +"-" + endAmount +
                '}';
    }
}
