package com.lactare.app.ui.screens.comofunciona

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lactare.app.mock.ComoFuncionaMock
import com.lactare.app.model.PassoComoFunciona
import com.lactare.app.ui.components.LactareTopBar
import com.lactare.app.ui.theme.AzulEscuro

@Composable
fun ComoFuncionaScreen(
    onBack: () -> Unit,
    onCadastroClick: () -> Unit
) {
    Scaffold(
        topBar = { LactareTopBar(title = "Como funciona", onBack = onBack) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            item {
                Text(
                    "Do seu leite excedente até chegar a um bebê em UTI Neonatal — em 5 passos.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            items(ComoFuncionaMock.PASSOS) { passo ->
                PassoCard(passo)
            }
            item {
                Column(modifier = Modifier.padding(vertical = 20.dp)) {
                    Button(onClick = onCadastroClick, modifier = Modifier.fillMaxWidth()) {
                        Text("Quero começar")
                    }
                }
            }
        }
    }
}

@Composable
private fun PassoCard(passo: PassoComoFunciona) {
    val cor = Color(passo.corHex)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(cor),
                contentAlignment = Alignment.Center
            ) {
                Text(passo.numero, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Column(modifier = Modifier.padding(start = 16.dp).weight(1f)) {
                Text(passo.titulo, style = MaterialTheme.typography.titleMedium, color = AzulEscuro)
                Text(
                    passo.descricao,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    passo.detalhe,
                    style = MaterialTheme.typography.labelLarge,
                    color = cor,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}
