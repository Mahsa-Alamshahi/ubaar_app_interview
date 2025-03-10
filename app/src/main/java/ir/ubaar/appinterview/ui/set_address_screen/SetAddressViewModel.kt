package ir.ubaar.appinterview.ui.set_address_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ubaar.appinterview.data.data_source.remote.dto.Detail
import ir.ubaar.appinterview.data.data_source.remote.dto.SetAddressRequest
import ir.ubaar.appinterview.domain.usecase.SetAddressUseCase
import ir.ubaar.appinterview.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SetAddressViewModel @Inject constructor(
    private val setAddressUseCase: SetAddressUseCase
) : ViewModel() {


    private var _uiState = MutableStateFlow(SetAddressState())
    val uiState = _uiState.asStateFlow()


    fun setAddress(details: Detail) {
        viewModelScope.launch {
            val addressListResponse = setAddressUseCase(SetAddressRequest(detail = details))
            addressListResponse.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.value = SetAddressState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _uiState.value = SetAddressState(addressRequest = result.data)
                    }

                    is Resource.Error -> {
                        _uiState.value = SetAddressState(
                            error = result.message ?: "An unexpected error occured."
                        )
                    }
                }
            }
        }
    }


}