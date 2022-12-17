package before

import before.step2.Legs2.longestLegOver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import travelator.Leg
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.concurrent.ThreadLocalRandom

class LongestLegOverTests4 {

    private val legs = listOf(
        leg("one hour", Duration.ofHours(1)),
        leg("one day", Duration.ofDays(1)),
        leg("two hours", Duration.ofHours(2))
    )
    private val oneDay = Duration.ofDays(1)

    @Test
    fun `is absent when no legs`() {
        assertNull(longestLegOver(emptyList(), Duration.ZERO))
    }

    @Test
    fun `is absent when no legs long enough`() {
        assertNull(longestLegOver(legs, oneDay))
    }

    @Test
    fun `is longest leg when one match`() {
        assertEquals(
            "one day",
            /*
            !! 로 변경
            - 원소를 찾는데 실패하면 NullPointerException 발생
            - 실전에서 !!를 사용하는 몇 안되는 케이스가 바로 테스트
             */
            longestLegOver(legs, oneDay.minusMillis(1))
            !!.description
        )
    }

    @Test
    fun `is longest leg when more than one match`() {
        assertEquals(
            "one day",
            /*
            ?. 로 변경
            - 수신 객체가 null이 아닌 경우에만 평가를 계속한다.
            Expected : one day
            Actual : null
             */
            longestLegOver(legs, Duration.ofMinutes(59))
                ?.description
        )
    }

    private fun leg(description: String, duration: Duration): Leg {
        val start = ZonedDateTime.ofInstant(
            Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt().toLong()),
            ZoneId.of("UTC"));
        return Leg(description, start, start.plus(duration));
    }
}