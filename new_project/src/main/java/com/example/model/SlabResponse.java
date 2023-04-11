package com.example.model;

import com.data.access.layer.AmountRange;

import java.util.LinkedHashMap;
import java.util.Map;

public class SlabResponse {

    private Map<Integer, AmountRange> regular = new LinkedHashMap<>();
    private Map<Integer, AmountRange> premium = new LinkedHashMap<>();

    private int resultAmount;

    public SlabResponse(){}
    public SlabResponse(Map<Integer, AmountRange> regular, Map<Integer, AmountRange> premium){
        this.premium = premium;
        this.regular = regular;
    }


    public void setPremium(Map<Integer, AmountRange> premium) {
        this.premium = premium;
    }

    public void setRegular(Map<Integer, AmountRange> regular) {
        this.regular = regular;
    }

    public void setResultAmount(int resultAmount) {
        this.resultAmount = resultAmount;
    }

    public int getResultAmount() {
        return resultAmount;
    }

    @Override
    public String toString() {
        return "SlabResponse{" +
                "regularResponse=" + regular +
                ", premiumResponse=" + premium +
                '}';
    }
}
