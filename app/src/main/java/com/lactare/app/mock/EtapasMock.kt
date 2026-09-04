package com.lactare.app.mock

import com.lactare.app.model.EtapaDoacao

object EtapasMock {
    val ETAPAS = listOf(
        EtapaDoacao(1, "Cadastro confirmado", "Seu cadastro foi recebido e nossa equipe foi notificada."),
        EtapaDoacao(2, "Exames agendados", "A Eurofarma agendou seus exames de aptidão. Você receberá o contato em breve."),
        EtapaDoacao(3, "Aptidão confirmada", "Seus exames foram realizados e você está apta para doar. Parabéns!"),
        EtapaDoacao(4, "Kit de coleta enviado", "Os frascos estéreis e o guia de coleta foram despachados para o seu endereço."),
        EtapaDoacao(5, "Leite coletado", "A coleta foi realizada com sucesso seguindo as orientações de higiene."),
        EtapaDoacao(6, "Em análise laboratorial", "O leite está passando por triagem microbiológica e pasteurização Holder (62,5°C / 30 min)."),
        EtapaDoacao(7, "Aprovado e catalogado", "O leite foi aprovado, catalogado e está pronto para distribuição."),
        EtapaDoacao(8, "Distribuído para UTI Neonatal", "Seu leite chegou a um bebê internado em UTI Neonatal. Muito obrigada!"),
    )
}
