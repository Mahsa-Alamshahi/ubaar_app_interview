package ir.ubaar.appinterview.data.data_source.remote

import ir.ubaar.appinterview.data.data_source.remote.dto.AddressBriefDto
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressListDto
import ir.ubaar.appinterview.data.data_source.remote.dto.SetAddressRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/address")
    suspend fun getAddressBrief(@Body request: SetAddressRequest): AddressBriefDto



    @POST("/address")
    suspend fun getAddressList(): AddressListDto

}