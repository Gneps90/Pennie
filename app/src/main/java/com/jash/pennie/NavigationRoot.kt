package com.jash.pennie

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jash.feature_auth.auth_presentation.intro.IntroScreenRoot
import com.jash.feature_auth.auth_presentation.login.LoginScreenRoot
import com.jash.feature_auth.auth_presentation.register.RegisterScreenRoot
import com.jash.feature_overview.presentation.OverviewScreen
import com.jash.feature_overview.presentation.OverviewViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean,
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "overview" else "auth"
    ) {
        authGraph(navController)
        composable("overview") {
            val viewModel: OverviewViewModel = koinViewModel()
            OverviewScreen(state = viewModel.state)
        }
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro",
        route = "auth"
    ) {
        composable(route = "intro") {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate("register")
                },
                onSignInClick = {
                    navController.navigate("login")
                }
            )
        }
        composable(route = "register") {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate("login") {
                        popUpTo("register") {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate("overview") {
                        popUpTo("auth") { inclusive = true }
                    }
                }
            )
        }
        composable("login") {
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigate("overview") {
                        popUpTo("auth") { inclusive = true }
                    }
                },
                onSignUpClick = {
                    navController.navigate("register") {
                        popUpTo("login") {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}