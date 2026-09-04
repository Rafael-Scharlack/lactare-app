package com.lactare.app.mock

import com.lactare.app.model.Doacao

/** Doações mockadas, localizáveis por código na tela de Rastreamento. */
object DoacoesMock {
    val DOACOES: Map<String, Doacao> = mapOf(
        "LAC001" to Doacao(
            codigo = "LAC001",
            doadora = "Ana Paula S.",
            volume = "420 ml",
            hospital = "Hospital das Clínicas — FMUSP, São Paulo/SP",
            etapaAtual = 8,
            datas = listOf(
                "12/03/2025 09:14", "13/03/2025 11:30", "15/03/2025 14:22", "16/03/2025 08:50",
                "17/03/2025 10:05", "18/03/2025 07:40", "19/03/2025 15:18", "20/03/2025 09:00"
            )
        ),
        "LAC042" to Doacao(
            codigo = "LAC042",
            doadora = "Carla M.",
            volume = "280 ml",
            hospital = null,
            etapaAtual = 6,
            datas = listOf(
                "18/04/2025 10:00", "19/04/2025 14:15", "21/04/2025 09:30",
                "22/04/2025 11:00", "23/04/2025 08:45", "24/04/2025 07:30"
            )
        ),
        "LAC099" to Doacao(
            codigo = "LAC099",
            doadora = "Fernanda L.",
            volume = "350 ml",
            hospital = null,
            etapaAtual = 3,
            datas = listOf("25/04/2025 09:20", "26/04/2025 16:00", "28/04/2025 10:10")
        ),
        "LAC2025" to Doacao(
            codigo = "LAC2025",
            doadora = "Renata T.",
            volume = "510 ml",
            hospital = null,
            etapaAtual = 7,
            datas = listOf(
                "10/04/2025 08:00", "11/04/2025 13:20", "13/04/2025 11:45", "14/04/2025 09:10",
                "15/04/2025 14:30", "16/04/2025 07:55", "17/04/2025 10:20"
            )
        ),
    )
}
