package com.lactare.app.model

/** Um dos 5 passos do processo de doação, exibidos na tela "Como Funciona". */
data class PassoComoFunciona(
    val numero: String,
    val titulo: String,
    val descricao: String,
    val detalhe: String,
    val corHex: Long
)
