package com.example.model;

public class NewSlab {
    String slabRange ;
    int discount;
    String customerType;

    public NewSlab(String slabRange, int discount, String customerType){
        this.slabRange = slabRange;
        this.discount = discount;
        this.customerType = customerType;
    }

    public String getSlabRange() {
        return slabRange;
    }

    public String getCustomerType() {
        return customerType;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "NewSlab{" +
                "slabRange='" + slabRange + '\'' +
                ", discount='" + discount + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
