package ir.ubaar.appinterview.ui.navigation


sealed class Screen(val route: String) {

    object SetAddress: Screen(route = "set_address_screen")
    object AddressList: Screen(route = "address_list_screen")
}