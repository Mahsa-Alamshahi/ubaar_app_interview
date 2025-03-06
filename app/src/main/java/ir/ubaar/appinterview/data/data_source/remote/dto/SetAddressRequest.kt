package ir.ubaar.appinterview.data.data_source.remote.dto

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class SetAddressRequest(
  @SerializedName("detail") val detail: Detail?
)