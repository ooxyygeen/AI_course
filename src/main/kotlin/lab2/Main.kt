package lab2

import java.util.*

fun lowSumHighRiskStrategy(longTerm: Boolean): String {
    if (longTerm) {
        return Investments.STARTUP.str
    }
    return Investments.CRYPTO.str
}

fun lowSumLowRiskLongTermStrategy(liquidity: Boolean): String {
    if (liquidity) {
        return Investments.SECURITIES.str
    }
    return Investments.ESTATE.str
}

fun lowSumLowRiskShortTermStrategy(liquidity: Boolean): String {
    if (liquidity) {
        return "${Investments.CURRENCY.str}, ${Investments.DEPOSIT.str}, ${Investments.BONDS.str}"
    }
    return "${Investments.JEWELRY.str}, ${Investments.ANTIQUES.str}"
}

fun lowSumLowRiskStrategy(longTerm: Boolean, liquidity: Boolean): String {
    if (longTerm) {
        return lowSumLowRiskLongTermStrategy(liquidity)
    }
    return lowSumLowRiskShortTermStrategy(liquidity)
}

fun lowSumBestStrategy(highRisk: Boolean, longTerm: Boolean, liquidity: Boolean): String {
    if (highRisk) {
        return lowSumHighRiskStrategy(longTerm)
    }
    return lowSumLowRiskStrategy(longTerm, liquidity)
}

fun bigSumBestStrategy(highRisk: Boolean, longTerm: Boolean, liquidity: Boolean): String {
    if (highRisk) {
        return bigSumHighRiskStrategy(longTerm)
    }
    return bigSumLowRiskStrategy(longTerm, liquidity)
}

fun bigSumLowRiskStrategy(longTerm: Boolean, liquidity: Boolean): String {
    if (longTerm) {
        return bigSumLowRiskLongTermStrategy(liquidity)
    }
    return bigSumLowRiskShortTermStrategy(liquidity)
}

fun bigSumLowRiskShortTermStrategy(liquidity: Boolean): String {
    if (liquidity) {
        return "${Investments.DEPOSIT.str}, ${Investments.BONDS.str}"
    }
    return "${Investments.INVESTFUND.str} з низьким ризиком"
}

fun bigSumLowRiskLongTermStrategy(liquidity: Boolean): String {
    if (liquidity) {
        return Investments.INVESTFUND.str
    }
    return "${Investments.ESTATE.str}, ${Investments.P2P.str}"
}

fun bigSumHighRiskStrategy(longTerm: Boolean): String {
    if (longTerm) {
        return "${Investments.VENTURE.str}, ${Investments.STARTUP.str}"
    }
    return "${Investments.CRYPTO.str} високоризиковані, ${Investments.STOCKS.str}"
}

fun makeDecision(sum: Int, highRisk: Boolean, longTerm: Boolean, liquidity: Boolean): String {
    val midSum = 50_000

    if (sum < midSum) {
        return lowSumBestStrategy(highRisk, longTerm, liquidity)
    }
    return bigSumBestStrategy(highRisk, longTerm, liquidity)
}

fun main() {
    val reader = Scanner(System.`in`)

    println("Введіть суму для інвестицій:")
    val sum: Int = reader.nextInt()

    println("Чи прийнятний ризик?(1 - Так, 2 - Ні)")
    val risk: Int = reader.nextInt()

    println("На який термін інвестиції?(1 - Довгий, 2 - Короткий)")
    val term: Int = reader.nextInt()

    println("Чи важлива ліквідність?(1 - Так, 2 - Ні)")
    val liq: Int = reader.nextInt()

    println("Рекомендовані стратегії для інвестиції:")
    println(makeDecision(sum, risk == 1, term == 1, liq == 1))
}
