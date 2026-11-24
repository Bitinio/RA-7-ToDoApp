# 📱 ToDoApp — Resultado de Aprendizaje #7

Aplicación móvil nativa para **Android** desarrollada en **Kotlin** con **Jetpack Compose** y arquitectura **MVVM**, diseñada para gestionar tareas pendientes mediante persistencia de datos en la memoria local del dispositivo utilizando **Room (SQLite)**.

---

## 👥 Equipo de Desarrollo
* **Desarrollador 1:** [César Lugo Cabañas]
* **Desarrollador 2:** [Anthony Emmanuel Rodriguez Hernandez]
* **Materia / Módulo:** Desarrollo de Aplicaciones Móviles — Resultado de Aprendizaje #7
* **Lenguaje:** Kotlin (`.kt`)

---

## ✨ Características Implementadas (Features)

1. **Base de Datos Local con Room (`SQLite`):**
   * Persistencia de datos en la memoria interna del dispositivo mediante los tres componentes principales de Room:
     * `LocalTask.kt` (`@Entity`): Define la estructura de la tabla `task` (`id`, `title`, `description`, `isCompleted`).
     * `TaskDao.kt` (`@Dao`): Gestiona las consultas SQL y operaciones CRUD (`@Query`, `@Upsert`, `DELETE`) de forma asíncrona con Coroutines y reactiva mediante `Flow`.
     * `ToDoDatabase.kt` (`@Database`): Inicializa y conecta la base de datos local con la capa de repositorio.

2. **Pantalla tipo "Empty State" (Estado Vacío):**
   * Vista personalizada (`TasksEmptyContent` en `TasksScreen.kt`) que detecta automáticamente cuando la consulta a Room devuelve 0 registros.
   * Muestra un ícono vectorial temático acompañado de un mensaje claro que guía al usuario para registrar su primera tarea.

3. **Documentación y Comentarios en Código:**
   * Encabezados descriptivos y comentarios explicativos en español dentro de los archivos principales y bloques críticos (`TodoActivity.kt`, `TasksScreen.kt`, `TodoTheme.kt`, `LocalTask.kt`, `TaskDao.kt`, `ToDoDatabase.kt` y `strings.xml`).

4. **Personalización Visual y Mensajes en Pantalla:**
   * **Paleta de colores (`TodoTheme.kt`):** Esquema basado en Material Design 3 con gama de colores en Azul Índigo y Cian (`#1565C0`, `#00838F`, `#E3F2FD`).
   * **Componentes UI (`TasksScreen.kt` y `TodoDrawer.kt`):** Diseño de tarjetas (`Card`) con esquinas redondeadas para cada tarea, botón flotante (`FloatingActionButton`) estilizado y logotipo vectorial personalizado (`logo_no_fill.xml`).
   * **Localización (`strings.xml`):** Traducción y personalización completa al español de todos los textos, alertas (`Snackbar`), filtros y títulos de la aplicación.

---

## 📂 Estructura de Archivos Principales

```text
app/src/main/
├── java/com/example/android/architecture/blueprints/todoapp/
│   ├── TodoActivity.kt              # Actividad principal y punto de entrada
│   ├── TodoTheme.kt                 # Paleta de colores y tema visual Material 3
│   ├── data/source/local/
│   │   ├── LocalTask.kt             # Entidad (Tabla) de Room
│   │   ├── TaskDao.kt               # Consultas SQL y operaciones CRUD
│   │   └── ToDoDatabase.kt          # Configuración de la base de datos SQLite
│   ├── tasks/
│   │   └── TasksScreen.kt           # Pantalla principal, lista de tareas y Empty State
│   └── util/
│       └── TodoDrawer.kt            # Menú lateral de navegación y cabecera
└── res/
    ├── drawable/
    │   └── logo_no_fill.xml         # Logotipo vectorial personalizado de ToDoApp
    └── values/
        └── strings.xml              # Textos y mensajes en español
