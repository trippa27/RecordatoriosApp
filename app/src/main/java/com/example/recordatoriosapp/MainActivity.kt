package com.example.recordatoriosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recordatoriosapp.ui.theme.RecordatoriosAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecordatoriosAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),containerColor = Color(0xFFF3F4F6)) { innerPadding ->
                    ListaRecordatorios(
                        recordatorios = listaRecordatorios,
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}

// 1. Dibuja la lista completa
@Composable
fun ListaRecordatorios(recordatorios: List<Recordatorio>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp) // Deja espacio entre tarjetas
    ) {
        items(recordatorios) { elRecordatorio ->
            TarjetaRecordatorio(recordatorio = elRecordatorio)
        }
    }
}

// 2. Dibuja un solo recordatorio
@Composable
fun TarjetaRecordatorio(recordatorio: Recordatorio, modifier: Modifier = Modifier) {

    // Leemos el color del Map que creaste. Si no existe, usamos gris.
    val colorFondo = coloresPorCategoria[recordatorio.categoria] ?: Color.LightGray

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = colorFondo),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(text = recordatorio.titulo, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text = "Categoría: ${recordatorio.categoria.nombre}")

            // Tu if genial para la descripción opcional
            if (recordatorio.descripcion != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = recordatorio.descripcion)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // La forma moderna y sin errores de sacar el texto de la prioridad
            val prioridadTexto = when(recordatorio.prioridad) {
                Prioridad.Baja -> "Baja"
                Prioridad.Media -> "Media"
                Prioridad.Alta -> "Alta"
            }
            Text(text = "Prioridad: $prioridadTexto", style = MaterialTheme.typography.labelLarge)
        }
    }
}