package com.forms.shared.usecase.rankingpoints

import com.forms.shared.repository.UserRepository
import com.forms.shared.usecase.RankingPointsUseCase
import org.springframework.stereotype.Service

@Service
abstract class RankingPointsAbstractUseCase(
    private val userRepository: UserRepository
) : RankingPointsUseCase{
    abstract override fun increasePoints(userId: Long)

    override fun decreasePoints(userId: Long) {
        val user = userRepository.findById(userId)
        user?.let { userRepository.save(it.copy(ranking = user.ranking!! - 1L)) }
    }
}