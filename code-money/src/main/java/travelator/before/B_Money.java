package travelator.before;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import static java.math.BigDecimal.ZERO;

public class B_Money {
    private final BigDecimal amount;
    private final Currency currency;

    private B_Money(BigDecimal amount, Currency currency) { // <1> 비공개 생성자
        this.amount = amount;
        this.currency = currency;
    }

    public static B_Money of(BigDecimal amount, Currency currency) { // <1>
        return new B_Money(
                // scale 변수를 셋팅하지 않음, withScale 명칭이 더 맞다
                amount.setScale(currency.getDefaultFractionDigits()),
                currency);
    }


    public static B_Money of(String amountStr, Currency currency) { // <2>
        return B_Money.of(new BigDecimal(amountStr), currency);
    }

    public static B_Money of(int amount, Currency currency) {
        return B_Money.of(new BigDecimal(amount), currency);
    }

    public static B_Money zero(Currency userCurrency) {
        return B_Money.of(ZERO, userCurrency);
    }


    public BigDecimal getAmount() { // <2>
        return amount;
    }

    public Currency getCurrency() { // <3>
        return currency;
    }

    @Override
    public boolean equals(Object o) { // <3>
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B_Money money = (B_Money) o;
        return amount.equals(money.amount) &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() { // <3>
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() { // <4>
        return amount.toString() + " " + currency.getCurrencyCode();
    }

    public B_Money add(B_Money that) { // <5> Money 통화값을 계산할 수 있는 연산 제공
        if (!this.currency.equals(that.currency)) {
            throw new IllegalArgumentException(
                    "cannot add Money values of different currencies");
        }

        return new B_Money(this.amount.add(that.amount), this.currency);
    }
}
