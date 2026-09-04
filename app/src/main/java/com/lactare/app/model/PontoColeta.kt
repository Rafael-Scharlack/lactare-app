package com.lactare.app.model

/**
 * Município atendido pelo Lactare com coleta de leite em domicílio.
 * Espelha os 30 municípios da Grande São Paulo do portal web (src/data/pontos.js).
 */
data class PontoColeta(
    val id: Int,
    val nome: String,
    val latitude: Double,
    val longitude: Double
)
