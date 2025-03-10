package ir.ubaar.appinterview.ui.address_list_screen

import androidx.compose.runtime.Stable
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressListDtoItem


@Stable
data class AddressListState(
    val isLoading: Boolean = false,
    val addressList: List<AddressListDtoItem> = emptyList(),
    val error: String = ""
)
