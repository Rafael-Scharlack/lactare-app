package com.lactare.app.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.runtime.getValue
import com.lactare.app.ui.components.LactareBottomBar
import com.lactare.app.ui.screens.cadastro.CadastroScreen
import com.lactare.app.ui.screens.comofunciona.ComoFuncionaScreen
import com.lactare.app.ui.screens.contato.ContatoScreen
import com.lactare.app.ui.screens.faq.FaqScreen
import com.lactare.app.ui.screens.home.HomeScreen
import com.lactare.app.ui.screens.mais.MaisScreen
import com.lactare.app.ui.screens.pontos.PontoDetalheScreen
import com.lactare.app.ui.screens.pontos.PontosDeColetaScreen
import com.lactare.app.ui.screens.rastreamento.RastreamentoDetalheScreen
import com.lactare.app.ui.screens.rastreamento.RastreamentoScreen

/** Telas que mostram a barra de navegação inferior (as 4 seções principais). */
private val ROTAS_COM_BOTTOM_BAR = setOf(
    LactareDestination.Home.route,
    LactareDestination.Pontos.route,
    LactareDestination.Rastreamento.route,
    LactareDestination.Mais.route,
)

@Composable
fun LactareNavGraph(navController: NavHostController = rememberNavController()) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in ROTAS_COM_BOTTOM_BAR) {
                LactareBottomBar(currentRoute = currentRoute) { item ->
                    navController.navigate(item.destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = LactareDestination.Home.route,
            modifier = Modifier.padding(bottom = padding.calculateBottomPadding())
        ) {
            composable(LactareDestination.Home.route) {
                HomeScreen(
                    onCadastroClick = { navController.navigate(LactareDestination.Cadastro.route) },
                    onComoFuncionaClick = { navController.navigate(LactareDestination.ComoFunciona.route) },
                    onPontosClick = { navController.navigate(LactareDestination.Pontos.route) },
                    onRastreamentoClick = { navController.navigate(LactareDestination.Rastreamento.route) },
                    onFaqClick = { navController.navigate(LactareDestination.Faq.route) },
                )
            }

            composable(LactareDestination.ComoFunciona.route) {
                ComoFuncionaScreen(
                    onBack = { navController.popBackStack() },
                    onCadastroClick = { navController.navigate(LactareDestination.Cadastro.route) }
                )
            }

            composable(LactareDestination.Cadastro.route) {
                CadastroScreen(
                    onBack = { navController.popBackStack() },
                    onVerRastreamento = { codigo ->
                        navController.navigate(LactareDestination.Rastreamento.route)
                    },
                    onVoltarHome = {
                        navController.navigate(LactareDestination.Home.route) {
                            popUpTo(navController.graph.findStartDestination().id) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(LactareDestination.Pontos.route) {
                PontosDeColetaScreen(
                    onPontoClick = { id -> navController.navigate(LactareDestination.PontoDetalhe.createRoute(id)) }
                )
            }

            composable(
                route = LactareDestination.PontoDetalhe.route,
                arguments = listOf(navArgument(LactareDestination.PontoDetalhe.ARG_PONTO_ID) { type = NavType.IntType })
            ) { entry ->
                val pontoId = entry.arguments?.getInt(LactareDestination.PontoDetalhe.ARG_PONTO_ID) ?: -1
                PontoDetalheScreen(pontoId = pontoId, onBack = { navController.popBackStack() })
            }

            composable(LactareDestination.Rastreamento.route) {
                RastreamentoScreen(
                    onBuscar = { codigo -> navController.navigate(LactareDestination.RastreamentoDetalhe.createRoute(codigo)) }
                )
            }

            composable(
                route = LactareDestination.RastreamentoDetalhe.route,
                arguments = listOf(navArgument(LactareDestination.RastreamentoDetalhe.ARG_CODIGO) { type = NavType.StringType })
            ) { entry ->
                val codigo = entry.arguments?.getString(LactareDestination.RastreamentoDetalhe.ARG_CODIGO) ?: ""
                RastreamentoDetalheScreen(codigo = codigo, onBack = { navController.popBackStack() })
            }

            composable(LactareDestination.Mais.route) {
                MaisScreen(
                    onComoFuncionaClick = { navController.navigate(LactareDestination.ComoFunciona.route) },
                    onFaqClick = { navController.navigate(LactareDestination.Faq.route) },
                    onContatoClick = { navController.navigate(LactareDestination.Contato.route) },
                )
            }

            composable(LactareDestination.Faq.route) {
                FaqScreen(onBack = { navController.popBackStack() })
            }

            composable(LactareDestination.Contato.route) {
                ContatoScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}
