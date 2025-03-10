package ir.ubaar.appinterview.ui.address_list_screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ubaar.appinterview.domain.usecase.GetAddressListUseCase
import ir.ubaar.appinterview.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddressListViewModel @Inject constructor(
    private val getAddressListUseCase: GetAddressListUseCase
) : ViewModel() {



    private var _uiState = MutableStateFlow(AddressListState())
    val uiState = _uiState.asStateFlow()



    fun getAddressList() {
        viewModelScope.launch {
            getAddressListUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.value = AddressListState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _uiState.value = AddressListState(addressList = result.data ?: emptyList())
                    }

                    is Resource.Error -> {
                        _uiState.value = AddressListState(
                            error = result.message ?: "An unexpected error occured."
                        )
                    }
                }
            }
        }
    }


}