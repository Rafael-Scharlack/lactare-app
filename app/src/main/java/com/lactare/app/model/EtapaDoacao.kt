package com.lactare.app.model

/** Uma das 8 etapas fixas da jornada de uma doação (usadas na timeline de rastreamento). */
data class EtapaDoacao(
    val id: Int,
    val titulo: String,
    val descricao: String
)
