package ir.ubaar.appinterview.data.data_source.remote.dto

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class Region(
    @SerializedName("city_object") val cityObject: CityObject?,
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("state_object") val stateObject: StateObject?
)