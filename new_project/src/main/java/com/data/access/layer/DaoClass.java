package com.data.access.layer;

import com.example.model.NewSlab;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DaoClass {
    private static Map<Integer, AmountRange> regular = new LinkedHashMap<>();
    static Map<Integer, AmountRange> premium = new LinkedHashMap<>();

    public DaoClass(){
        // adding default values for regular

        regular.put(0, new AmountRange(0,5000));
        regular.put(10, new AmountRange(50000,10000));
        regular.put(20, new AmountRange(10000,Integer.MAX_VALUE));

        // adding default values for premium

        premium.put(10, new AmountRange(0,4000));
        premium.put(15, new AmountRange(4000,8000));
        premium.put(20, new AmountRange(8000,12000));
        premium.put(30, new AmountRange(12000,Integer.MAX_VALUE));

    }

    public Map<Integer, AmountRange> getRegular() throws  Exception{
        return regular;
    }

    public Map<Integer, AmountRange> getPremium() throws  Exception{
        return premium;
    }

    public void setRegular(int discount, List amountRange) throws  Exception{
        regular.put(discount, new AmountRange(amountRange));
    }

    public void setPremium(int discount, List amountRange) throws  Exception{
        premium.put(discount, new AmountRange(amountRange));
    }




}
