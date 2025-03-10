package ir.ubaar.appinterview.data.data_source.remote.dto

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName


@Stable
data class AddressListDtoItem(

    @SerializedName("address") val address: String?,
    @SerializedName("address_id") val addressId: String?,
    @SerializedName("coordinate_mobile") val coordinateMobile: String?,
    @SerializedName("coordinate_phone_number") val coordinatePhoneNumber: String?,
    @SerializedName("first_name") val firstName: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("last_name") val lastName: String?,
    @SerializedName("lat") val latitude: Double?,
    @SerializedName("lng") val longitude: Double?,
    @SerializedName("region") val region: Region?
)