package com.lactare.app.ui.screens.mais

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulEscuro

@Composable
fun MaisScreen(
    onComoFuncionaClick: () -> Unit,
    onFaqClick: () -> Unit,
    onContatoClick: () -> Unit,
) {
    Scaffold(
        topBar = { LactareTopBar(title = "Mais") }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(20.dp)
        ) {
            MenuRow(Icons.Filled.MenuBook, "Como funciona", "Passo a passo da doação", onComoFuncionaClick)
            MenuRow(Icons.Filled.HelpOutline, "Perguntas frequentes", "Dúvidas sobre doação de leite humano", onFaqClick)
            MenuRow(Icons.Filled.Mail, "Contato / Suporte", "Fale com a equipe do Lactare", onContatoClick)

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "Lactare é gerenciado pela Eurofarma, empresa farmacêutica brasileira.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun MenuRow(icon: ImageVector, title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(icon, contentDescription = null, tint = AzulEscuro)
            Column(modifier = Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(subtitle, style = MaterialTheme.typography.bodyMedium)
            }
            Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, modifier = Modifier.padding(4.dp))
        }
    }
}
