fun main(){
    val sumOperation: Double = 150_000.0
    var commission = calculateCommission(cardType = "Mastercard", sumPay = sumOperation)
    println(if (commission != (-1.0)) {
        "Комиссия составит $commission руб."
    } else "Операция невозможна")
}

fun calculateCommission(cardType: String = "Мир", prevPayCurMonth: Double = 0.0, sumPay: Double): Double {
    val mounthLimit = 75_000
    val masterCommission = 0.006
    val masterCommissionAlways = 20.0
    val visaCommission = 0.0075
    val visaCommissionMin = 35.0
    val totalPayInMonth = prevPayCurMonth + sumPay
    val commission: Double = when (cardType) {
        "Mastercard" -> if (totalPayInMonth > mounthLimit) (totalPayInMonth - mounthLimit) * masterCommission + masterCommissionAlways else 0.0
        "Visa" -> if ((sumPay * visaCommission) < visaCommissionMin) visaCommissionMin else sumPay * visaCommission
        else -> 0.0
    }
    return if (overPayDetect(sumPay, totalPayInMonth)) (-1.0) else commission
}

fun overPayDetect(payDayTotal: Double, payMonthTotal: Double): Boolean {
    val dayLimit = 150_000
    val monthLimit = 600_000
    return payMonthTotal > monthLimit || payDayTotal > dayLimit
}