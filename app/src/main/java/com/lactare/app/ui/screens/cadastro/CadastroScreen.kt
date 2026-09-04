package com.lactare.app.ui.screens.cadastro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import com.lactare.app.mock.PontosMock
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulEscuro
import com.lactare.app.ui.theme.Turquesa
import kotlin.random.Random

private val OPCOES_TEMPO_AMAMENTANDO = listOf("Até 3 meses", "3 a 6 meses", "6 a 12 meses", "Mais de 12 meses")
private val OPCOES_LEITE_EXCEDENTE = listOf("Sim, bastante", "Sim, um pouco", "Não tenho certeza")

@Composable
fun CadastroScreen(
    onBack: () -> Unit,
    onVerRastreamento: (String) -> Unit,
    onVoltarHome: () -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf(PontosMock.PONTOS.first().nome) }
    var tempoAmamentando by remember { mutableStateOf(OPCOES_TEMPO_AMAMENTANDO[0]) }
    var leiteExcedente by remember { mutableStateOf(OPCOES_LEITE_EXCEDENTE[0]) }
    var protocolo by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = { LactareTopBar(title = "Cadastre-se como doadora", onBack = onBack) }
    ) { padding ->
        if (protocolo == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
            ) {
                Text(
                    "Preencha seus dados de interesse. Nossa equipe entra em contato em até 2 dias úteis.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome completo") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = telefone,
                    onValueChange = { telefone = it },
                    label = { Text("Telefone / WhatsApp") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(12.dp))

                CidadeDropdown(cidade) { cidade = it }
                Spacer(Modifier.height(20.dp))

                Text("Há quanto tempo está amamentando?", style = MaterialTheme.typography.titleMedium, color = AzulEscuro)
                OPCOES_TEMPO_AMAMENTANDO.forEach { opcao ->
                    RadioRow(opcao, tempoAmamentando == opcao) { tempoAmamentando = opcao }
                }
                Spacer(Modifier.height(16.dp))

                Text("Você tem leite excedente?", style = MaterialTheme.typography.titleMedium, color = AzulEscuro)
                OPCOES_LEITE_EXCEDENTE.forEach { opcao ->
                    RadioRow(opcao, leiteExcedente == opcao) { leiteExcedente = opcao }
                }
                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = {
                        // Mock: gera um protocolo de doação como se o cadastro tivesse sido enviado
                        protocolo = "LAC" + (1000 + Random.nextInt(9000)).toString()
                    },
                    enabled = nome.isNotBlank() && telefone.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Enviar cadastro")
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
                Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Turquesa, modifier = Modifier.padding(bottom = 16.dp))
                Text("Cadastro recebido!", style = MaterialTheme.typography.headlineMedium, color = AzulEscuro, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Text(
                    "Obrigada, $nome. Seu protocolo de acompanhamento é:",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(protocolo ?: "", style = MaterialTheme.typography.headlineMedium, color = Turquesa, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(24.dp))
                Text(
                    "Use este código a qualquer momento na tela de Rastreamento para acompanhar sua doação " +
                        "(neste MVP, use um dos códigos de demonstração para ver o fluxo completo).",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.height(24.dp))
                Button(onClick = { onVerRastreamento(protocolo!!) }, modifier = Modifier.fillMaxWidth()) {
                    Text("Ir para Rastreamento")
                }
                Spacer(Modifier.height(12.dp))
                OutlinedButton(onClick = onVoltarHome, modifier = Modifier.fillMaxWidth()) {
                    Text("Voltar para o início")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CidadeDropdown(cidade: String, onCidadeChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
        OutlinedTextField(
            value = cidade,
            onValueChange = {},
            readOnly = true,
            label = { Text("Cidade") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            PontosMock.PONTOS.forEach { ponto ->
                DropdownMenuItem(
                    text = { Text(ponto.nome) },
                    onClick = {
                        onCidadeChange(ponto.nome)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun RadioRow(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterStart),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(label, style = MaterialTheme.typography.bodyMedium)
    }
}
