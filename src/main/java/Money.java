import java.util.Objects;

public class Money {

    private Currency currency;
    private float amount;

    //input = "EUR 5.56"
    public static Money parse(String input) {
        String[] result = input.split(" ");

        try {
            Currency parsedCurrency =
                    Currency.valueOf(result[0]);
            float parsedAmount =
                    Float.parseFloat(result[1]);

            return new Money(parsedCurrency, parsedAmount);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("There is no defined currency " + input);
        }
    }


    public Money(Currency currency, float amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return currency + " " + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Float.compare(money.amount, amount) == 0 &&
                currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
