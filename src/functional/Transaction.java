package functional;

/**
 * Created by saeed on 2/13/16.
 */
public class Transaction {
    private long value;

    public Transaction(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
