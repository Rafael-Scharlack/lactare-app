package com.lactare.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.lactare.app.navigation.LactareNavGraph
import com.lactare.app.ui.theme.LactareTheme

/**
 * Activity única do app Lactare (MVP Sprint 3 - Android Kotlin).
 * Toda a navegação é feita via Jetpack Navigation Compose,
 * a partir do grafo definido em [LactareNavGraph].
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LactareTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LactareNavGraph()
                }
            }
        }
    }
}
