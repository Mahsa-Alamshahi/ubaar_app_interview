package ir.ubaar.appinterview.domain.usecase

import ir.ubaar.appinterview.domain.repository.ApiRepository
import javax.inject.Inject

class SetAddressUseCase @Inject constructor(private val apiRepository: ApiRepository) {

    suspend operator fun invoke(){
    }

}