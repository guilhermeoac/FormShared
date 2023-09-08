package com.forms.shared.usecase

interface RankingPointsUseCase {
    fun increasePoints(userId: Long)
    fun decreasePoints(userId: Long)
}