package models;

import java.time.Month;

public class Transaction {
    private  int CustomerId;
    public Transaction(int customerId) {
        this.CustomerId=customerId;

    }

    public int getCustomerId() {
        return CustomerId;
    }

    public static boolean perform(String grocery, double amount, Month month) {


      return true;
    }
}
