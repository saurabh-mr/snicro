package com.example.service.Impl;

import com.data.access.layer.AmountRange;
import com.data.access.layer.DaoClass;
import com.example.model.NewSlab;
import com.example.model.SlabRequest;
import com.example.model.SlabResponse;
import com.example.service.CustomerAmountSlab;
import com.example.service.CustomerUtil;
import com.example.utils.Constants;
import com.example.utils.Utility;

import java.util.HashMap;
import java.util.Map;

public class CustomerSlabServiceImpl implements CustomerUtil, CustomerAmountSlab {

    private static CustomerSlabServiceImpl customerSlabService;
    DaoClass daoClass;

    private CustomerSlabServiceImpl() {
        daoClass = new DaoClass();
    }

    public static synchronized CustomerSlabServiceImpl getCustomerSlabServiceInstance(){
        if(customerSlabService == null){
            customerSlabService = new CustomerSlabServiceImpl();
        }
        return customerSlabService;
    }


    @Override
    public void setNewSlab(NewSlab newSlab) throws Exception {
        if(newSlab.getCustomerType() == Constants.REGULAR){
            daoClass.setRegular(newSlab.getDiscount(), Utility.getStartAndEndAmount(newSlab.getSlabRange()));
        } else if(newSlab.getCustomerType() == Constants.PREMIUM)
            daoClass.setPremium(newSlab.getDiscount(), Utility.getStartAndEndAmount(newSlab.getSlabRange()));
    }

    @Override
    public SlabResponse getSlab(SlabRequest slabRequest) throws Exception {
        Map<Integer, AmountRange> result = null;
        Map<Integer, AmountRange> response = null;
        SlabResponse slabResponse = new SlabResponse();
        if(slabRequest.getCustomerType() == Constants.REGULAR){
            result = daoClass.getRegular();
            response = Utility.getResponse(slabRequest.getSlabDiscount(), result);
            slabResponse.setRegular(response);
        } else if(slabRequest.getCustomerType() == Constants.PREMIUM){
            result = daoClass.getPremium();
            response = Utility.getResponse(slabRequest.getSlabDiscount(), result);
            slabResponse.setPremium(response);
        }
        return  slabResponse;
    }

    @Override
    public SlabResponse getSlabs(int amount) throws Exception {
        Map<Integer, AmountRange> regular = daoClass.getRegular();
        Map<Integer, AmountRange> premium = daoClass.getPremium();

        Map<Integer, AmountRange> responseRegular = Utility.getResponse(amount, regular);
        Map<Integer, AmountRange> responsePremium = Utility.getResponse(amount, premium);
        SlabResponse slabResponse = new SlabResponse(responseRegular, responsePremium);
        return  slabResponse;
    }


    @Override
    public double getPrice(SlabRequest slabRequest) throws Exception {
        Map<Integer, AmountRange> result = null;
        int discount = 0;
        if(slabRequest.getCustomerType() == Constants.REGULAR){
            result = daoClass.getRegular();
            discount = Utility.discount(slabRequest.getAmount(), result);
        } else if(slabRequest.getCustomerType() == Constants.PREMIUM){
            result = daoClass.getPremium();
            discount = Utility.discount(slabRequest.getAmount(), result);
        }

        return Utility.getProcessedAmount(discount,slabRequest.getAmount());
    }

    @Override
    public Map<String, Integer> getFinalPrices(SlabRequest slabRequest) throws Exception {
        Map<String, Integer> result = new HashMap<>();
        Map<Integer, AmountRange> resultRegular = null;
        Map<Integer, AmountRange> resultPremium = null;
        resultRegular = daoClass.getRegular();
        int discountRegular = Utility.discount(slabRequest.getAmount(), resultRegular);
        resultPremium = daoClass.getPremium();
        int discountPremium = Utility.discount(slabRequest.getAmount(), resultPremium);
        result.put(Constants.REGULAR, (int) Utility.getProcessedAmount(discountRegular, slabRequest.getAmount()));
        result.put(Constants.PREMIUM, (int) Utility.getProcessedAmount(discountPremium, slabRequest.getAmount()));
        return result;
        }


        @Override
    public SlabResponse getPriceRanges(SlabRequest request) throws Exception {
        Map<Integer, AmountRange> regular = daoClass.getRegular();
        Map<Integer, AmountRange> premium = daoClass.getPremium();

        Map<Integer, AmountRange> responseRegular = Utility.getDiscountResponse(request.getSlabDiscount(), regular);
        Map<Integer, AmountRange> responsePremium = Utility.getDiscountResponse(request.getSlabDiscount(), premium);
        SlabResponse slabResponse = new SlabResponse(responseRegular, responsePremium);
        return  slabResponse;
    }


}
