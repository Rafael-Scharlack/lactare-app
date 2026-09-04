package com.lactare.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/** Card curto usado na Home para exibir números de impacto (mockados). */
@Composable
fun StatCard(value: String, label: String, accentColor: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(150.dp),
        colors = CardDefaults.cardColors(containerColor = accentColor.copy(alpha = 0.10f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(value, style = MaterialTheme.typography.headlineMedium, color = accentColor)
            Text(label, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
