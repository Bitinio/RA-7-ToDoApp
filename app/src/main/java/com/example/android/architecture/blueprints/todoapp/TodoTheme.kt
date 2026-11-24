package com.example.android.architecture.blueprints.todoapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * ARCHIVO PRINCIPAL DE DISEÑO VISUAL: TodoTheme.kt
 * Propósito (Feature #3 y #4): Define la paleta de colores personalizada y el tema
 * global (Material Design 3) que envuelve a toda la aplicación "ToDoApp".
 * Se modificaron los colores originales (gris y verde) por una gama en azul índigo.
 */
@Composable
fun TodoTheme(content: @Composable () -> Unit) {
    // Esquema de colores personalizado para el modo claro de la aplicación
    val customColorScheme = lightColorScheme(
        primary = Color(0xFF1565C0),          // Azul intenso para botones principales, ícono Empty State y títulos
        onPrimary = Color(0xFFFFFFFF),        // Texto e íconos en blanco sobre elementos primarios
        secondary = Color(0xFF00838F),        // Azul cian para acentos y elementos secundarios
        tertiary = Color(0xFF5C6BC0),         // Índigo suave para detalles complementarios
        background = Color(0xFFF8FAFC),       // Fondo general ligeramente azulado/gris claro
        surface = Color(0xFFFFFFFF),          // Superficie de barras superiores y cuadros de diálogo
        surfaceVariant = Color(0xFFE3F2FD),   // Azul pastel claro para las tarjetas (Card) de cada tarea
        onSurface = Color(0xFF1E293B),        // Color oscuro de alta legibilidad para el texto de las tareas
        onSurfaceVariant = Color(0xFF475569)  // Gris azulado para subtítulos y textos secundarios
    )

    // Aplicamos el tema de Material 3 a todo el árbol de componentes de Jetpack Compose
    MaterialTheme(
        colorScheme = customColorScheme,
        content = content
    )
}