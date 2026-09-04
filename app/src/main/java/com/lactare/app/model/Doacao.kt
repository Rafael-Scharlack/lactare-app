package com.lactare.app.model

/** Registro mockado de uma doação específica, localizável pelo código de rastreamento. */
data class Doacao(
    val codigo: String,
    val doadora: String,
    val volume: String,
    val hospital: String?,
    val etapaAtual: Int,
    val datas: List<String>
)
