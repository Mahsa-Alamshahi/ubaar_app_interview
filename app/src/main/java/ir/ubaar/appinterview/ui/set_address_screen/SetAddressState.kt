package ir.ubaar.appinterview.ui.set_address_screen

import androidx.compose.runtime.Stable
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressBriefDto


@Stable
data class SetAddressState(
    val isLoading: Boolean = false,
    val addressRequest: AddressBriefDto? = null,
    val error: String = ""
)
