package com.currency.app.enums;

public enum USACoin {
	PENNY(1), NICKEL(5), DIME(10), QUARTER(25),DOLLAR(100);
	   
    private int denomination;
   
    private USACoin(int denomination){
        this.denomination = denomination;
    }
   
    public int getDenomination(){
        return denomination;
    }

}
