package com.lactare.app.mock

import com.lactare.app.model.PassoComoFunciona

object ComoFuncionaMock {
    val PASSOS = listOf(
        PassoComoFunciona(
            numero = "01",
            titulo = "Cadastro",
            descricao = "Você se cadastra pelo app ou site. Nossa equipe retorna em até 2 dias úteis para orientações iniciais e verificação de elegibilidade.",
            detalhe = "Gratuito. Leva menos de 5 minutos.",
            corHex = 0xFF00458B
        ),
        PassoComoFunciona(
            numero = "02",
            titulo = "Exames",
            descricao = "A Eurofarma agenda e custeia todos os exames necessários para confirmar se você está apta a doar, na sede ou em unidade parceira próxima.",
            detalhe = "100% custeado pela Eurofarma. Sem nenhum custo para você.",
            corHex = 0xFF54B2E3
        ),
        PassoComoFunciona(
            numero = "03",
            titulo = "Kit de coleta",
            descricao = "Aprovada nos exames, você recebe em casa o kit completo com frascos estéreis e um guia detalhado de como extrair, armazenar e conservar o leite.",
            detalhe = "Tudo enviado sem custo. O guia é simples e ilustrado.",
            corHex = 0xFFF25CA2
        ),
        PassoComoFunciona(
            numero = "04",
            titulo = "Análise do leite",
            descricao = "O leite coletado passa por análise microbiológica e pasteurização Holder (62,5°C por 30 minutos) para garantir total segurança.",
            detalhe = "Processo realizado em laboratório certificado.",
            corHex = 0xFF00CCC0
        ),
        PassoComoFunciona(
            numero = "05",
            titulo = "O leite chega ao bebê",
            descricao = "Após aprovado, o leite é distribuído a hospitais públicos da Grande São Paulo para alimentar bebês prematuros e de baixo peso internados em UTIs neonatais.",
            detalhe = "Você pode acompanhar o status pelo Rastreamento.",
            corHex = 0xFFF2B33D
        ),
    )
}
