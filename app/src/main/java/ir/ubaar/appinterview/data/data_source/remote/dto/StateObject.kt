package ir.ubaar.appinterview.data.data_source.remote.dto

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class StateObject(
    @SerializedName("state_id") val stateId: Int?,
    @SerializedName("state_name") val stateName: String?
)