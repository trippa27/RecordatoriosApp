package com.example.recordatoriosapp
import androidx.compose.ui.graphics.Color
val categoriasUnicas: Set<Categoria> = setOf(
    Categoria("Trabajo"),
    Categoria("Estudio"),
    Categoria("Personal")
)

val coloresPorCategoria: Map<Categoria, Color> = mapOf(
    Categoria("Trabajo") to Color(0xFFE3F2FD),
    Categoria("Estudio") to Color(0xFFFFF3E0),
    Categoria("Personal") to Color(0xFFE8F5E9)
)

val  listaRecordatorios: List<Recordatorio> =listOf(

    Recordatorio(
        titulo = "estudiar",
        id = 1,
        categoria = Categoria("Estudio"),
        prioridad = Prioridad.Alta,
        estado = Estado.Pendiente,
        descripcion = "terminar modulo"

    ),

    Recordatorio(
        titulo = "repasar",
        id = 2,
        categoria = Categoria("Estudio"),
        prioridad = Prioridad.Media,
        estado = Estado.Pendiente,
        descripcion = "estudiar mas"

    ),
    Recordatorio(
        titulo = "pedir uniformes",
        id = 2,
        categoria = Categoria("Trabajo"),
        prioridad = Prioridad.Alta,
        estado = Estado.Pendiente,
        descripcion = "llenar doc de uniformes"

    )



)