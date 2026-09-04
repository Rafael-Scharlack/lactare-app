package com.lactare.app.navigation

/** Rotas de navegação do app. Centralizadas aqui para evitar strings soltas nas telas. */
sealed class LactareDestination(val route: String) {
    data object Home : LactareDestination("home")
    data object ComoFunciona : LactareDestination("como_funciona")
    data object Cadastro : LactareDestination("cadastro")

    data object Pontos : LactareDestination("pontos")
    data object PontoDetalhe : LactareDestination("pontos/{pontoId}") {
        const val ARG_PONTO_ID = "pontoId"
        fun createRoute(pontoId: Int) = "pontos/$pontoId"
    }

    data object Rastreamento : LactareDestination("rastreamento")
    data object RastreamentoDetalhe : LactareDestination("rastreamento/{codigo}") {
        const val ARG_CODIGO = "codigo"
        fun createRoute(codigo: String) = "rastreamento/$codigo"
    }

    data object Mais : LactareDestination("mais")
    data object Faq : LactareDestination("faq")
    data object Contato : LactareDestination("contato")
}

/** Itens exibidos na barra de navegação inferior. */
enum class BottomNavItem(val destination: LactareDestination, val label: String) {
    HOME(LactareDestination.Home, "Início"),
    PONTOS(LactareDestination.Pontos, "Pontos"),
    RASTREAMENTO(LactareDestination.Rastreamento, "Rastreio"),
    MAIS(LactareDestination.Mais, "Mais"),
}
