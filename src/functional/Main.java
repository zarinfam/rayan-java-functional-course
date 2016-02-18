package functional;

import functional.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class Main {


    public static void main(String[] args) {

        ArrayList<Transaction> transactions = new ArrayList<>(Arrays.asList(
                new Transaction(20), new Transaction(40),new Transaction(10),new Transaction(25)));

        Optional<Transaction> mostExpensiveOptional = declarativeStyle(transactions);

        Transaction mostExpensive = imperativeStyle(transactions);

        System.out.println("mostExpensiveOptional = " + mostExpensiveOptional.orElse(new Transaction(-1)).getValue());
        System.out.println("imperativeStyle = " + mostExpensive.getValue());
    }

    public static Optional<Transaction> declarativeStyle(ArrayList<Transaction> transactions) {
//        return transactions.stream().max(comparing(Transaction::getValue));
        return transactions.stream().reduce((a , b) -> (a.getValue() > b.getValue()) ? a : b );
    }

    public static Transaction imperativeStyle(ArrayList<Transaction> transactions){
        Transaction mostExpensive = transactions.get(0);

        if(mostExpensive == null)
            throw new IllegalArgumentException("Empty list of transactions");

        for(Transaction t: transactions.subList(1, transactions.size())){
            if(t.getValue() > mostExpensive.getValue()){
                mostExpensive = t;
            }
        }

        return mostExpensive;
    }
}
