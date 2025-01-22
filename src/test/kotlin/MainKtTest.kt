import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    val maxDelta: Double = 0.0001

    @Test
    fun calculateCommission_mir() {
        assertEquals(calculateCommission("Мир", 0.0,4_000.0), 0.0, maxDelta)
    }

    @Test
    fun calculateCommission_mir_overpay_day() {
        assertEquals(calculateCommission("Мир", 0.0,155_000.0), (-1.0), maxDelta)
    }

    @Test
    fun calculateCommission_mir_overpay_month() {
        assertEquals(calculateCommission("Мир", 601_000.0,150_000.0), (-1.0), maxDelta)
    }

    @Test
    fun calculateCommission_mastercard_prelimit() {
        assertEquals(calculateCommission("Mastercard", 0.0,60_000.0), 0.0, maxDelta)
    }

    @Test
    fun calculateCommission_mastercard_postlimit1() {
        assertEquals(calculateCommission("Mastercard", 65_000.0,20_000.0), 80.0, maxDelta)
    }

    @Test
    fun calculateCommission_mastercard_postlimit2() {
        assertEquals(calculateCommission("Mastercard", 80_000.0,150_000.0), 920.0, maxDelta)
    }

    @Test
    fun calculateCommission_visa() {
        assertEquals(calculateCommission("Visa", 80_000.0,150_000.0), 1125.0, maxDelta)
    }

    @Test
    fun calculateCommission_visa_free() {
        assertEquals(calculateCommission("Visa", 200.0,100.0), 35.0, maxDelta)
    }

    @Test
    fun calculateCommission_default() {
        assertEquals(calculateCommission(sumPay = 100.0), 0.0, maxDelta)
    }
}