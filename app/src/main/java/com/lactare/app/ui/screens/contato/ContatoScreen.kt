package com.lactare.app.ui.screens.contato

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MarkEmailRead
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulEscuro
import com.lactare.app.ui.theme.Turquesa

private val ASSUNTOS = listOf("Dúvida sobre doação", "Sou hospital parceiro", "Imprensa", "Outro assunto")

@Composable
fun ContatoScreen(onBack: () -> Unit) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var assunto by remember { mutableStateOf(ASSUNTOS[0]) }
    var mensagem by remember { mutableStateOf("") }
    var enviado by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { LactareTopBar(title = "Contato / Suporte", onBack = onBack) }
    ) { padding ->
        if (!enviado) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
            ) {
                Text(
                    "Tem alguma dúvida ou quer falar com a equipe do Lactare? Preencha o formulário abaixo.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(12.dp))

                AssuntoDropdown(assunto) { assunto = it }
                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = mensagem,
                    onValueChange = { mensagem = it },
                    label = { Text("Mensagem") },
                    minLines = 4,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = { enviado = true },
                    enabled = nome.isNotBlank() && email.isNotBlank() && mensagem.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Enviar mensagem")
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Filled.MarkEmailRead, contentDescription = null, tint = Turquesa, modifier = Modifier.padding(bottom = 16.dp))
                Text("Mensagem enviada!", style = MaterialTheme.typography.headlineMedium, color = AzulEscuro, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Text(
                    "Obrigada pelo contato, $nome. Nossa equipe responde em até 2 dias úteis pelo e-mail $email.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(Modifier.height(24.dp))
                OutlinedButton(
                    onClick = {
                        enviado = false
                        nome = ""; email = ""; mensagem = ""; assunto = ASSUNTOS[0]
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Enviar outra mensagem")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AssuntoDropdown(assunto: String, onChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
        OutlinedTextField(
            value = assunto,
            onValueChange = {},
            readOnly = true,
            label = { Text("Assunto") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            ASSUNTOS.forEach { opcao ->
                DropdownMenuItem(
                    text = { Text(opcao) },
                    onClick = {
                        onChange(opcao)
                        expanded = false
                    }
                )
            }
        }
    }
}
