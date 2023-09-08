package com.forms.shared.usecase.rankingpoints

import com.forms.shared.usecase.RankingPointsStrategyUseCase
import org.springframework.stereotype.Service

@Service
class RankingPointsStrategyUseCase(
    private val rankingPointsPaidUseCase: RankingPointsPaidUseCase,
    private val rankingPointsAdvertisementUseCase: RankingPointsAdvertisementUseCase,
    private val rankingPointsAnseweredUseCase: RankingPointsAnseweredUseCase
):RankingPointsStrategyUseCase {
    override fun increasePoints(userId:Long, action: String) {
        when (RankingPointsActions.valueOf(action)) {
            RankingPointsActions.ADVERSTMENT -> rankingPointsAdvertisementUseCase.increasePoints(userId)
            RankingPointsActions.PAID -> rankingPointsPaidUseCase.increasePoints(userId)
            RankingPointsActions.ANSEWERED -> rankingPointsAnseweredUseCase.increasePoints(userId)
        }
    }

    override fun decreasePoints(userId: Long, action: String) {
        when (RankingPointsActions.valueOf(action)) {
            RankingPointsActions.PAID -> rankingPointsPaidUseCase.decreasePoints(userId)
            else -> return
        }

    }
}