package models;


import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {
    private int customerId;
    private Map<Integer, List<TransactionInfo>> transactionsByCustomerId;

    public Transaction(int customerId) {
        this.customerId = customerId;
        this.transactionsByCustomerId = new HashMap<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public boolean perform(Category category, double amount, Month month) {
        // Check if the provided category is valid
        if (category == null) {
            System.err.println("Invalid grocery category: " + category);
            return false; // Return false to indicate the transaction failed due to an invalid category
        }

        // Continue with transaction processing
        TransactionInfo transactionInfo = new TransactionInfo(category.name(), amount, month);
        if (!transactionsByCustomerId.containsKey(customerId)) {
            transactionsByCustomerId.put(customerId, new ArrayList<>());
        }
        transactionsByCustomerId.get(customerId).add(transactionInfo);
        System.out.println(transactionsByCustomerId);
        return true; // Return true to indicate the transaction was successfully performed
    }
}

