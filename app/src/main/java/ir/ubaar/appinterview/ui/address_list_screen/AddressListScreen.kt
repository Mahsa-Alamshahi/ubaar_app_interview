package ir.ubaar.appinterview.ui.address_list_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.ubaar.appinterview.R
import ir.ubaar.appinterview.ui.component.EmptyView
import ir.ubaar.appinterview.ui.component.ErrorView
import ir.ubaar.appinterview.ui.component.Loading
import ir.ubaar.appinterview.ui.component.TopAppBarComponent


@Composable
fun AddressListScreenRoute(onBackClick: () -> Unit) {

    val viewModel: AddressListViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.getAddressList()
    }

    val uiState by viewModel.uiState.collectAsState()


    AddressListScreen(
        addressListState = uiState,
        onBackClick = onBackClick,
        getAddressList = { viewModel.getAddressList() }
    )
}


@Composable
fun AddressListScreen(
    addressListState: AddressListState,
    onBackClick: () -> Unit,
    getAddressList: () -> Unit,
) {


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        TopAppBarComponent(topAppBarTitle = stringResource(R.string.address_list), onBackClick) { innerPadding ->


            if (addressListState.isLoading) {
                Loading()
            } else if (addressListState.error.isNotBlank()) {
                ErrorView(message = addressListState.error) {
                    getAddressList()
                }
            } else if (addressListState.addressList.isEmpty()) {
                EmptyView { getAddressList() }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp)
                ) {

                    items(addressListState.addressList) { item ->
                        AddressListItems(item)
                    }
                }
            }
        }
    }
}
