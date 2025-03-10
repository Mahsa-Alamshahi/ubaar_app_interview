package ir.ubaar.appinterview.data.repository

import com.orhanobut.logger.Logger
import ir.ubaar.appinterview.data.data_source.remote.ApiService
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressBriefDto
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressListDto
import ir.ubaar.appinterview.data.data_source.remote.dto.SetAddressRequest
import ir.ubaar.appinterview.domain.repository.ApiRepository
import javax.inject.Inject



class ApiRepositoryImpl @Inject constructor(private val apiService: ApiService) : ApiRepository {


    override suspend fun setAddress(
        request: SetAddressRequest
    ): AddressBriefDto =
        apiService.getAddressBrief(request)


    override suspend fun getAddressList(): AddressListDto =
        apiService.getAddressList()


}