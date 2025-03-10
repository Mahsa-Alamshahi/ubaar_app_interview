package ir.ubaar.appinterview.domain.usecase

import ir.ubaar.appinterview.data.data_source.remote.dto.AddressListDtoItem
import ir.ubaar.appinterview.domain.repository.ApiRepository
import ir.ubaar.appinterview.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAddressListUseCase @Inject constructor(private val apiRepository: ApiRepository) {

    suspend operator fun invoke(): Flow<Resource<List<AddressListDtoItem>>> = flow {

        try {

            emit(Resource.Loading())
            val addressListResponse = apiRepository.getAddressList()
            val addressList = addressListResponse.map {
                it
            }
            emit(Resource.Success(addressList))


        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't get data. ${e.message}"))
        }



    }
}