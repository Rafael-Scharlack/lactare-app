package com.lactare.app.ui.screens.pontos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lactare.app.mock.PontosMock
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulCiano
import com.lactare.app.ui.theme.AzulEscuro
import kotlinx.coroutines.launch

@Composable
fun PontoDetalheScreen(pontoId: Int, onBack: () -> Unit) {
    val ponto = remember(pontoId) { PontosMock.PONTOS.firstOrNull { it.id == pontoId } }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { LactareTopBar(title = ponto?.nome ?: "Ponto de coleta", onBack = onBack) },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {
            if (ponto == null) {
                Text("Município não encontrado.", style = MaterialTheme.typography.bodyLarge)
                return@Column
            }

            Text(ponto.nome, style = MaterialTheme.typography.headlineMedium, color = AzulEscuro, fontWeight = FontWeight.Bold)
            Text("Grande São Paulo", style = MaterialTheme.typography.titleMedium, color = AzulCiano)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    InfoLine("Tipo de atendimento", "Coleta em domicílio")
                    InfoLine("Horário", "Segunda a sexta, das 7h às 22h")
                    InfoLine("Custo", "Gratuito")
                    InfoLine(
                        "Coordenadas de referência",
                        "%.4f, %.4f".format(ponto.latitude, ponto.longitude)
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Solicitação de agendamento registrada para ${ponto.nome} (demonstração).")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Text("Solicitar agendamento")
            }
        }
    }
}

@Composable
private fun InfoLine(label: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(label, style = MaterialTheme.typography.labelLarge, color = AzulEscuro)
        Text(value, style = MaterialTheme.typography.bodyMedium)
    }
}
