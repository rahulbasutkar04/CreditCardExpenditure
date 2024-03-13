package models;

import java.time.Month;

public class TransactionInfo {
    private String grocery;
    private double amount;
    private Month month;

    public TransactionInfo(String grocery, double amount, Month month) {
        this.grocery = grocery;
        this.amount = amount;
        this.month = month;
    }

    public String getGrocery() {
        return grocery;
    }


    public double getAmount() {
        return amount;
    }

    public Month getMonth() {
        return month;
    }
    @Override
    public String toString() {
        return "[" + getGrocery() + ", " + getAmount() + ", " + getMonth() + "]";
    }
}
