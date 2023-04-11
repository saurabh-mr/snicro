package org.example;

import com.example.model.NewSlab;
import com.example.model.SlabRequest;
import com.example.model.SlabResponse;
import com.example.service.CustomerAmountSlab;
import com.example.service.Impl.CustomerSlabServiceImpl;
import com.example.utils.Constants;

import java.util.Map;

public class Main {
    static CustomerSlabServiceImpl customerSlabServiceImpl ;

    Main(){
        // for plugin related and auth related we can hold the object in interface type
        customerSlabServiceImpl = CustomerSlabServiceImpl.getCustomerSlabServiceInstance();
    }
    public static void main(String[] args) {
        Main main = new Main();

               // add new slab in discount
        //setSlab("30-50", 10, Constants.REGULAR);

               // get discount for both slabs
        //SlabResponse response =  getSlabs(3224);

               //get discount
        //SlabResponse finalPrice =  getSlab(10, "regular");

               // get amount range on discounts
        //SlabResponse finalPrice =  getAmountRangeOnDiscount(10);

              // get final prices
        //Map<String, Integer> finalPrice = main.getFinalPrices(4000);

               // getFinalPrice
        double finalPrice = main.getFinalPrice("regular",4000);
        System.out.println(finalPrice);

    }

    private double getFinalPrice(String customerType, int amount) {
        SlabRequest slabRequest = new SlabRequest();
        slabRequest.setCustomerType(customerType);
        slabRequest.setAmount(amount);
        double response = 0;
        try{
            response = customerSlabServiceImpl.getPrice(slabRequest);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return response;
    }

    private Map<String, Integer> getFinalPrices(int amount) {
        SlabRequest slabRequest = new SlabRequest();
        slabRequest.setAmount(amount);
        Map<String, Integer> result= null;
        try {
            result = customerSlabServiceImpl.getFinalPrices(slabRequest);

        } catch (Exception e){
            System.out.println( e.getMessage());
        }
        return result;
    }

    private static SlabResponse getAmountRangeOnDiscount(int discount) {
        SlabRequest slabRequest = new SlabRequest(discount);
        SlabResponse response = null;
        try {
             response = customerSlabServiceImpl.getPriceRanges(slabRequest);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }

    private static SlabResponse getSlab(int discount, String customerType) {
        SlabRequest slabRequest = new SlabRequest(discount);
        slabRequest.setCustomerType(customerType);
        SlabResponse response = null;
        try{
            response = customerSlabServiceImpl.getSlab(slabRequest);
        } catch (Exception e) {
            System.out.println( e.getMessage());

        }
        return response;
    }

    private static SlabResponse getSlabs(int amount) {
        SlabResponse response = null;
        try{
             response =  customerSlabServiceImpl.getSlabs(amount);
        } catch (Exception e) {
            System.out.println( e.getMessage());

        }
        return response;
    }

    private static void setSlab(String s, int discount, String regular) {
        NewSlab newSlab = new NewSlab(s, discount, regular);
        try {
            customerSlabServiceImpl.setNewSlab(newSlab);
        } catch (Exception e){
            System.out.println("Exception occured while setting up new slab"+ e.getMessage());
        }
    }

}