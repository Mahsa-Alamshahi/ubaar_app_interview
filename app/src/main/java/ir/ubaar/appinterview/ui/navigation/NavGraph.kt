package ir.ubaar.appinterview.ui.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.ubaar.appinterview.ui.address_list_screen.AddressListScreenRoute
import ir.ubaar.appinterview.ui.set_address_screen.SetAddressScreenRoute


@Composable
fun NavGraph() {
    val navController = rememberNavController()

    val context = LocalContext.current as Activity

    NavHost(navController, startDestination = Screen.SetAddress.route) {
        setAddressRoute(navController, context)
        addressListRoute(navController)
    }
}



fun NavGraphBuilder.setAddressRoute(navController: NavController, context: Activity) {
    composable(route = Screen.SetAddress.route) {
        SetAddressScreenRoute(
            onBackClick = {
                context.finish()
            }
        ) {
            navController.navigate(Screen.AddressList.route)
        }
    }
}



fun NavGraphBuilder.addressListRoute(navController: NavController) {
    composable(route = Screen.AddressList.route) {
        AddressListScreenRoute(onBackClick = {
            navController.popBackStack()
        })
    }
}

