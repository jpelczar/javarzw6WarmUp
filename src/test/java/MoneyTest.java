import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {

    private Money money;

    @BeforeEach
    void setUp() {
        money = new Money(Currency.EUR, 5.56f);
    }

    @Test
    void testCurrencyGet() {
        Assertions.assertEquals(Currency.EUR,
                money.getCurrency());
    }

    @Test
    void testAmountGet() {
        Assertions.assertEquals(5.56f,
                money.getAmount());
    }

    @Test
    void testToString() {
        System.out.println(money);
        Assertions.assertEquals("EUR 5.56",
                money.toString());
    }

    @Test
    void testEqual() {
        Money moneyToCompare = new Money(Currency.EUR, 5.56f);

        Assertions.assertEquals(money, moneyToCompare);
    }

    @Test
    void testNotEqual() {
        Money moneyToCompare = new Money(Currency.PLN, 1f);

        Assertions.assertNotEquals(money, moneyToCompare);
    }

    @Test
    void testParse() {
        Money parsedMoney = Money.parse("EUR 5.56");

        Assertions.assertEquals(money, parsedMoney);
    }

    @Test
    void testParse_MissingEnum() {
        Assertions.assertThrows(RuntimeException.class,
                () -> Money.parse("XXX 5.56"));
    }
}