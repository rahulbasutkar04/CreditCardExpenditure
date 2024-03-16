package models;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnusualSpendAnalyzer {
    public static boolean calculate(Map<Integer, List<TransactionInfo>> transactionsByCustomerId) {
        Map<Integer, List<TransactionInfo>> previousMonthTransactions = new HashMap<>();
        Map<Integer, List<TransactionInfo>> currentMonthTransactions = new HashMap<>();


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
}
