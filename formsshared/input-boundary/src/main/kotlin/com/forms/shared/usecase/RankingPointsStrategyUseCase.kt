package com.forms.shared.usecase

interface RankingPointsStrategyUseCase {
    fun increasePoints(userId:Long, action: String)
    fun decreasePoints(userId:Long, action: String)
}