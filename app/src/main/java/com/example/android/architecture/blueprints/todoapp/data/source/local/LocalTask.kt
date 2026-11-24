/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * ARCHIVO PRINCIPAL DE BASE DE DATOS: LocalTask.kt
 * Propósito (Feature #1 y #3): Define la Entidad (tabla) de Room que se almacenará
 * físicamente en la base de datos SQLite del dispositivo Android.
 * Cada instancia de esta clase representa una fila dentro de la tabla "task".
 */
@Entity(
    tableName = "task" // Nombre exacto de la tabla en SQLite consultada desde TaskDao
)
data class LocalTask(
    // @PrimaryKey indica que este campo es la llave primaria única de cada registro
    @PrimaryKey val id: String,

    // Columna para almacenar el título de la tarea
    var title: String,

    // Columna para almacenar la descripción detallada del pendiente
    var description: String,

    // Columna booleana que guarda si la tarea está completada (true/1) o pendiente (false/0)
    var isCompleted: Boolean,
)