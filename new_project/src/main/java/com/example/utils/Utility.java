package com.example.utils;

import com.data.access.layer.AmountRange;
import com.example.model.SlabRequest;
import com.example.model.SlabResponse;

import java.util.*;
import java.util.stream.Collectors;

public class Utility {

    public static List<Integer> getStartAndEndAmount(String range){
        String[] rangeArray = range.split("-");
        return Arrays.asList(Integer.valueOf(rangeArray[0]), Integer.valueOf(rangeArray[1]));

    }

    public static Map<Integer, AmountRange> getResponse(int discount, Map<Integer, AmountRange> regular) {

       Map<Integer, AmountRange> response =  regular.entrySet().stream().
                filter(
                        obj-> obj.getKey() == discount)
                .collect(Collectors.toMap(obj->obj.getKey(), obj->obj.getValue()));
        return response;
    }

    public static Map<Integer, AmountRange> getDiscountResponse(int discount, Map<Integer, AmountRange> regular) {

        Map<Integer, AmountRange> response =  regular.entrySet().stream().
                filter(
                        obj-> obj.getKey() == discount)
                .collect(Collectors.toMap(obj->obj.getKey(), obj->obj.getValue()));
        return response;
    }

    public static double getProcessedAmount(int discount, int amount) {


        double amountFinal = (discount*amount)/100;
        return amount - amountFinal;

    }

    public static int discount(int amount, Map<Integer, AmountRange> result) {
        Integer response = result.entrySet().stream().
                filter(
                        obj-> obj.getValue().getEndAmount() > amount
                                && obj.getValue().getStartAmount()>=amount)
                .findFirst().get().getKey();

        return response;
    }
}
