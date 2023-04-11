package com.example.model;

public class SlabRequest {
   private String slabRange;
    private int slabDiscount;

    private String customerType;
    private int amount;


    public SlabRequest(){}
    public SlabRequest(int slabDiscount, String slabRange) {
        this.slabRange = slabRange;
        this.slabDiscount = slabDiscount;
        this.customerType = customerType;
    }
    public SlabRequest(int slabDiscount, String slabRange, String customerType) {
        this.slabRange = slabRange;
        this.slabDiscount = slabDiscount;
        this.customerType = customerType;
    }



    public SlabRequest(String slabRange) {
        this.slabRange = slabRange;
    }

    public String getSlabRange() {
        return slabRange;
    }

    public int getSlabDiscount() {
        return slabDiscount;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public SlabRequest(int slabDiscount) {
        this.slabDiscount = slabDiscount;
    }

    @Override
    public String toString() {
        return "SlabRequest{" +
                "slabRange='" + slabRange + '\'' +
                ", slabDiscount='" + slabDiscount + '\'' +
                '}';
    }
}
