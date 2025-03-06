package ir.ubaar.appinterview.domain.repository

import ir.ubaar.appinterview.data.data_source.remote.ApiService
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressBriefDto
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressListDto
import ir.ubaar.appinterview.data.data_source.remote.dto.SetAddressRequest

interface ApiRepository {


    suspend fun getAddressBrief(request: SetAddressRequest): AddressBriefDto


    suspend fun getAddressList(): AddressListDto

}