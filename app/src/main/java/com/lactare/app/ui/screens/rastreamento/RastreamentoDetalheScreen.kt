package com.lactare.app.ui.screens.rastreamento

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lactare.app.mock.DoacoesMock
import com.lactare.app.mock.EtapasMock
import com.lactare.app.model.EtapaDoacao
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulCiano
import com.lactare.app.ui.theme.AzulEscuro
import com.lactare.app.ui.theme.CinzaBorda
import com.lactare.app.ui.theme.Turquesa

@Composable
fun RastreamentoDetalheScreen(codigo: String, onBack: () -> Unit) {
    val doacao = remember(codigo) { DoacoesMock.DOACOES[codigo] }

    Scaffold(
        topBar = { LactareTopBar(title = "Doação $codigo", onBack = onBack) }
    ) { padding ->
        if (doacao == null) {
            Column(modifier = Modifier.fillMaxSize().padding(padding).padding(20.dp)) {
                Text("Doação não encontrada.", style = MaterialTheme.typography.bodyLarge)
            }
            return@Scaffold
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(doacao.doadora, style = MaterialTheme.typography.titleLarge, color = AzulEscuro, fontWeight = FontWeight.Bold)
                        Text("Volume doado: ${doacao.volume}", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            "Hospital destino: ${doacao.hospital ?: "a definir após aprovação"}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(Modifier.height(12.dp))
                        LinearProgressIndicator(
                            progress = { doacao.etapaAtual / EtapasMock.ETAPAS.size.toFloat() },
                            modifier = Modifier.fillMaxWidth(),
                            color = Turquesa
                        )
                        Text(
                            "Etapa ${doacao.etapaAtual} de ${EtapasMock.ETAPAS.size}",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            items(EtapasMock.ETAPAS) { etapa ->
                val concluida = etapa.id <= doacao.etapaAtual
                val data = doacao.datas.getOrNull(etapa.id - 1)
                EtapaRow(etapa, concluida, data)
            }

            item { Spacer(Modifier.height(24.dp)) }
        }
    }
}

@Composable
private fun EtapaRow(etapa: EtapaDoacao, concluida: Boolean, data: String?) {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(if (concluida) Turquesa else CinzaBorda),
            contentAlignment = Alignment.Center
        ) {
            if (concluida) {
                Icon(Icons.Filled.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
            }
        }
        Column(modifier = Modifier.padding(start = 12.dp).weight(1f)) {
            Text(
                etapa.titulo,
                style = MaterialTheme.typography.titleMedium,
                color = if (concluida) AzulEscuro else Color.Gray
            )
            Text(
                etapa.descricao,
                style = MaterialTheme.typography.bodyMedium,
                color = if (concluida) MaterialTheme.colorScheme.onSurface else Color.Gray
            )
            if (data != null) {
                Text(data, style = MaterialTheme.typography.labelLarge, color = AzulCiano, modifier = Modifier.padding(top = 2.dp))
            }
        }
    }
}
