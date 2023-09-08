package com.forms.shared.usecase.rankingpoints

import com.forms.shared.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class RankingPointsAnseweredUseCase(
    private val userRepository: UserRepository
) : RankingPointsAbstractUseCase(userRepository){
    override fun increasePoints(userId: Long) {
        val user = userRepository.findById(userId)
        user?.let { userRepository.save(it.copy(ranking = user.ranking!! + 2L)) }
    }
}