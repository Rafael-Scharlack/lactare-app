package com.lactare.app.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lactare.app.ui.components.SectionWave
import com.lactare.app.ui.components.StatCard
import com.lactare.app.ui.theme.AzulCiano
import com.lactare.app.ui.theme.AzulEscuro
import com.lactare.app.ui.theme.Rosa
import com.lactare.app.ui.theme.Turquesa

@Composable
fun HomeScreen(
    onCadastroClick: () -> Unit,
    onComoFuncionaClick: () -> Unit,
    onPontosClick: () -> Unit,
    onRastreamentoClick: () -> Unit,
    onFaqClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        // Hero
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                "Lactare",
                style = MaterialTheme.typography.headlineLarge,
                color = AzulEscuro,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Banco de Leite Humano",
                style = MaterialTheme.typography.titleMedium,
                color = AzulCiano
            )
            Spacer(Modifier.height(12.dp))
            Text(
                "Conheça o Lactare e saiba como ajudar outros bebês a terem um futuro com mais saúde. " +
                    "O leite excedente de pessoas doadoras chega a recém-nascidos internados em UTIs " +
                    "neonatais de hospitais públicos da Grande São Paulo.",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = onCadastroClick) {
                Text("Quero ser doadora")
            }
        }

        SectionWave(color = AzulCiano.copy(alpha = 0.15f))

        // Impacto (dados mockados)
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
            Text(
                "Nosso impacto",
                style = MaterialTheme.typography.titleLarge,
                color = AzulEscuro,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(12.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                item { StatCard(value = "5.200+", label = "doações recebidas", accentColor = AzulEscuro) }
                item { StatCard(value = "30", label = "municípios atendidos", accentColor = AzulCiano) }
                item { StatCard(value = "1.800+", label = "bebês alimentados", accentColor = Rosa) }
                item { StatCard(value = "100%", label = "gratuito para doadoras", accentColor = Turquesa) }
            }
        }

        // Links rápidos
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)) {
            Text(
                "Explore o portal",
                style = MaterialTheme.typography.titleLarge,
                color = AzulEscuro,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(12.dp))

            QuickLinkRow(Icons.Filled.MenuBook, "Como funciona", "Veja o passo a passo da doação", onComoFuncionaClick)
            QuickLinkRow(Icons.Filled.LocationOn, "Pontos de coleta", "Municípios atendidos na Grande SP", onPontosClick)
            QuickLinkRow(Icons.Filled.Timeline, "Rastreamento", "Acompanhe sua doação em tempo real", onRastreamentoClick)
            QuickLinkRow(Icons.Filled.HelpOutline, "Perguntas frequentes", "Tire suas dúvidas sobre a doação", onFaqClick)
        }

        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
            Text(
                "O Lactare é gerenciado pela Eurofarma e é o primeiro banco de leite humano " +
                    "privado criado por uma farmacêutica no Brasil, desde 2019.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun QuickLinkRow(icon: ImageVector, title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(icon, contentDescription = null, tint = AzulEscuro)
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(subtitle, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
