package com.example.recordatoriosapp

sealed class Estado {
    object Pendiente : Estado()
    object Completado : Estado()
    object Vencido : Estado()
}

sealed class Prioridad {
    object Baja : Prioridad()
    object Media : Prioridad()
    object Alta : Prioridad()
}

data class Categoria(
    val nombre: String
)
data class Recordatorio(
    val titulo: String,
    val id: Int,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: Estado,
    val descripcion: String? = null

)
