fun main(){
    val comissionTax = 0.75
    val comissionMin = 35
    val amount = 3_000
    val commission = amount * comissionTax / 100
    val totalCommission = if (commission < comissionMin) comissionMin else commission
    println("Комиссия составит $totalCommission")
}