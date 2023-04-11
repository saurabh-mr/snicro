package com.example.service;

import com.example.model.NewSlab;
import com.example.model.SlabRequest;
import com.example.model.SlabResponse;

import java.util.Map;

public interface CustomerUtil {
    public void setNewSlab(NewSlab newSlab) throws Exception;

    SlabResponse getSlab(SlabRequest slabRequest) throws Exception;

    Map<String, Integer> getFinalPrices(SlabRequest slabRequest) throws Exception;

    SlabResponse getSlabs(int amount) throws Exception;

    double getPrice(SlabRequest slabRequest) throws Exception;

    SlabResponse getPriceRanges(SlabRequest request) throws Exception;
}
