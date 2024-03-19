package models;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnusualSpendAnalyzer {
    static Map<Integer, List<TransactionInfo>> previousMonthTransactions = new HashMap<>();
    static Map<Integer, List<TransactionInfo>> currentMonthTransactions = new HashMap<>();

    public static boolean calculate(Map<Integer, List<TransactionInfo>> transactionsByCustomerId) {


        Month currentMonth = Month.valueOf(java.time.LocalDate.now().getMonth().name());


        for (Map.Entry<Integer, List<TransactionInfo>> entry : transactionsByCustomerId.entrySet()) {
            int customerId = entry.getKey();
            List<TransactionInfo> transactions = entry.getValue();

            List<TransactionInfo> previousMonthTransactionsList = new ArrayList<>();
            List<TransactionInfo> currentMonthTransactionsList = new ArrayList<>();

            for (TransactionInfo transaction : transactions) {
                if (transaction.getMonth() == currentMonth) {
                    currentMonthTransactionsList.add(transaction);
                } else {
                    previousMonthTransactionsList.add(transaction);
                }
            }

            if (!previousMonthTransactionsList.isEmpty()) {
                previousMonthTransactions.put(customerId, previousMonthTransactionsList);
            }
            if (!currentMonthTransactionsList.isEmpty()) {
                currentMonthTransactions.put(customerId, currentMonthTransactionsList);
            }
        }


        System.out.println(previousMonthTransactions);
        System.out.println(currentMonthTransactions);


        return true;
    }

    public static void clearPrevious() {
        synchronized (previousMonthTransactions) {
            previousMonthTransactions.clear();
            currentMonthTransactions.clear();
        }
    }

    public static void clearCurrent() {
        synchronized (currentMonthTransactions) {

            currentMonthTransactions.clear();
        }
    }


    public static Map<Integer, List<TransactionInfo>> getPreviousMonthTransactions() {
        return previousMonthTransactions;
    }

    public static Map<Integer, List<TransactionInfo>> getCurrentMonthTransactions() {
        return currentMonthTransactions;
    }


    public int currentMonthTotal(Map<Integer, List<TransactionInfo>> currentMonthTransactions) {
        int total = 0;

        // Iterate over transactions for each customer
        for (List<TransactionInfo> transactions : currentMonthTransactions.values()) {
            for (TransactionInfo transaction : transactions) {
                total += transaction.getAmount(); // Add the amount to the total
            }
        }

        return total;
    }
}

