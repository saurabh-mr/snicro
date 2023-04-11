package com.example.service;

import com.example.model.SlabRequest;
import com.example.model.SlabResponse;

import java.util.Map;

public interface CustomerAmountSlab {

    Map<String, Integer> getFinalPrices(SlabRequest slabRequest) throws Exception;

}
