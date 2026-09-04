package com.lactare.app.ui.screens.pontos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lactare.app.mock.PontosMock
import com.lactare.app.model.PontoColeta
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulCiano
import com.lactare.app.ui.theme.AzulEscuro

@Composable
fun PontosDeColetaScreen(onPontoClick: (Int) -> Unit) {
    var busca by remember { mutableStateOf("") }
    val pontosFiltrados = remember(busca) {
        if (busca.isBlank()) PontosMock.PONTOS
        else PontosMock.PONTOS.filter { it.nome.contains(busca, ignoreCase = true) }
    }

    Scaffold(
        topBar = { LactareTopBar(title = "Pontos de coleta") }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    "Atendemos 30 municípios da Grande São Paulo com coleta em domicílio. " +
                        "Não é preciso levar o leite a lugar nenhum.",
                    style = MaterialTheme.typography.bodyMedium
                )
                OutlinedTextField(
                    value = busca,
                    onValueChange = { busca = it },
                    label = { Text("Buscar município") },
                    leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                )
            }

            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)) {
                items(pontosFiltrados, key = { it.id }) { ponto ->
                    PontoRow(ponto, onClick = { onPontoClick(ponto.id) })
                }
            }
        }
    }
}

@Composable
private fun PontoRow(ponto: PontoColeta, onClick: () -> Unit) {
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
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(Icons.Filled.LocationOn, contentDescription = null, tint = AzulCiano)
            Column(modifier = Modifier.weight(1f)) {
                Text(ponto.nome, style = MaterialTheme.typography.titleMedium, color = AzulEscuro)
                Text("Coleta em domicílio disponível", style = MaterialTheme.typography.bodyMedium)
            }
            Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, modifier = Modifier.padding(4.dp))
        }
    }
}
