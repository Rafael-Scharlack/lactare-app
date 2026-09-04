package com.lactare.app.model

data class FaqPergunta(
    val pergunta: String,
    val resposta: String
)

data class FaqCategoria(
    val id: String,
    val label: String,
    val perguntas: List<FaqPergunta>
)
