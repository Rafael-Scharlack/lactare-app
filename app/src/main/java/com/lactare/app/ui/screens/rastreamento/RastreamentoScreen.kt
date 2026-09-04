package com.lactare.app.ui.screens.rastreamento

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lactare.app.mock.DoacoesMock
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulEscuro
import com.lactare.app.ui.theme.Rosa

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RastreamentoScreen(onBuscar: (String) -> Unit) {
    var codigo by remember { mutableStateOf("") }
    var erro by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = { LactareTopBar(title = "Rastreamento da doação") }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {
            Text(
                "Digite o código de rastreamento que você recebeu no cadastro para acompanhar " +
                    "a jornada do seu leite até chegar a um bebê.",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = codigo,
                onValueChange = {
                    codigo = it.uppercase()
                    erro = null
                },
                label = { Text("Código de rastreamento") },
                placeholder = { Text("Ex: LAC001") },
                isError = erro != null,
                supportingText = { if (erro != null) Text(erro!!) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    if (DoacoesMock.DOACOES.containsKey(codigo.trim())) {
                        onBuscar(codigo.trim())
                    } else {
                        erro = "Código não encontrado. Confira e tente novamente."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Buscar")
            }

            Spacer(Modifier.height(32.dp))
            Text(
                "Experimente com um destes códigos de demonstração:",
                style = MaterialTheme.typography.titleMedium,
                color = AzulEscuro,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(12.dp))
            FlowRow {
                DoacoesMock.DOACOES.keys.forEach { c ->
                    AssistChip(
                        onClick = { onBuscar(c) },
                        label = { Text(c) },
                        modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }
    }
}
