package com.lactare.app.mock

import com.lactare.app.model.FaqCategoria
import com.lactare.app.model.FaqPergunta

object FaqMock {
    val CATEGORIAS = listOf(
        FaqCategoria(
            id = "doacao",
            label = "Sobre a doação",
            perguntas = listOf(
                FaqPergunta(
                    "O que é o Lactare?",
                    "O Lactare é o primeiro banco de leite humano privado do Brasil, criado em 2019 e gerenciado pela Eurofarma. Ele coleta leite humano de nutrizes voluntárias e distribui para bebês prematuros e de baixo peso internados em UTIs neonatais de hospitais públicos da Grande São Paulo."
                ),
                FaqPergunta(
                    "Quem pode ser pessoa doadora?",
                    "Qualquer nutriz que esteja amamentando e tenha leite excedente pode se cadastrar. É preciso estar em bom estado de saúde, não fumar, não consumir bebidas alcoólicas habitualmente e não estar em uso de medicamentos incompatíveis com a doação. Nossa equipe faz uma triagem individual após o cadastro."
                ),
                FaqPergunta(
                    "A doação tem algum custo?",
                    "Não. A doação é totalmente gratuita e voluntária. O Lactare fornece os frascos estéreis e o guia de coleta sem nenhum custo para a pessoa doadora."
                ),
                FaqPergunta(
                    "Quanto leite eu preciso ter para poder doar?",
                    "Não há uma quantidade mínima exigida. Qualquer volume excedente é bem-vindo. Mesmo pequenas quantidades fazem diferença para os bebês internados."
                ),
                FaqPergunta(
                    "Posso continuar amamentando meu bebê e também doar?",
                    "Sim! A doação é feita apenas com o leite excedente — aquele que sobra depois que seu bebê se alimentou. A prioridade é sempre a alimentação do seu próprio filho."
                ),
                FaqPergunta(
                    "Por quanto tempo posso ser pessoa doadora?",
                    "Enquanto você estiver amamentando e tiver leite excedente. Não há prazo máximo. Algumas nutrizes doam por alguns meses, outras por mais de um ano."
                ),
            )
        ),
        FaqCategoria(
            id = "coleta",
            label = "Coleta e armazenamento",
            perguntas = listOf(
                FaqPergunta(
                    "Como devo coletar o leite em casa?",
                    "Lave bem as mãos antes de qualquer manipulação. Use os frascos estéreis fornecidos pelo Lactare e siga as instruções do guia de coleta. A ordenha pode ser manual ou com bomba própria, desde que esterilizada conforme orientação."
                ),
                FaqPergunta(
                    "Como armazenar o leite coletado?",
                    "Congele imediatamente após a coleta a -3°C ou menos. Identifique cada frasco com a data e o horário da coleta. Não descongele e recongele. Utilize o freezer, que mantém temperatura mais estável."
                ),
                FaqPergunta(
                    "Por quanto tempo o leite pode ficar congelado antes de ser entregue?",
                    "O leite pode ficar congelado em freezer doméstico por até 15 dias. Quanto mais rápido for entregue ao ponto de coleta, melhor é a qualidade."
                ),
                FaqPergunta(
                    "Posso misturar leites de diferentes ordenhas no mesmo frasco?",
                    "Sim, desde que estejam na mesma temperatura. Se um leite já está congelado, não adicione leite fresco sobre ele. Congele separadamente e deixe que a equipe do banco de leite faça o manuseio correto."
                ),
                FaqPergunta(
                    "Como funciona a retirada do leite?",
                    "Você não precisa se deslocar. Nossa equipe agenda uma visita e vai até a sua residência para retirar os frascos, com a embalagem térmica adequada para o transporte."
                ),
            )
        ),
        FaqCategoria(
            id = "seguranca",
            label = "Segurança e qualidade",
            perguntas = listOf(
                FaqPergunta(
                    "O leite doado é seguro para os bebês?",
                    "Sim. Todo leite recebido passa por triagem microbiológica e pelo processo de pasteurização Holder (aquecimento a 62,5°C por 30 minutos), que elimina vírus e bactérias. Somente o leite aprovado nessa análise é distribuído."
                ),
                FaqPergunta(
                    "Por que é pedido que eu não fume ou beba álcool?",
                    "Substâncias como nicotina, álcool e alguns medicamentos passam para o leite humano e podem ser prejudiciais aos bebês prematuros, que têm organismos muito vulneráveis. A triagem garante que o leite distribuído seja seguro."
                ),
                FaqPergunta(
                    "Meu leite pode ser recusado? O que acontece nesse caso?",
                    "Sim. Se o leite não passar na análise laboratorial, ele é descartado com segurança. Você será informada pela equipe. Em alguns casos, o problema pode ser pontual e a doação pode ser retomada."
                ),
                FaqPergunta(
                    "Posso usar bomba de leite própria para coletar?",
                    "Sim, desde que seja esterilizada corretamente antes de cada uso, conforme as instruções do guia Lactare. Bombas compartilhadas não são recomendadas."
                ),
            )
        ),
        FaqCategoria(
            id = "processo",
            label = "Processo e rastreamento",
            perguntas = listOf(
                FaqPergunta(
                    "O que acontece depois da coleta em domicílio?",
                    "O leite é registrado e transportado ao laboratório do Lactare, onde passa por classificação, triagem microbiológica e pasteurização Holder. Se aprovado, é catalogado e distribuído a hospitais com UTIs neonatais da Grande São Paulo."
                ),
                FaqPergunta(
                    "Posso acompanhar o que acontece com meu leite?",
                    "Sim! Após o cadastro você recebe um código de rastreamento. Na tela de Rastreamento do app você acompanha cada etapa da jornada do seu leite, desde a coleta até a distribuição."
                ),
                FaqPergunta(
                    "Em quanto tempo o leite chega aos bebês?",
                    "O processo completo — da entrega no ponto de coleta à distribuição — leva em média de 7 a 14 dias, dependendo da fila de análise laboratorial e da demanda dos hospitais parceiros."
                ),
                FaqPergunta(
                    "Para quais hospitais o leite é distribuído?",
                    "O leite é distribuído a hospitais públicos da Grande São Paulo que possuem UTIs neonatais e estão cadastrados na rede do Lactare, de acordo com a necessidade clínica dos bebês internados."
                ),
            )
        ),
        FaqCategoria(
            id = "pontos",
            label = "Pontos de coleta",
            perguntas = listOf(
                FaqPergunta(
                    "Preciso levar o leite a algum lugar?",
                    "Não! O Lactare realiza coleta em domicílio — nossa equipe agenda uma visita e vai até a sua casa buscar os frascos. Atendemos 30 municípios da Grande São Paulo."
                ),
                FaqPergunta(
                    "Moro fora da Grande São Paulo. Posso ainda assim doar?",
                    "No momento a coleta em domicílio do Lactare atende 30 municípios da Grande São Paulo. Se você mora em outra região, entre em contato conosco e podemos indicar um banco de leite da rede rBLH Brasil próximo de você."
                ),
                FaqPergunta(
                    "Como funciona o agendamento da coleta?",
                    "Após o seu cadastro e triagem, nossa equipe entra em contato para agendar o melhor horário para ir até a sua residência. O atendimento ocorre de segunda a sexta, das 7h às 22h."
                ),
            )
        ),
    )
}
