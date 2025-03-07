package ir.ubaar.appinterview.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.ubaar.appinterview.ui.set_address_screen.SetAddressScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.SetAddressScreen.route) {
        setAddressRoute(navController)
        addressListRoute(navController)
    }

}


fun NavGraphBuilder.setAddressRoute(navController: NavController) {
    composable(
        route = Screen.SetAddressScreen.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(700)
            )
        },
    ) {
        SetAddressScreen()
    }
}


fun NavGraphBuilder.addressListRoute(navController: NavController) {
    composable(
        route = Screen.AddressListScreen.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(700)
            )
        },
    ) {
    }
}
