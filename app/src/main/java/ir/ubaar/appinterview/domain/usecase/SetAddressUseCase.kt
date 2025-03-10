package ir.ubaar.appinterview.domain.usecase

import ir.ubaar.appinterview.data.data_source.remote.dto.AddressBriefDto
import ir.ubaar.appinterview.data.data_source.remote.dto.SetAddressRequest
import ir.ubaar.appinterview.domain.repository.ApiRepository
import ir.ubaar.appinterview.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SetAddressUseCase @Inject constructor(private val apiRepository: ApiRepository) {

    suspend operator fun invoke(request: SetAddressRequest)
            : Flow<Resource<AddressBriefDto>> = flow {

        try {

            emit(Resource.Loading())
            val setAddressResponse = apiRepository.setAddress(request)
            emit(Resource.Success(setAddressResponse))


        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't get data. ${e.message}"))
        }


    }

}