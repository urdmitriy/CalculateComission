fun main(){
    val comissionTax = 0.75
    val comissionMin = 35
    val amount = 3_000

    val commission = amount * comissionTax / 100
    val totalCommission = if (commission < comissionMin) comissionMin else commission
    println("Комиссия составит $totalCommission")
}

fun calculateCommission(cardType: String = "Мир", prevPay: Double = 0.0, sumPay: Double): Double {
    val mounthLimit = 75_000
    val masterCommission = 0.0006
    val masterCommissionAlways = 20.0
    val visaCommission = 0.0075
    val visaCommissionMin = 35.0
    return when (cardType) {
        "Mastercard" -> if (prevPay > mounthLimit) sumPay * masterCommission + masterCommissionAlways else 0.0
        "Visa" -> if ((sumPay * visaCommission) < visaCommissionMin) visaCommissionMin else sumPay * visaCommission
        else -> 0.0
    }
}

fun overPayDetect(payDayTotal: Double, payMonthTotal: Double): Boolean {
    val dayLimit = 150_000
    val monthLimit = 600_000
    return payMonthTotal > monthLimit || payDayTotal > dayLimit
}