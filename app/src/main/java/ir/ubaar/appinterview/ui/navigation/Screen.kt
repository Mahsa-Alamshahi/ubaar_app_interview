package ir.ubaar.appinterview.ui.navigation

import okhttp3.Route

sealed class Screen(val route: String) {

    object SetAddressScreen: Screen(route = "set_address_screen")
    object AddressListScreen: Screen(route = "address_list_screen")
}