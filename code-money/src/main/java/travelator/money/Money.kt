package travelator.money

import java.math.BigDecimal
import java.util.*

// data 클래스로 선언한다면?
// private 키워드를 강조하면서, 경고가 표시된다.
// -> '생성되는 copy 메서드에 따라 비공개 데이터 클래스 생성자가 노출된다'
// data 클래스는 copy 메서를 제공해주고, 이를 통해 불변 조건을 지키지 않는 Money 객체가 생성될 수 있다.

// 결론 : 프로퍼티 사이에 불변 조건을 유지해야하는 값 타입을 데이터 클래스를 사용해서 정의하지 말라
class Money private constructor( // private 주생성자
    /* 불변 조건 : amount 필드의 정밀도가 currency 필드가 가리키는 통화의 보조통화 단위와 일치하게 보장한다 */
    val amount: BigDecimal,
    val currency: Currency
) {
    override fun equals(other: Any?) =
        this === other ||
            other is Money &&
            amount == other.amount &&
            currency == other.currency

    override fun hashCode() =
        Objects.hash(amount, currency)

    override fun toString() =
        amount.toString() + " " + currency.currencyCode

    fun add(that: Money) = this + that

    operator fun plus(that: Money): Money {
        require(currency == that.currency) {
            "cannot add Money values of different currencies"
        }
        return Money(this.amount + that.amount, currency)
    }

    companion object : (BigDecimal,Currency) -> Money {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency) =
            this(amount, currency)

        override operator fun invoke(amount: BigDecimal, currency: Currency) =
            Money(
                amount.setScale(currency.defaultFractionDigits),
                currency
            )

        @JvmStatic
        fun of(amountStr: String, currency: Currency) =
            this(amountStr, currency)

        operator fun invoke(amountStr: String, currency: Currency) =
            invoke(BigDecimal(amountStr), currency)

        @JvmStatic
        fun of(amount: Int, currency: Currency) =
            this(amount, currency)

        operator fun invoke(amount: Int, currency: Currency) =
            invoke(BigDecimal(amount), currency)

        @JvmStatic
        fun zero(userCurrency: Currency) =
            invoke(BigDecimal.ZERO, userCurrency)
    }
}