package ua.boring.project.business

import java.math.BigDecimal

class SpendCalculator {

    companion object {

        @JvmStatic
        fun calculateMonthSpend(costList: List<BigDecimal>) : BigDecimal {

            if (costList.isEmpty()) {
                return BigDecimal.ZERO
            }

            return costList[0] - costList[1]
        }
    }

}