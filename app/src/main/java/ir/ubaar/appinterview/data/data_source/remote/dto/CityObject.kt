package ir.ubaar.appinterview.data.data_source.remote.dto

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName


@Stable
data class CityObject(
    @SerializedName("city_id") val cityId: Int?,
    @SerializedName("city_name") val cityName: String?
)