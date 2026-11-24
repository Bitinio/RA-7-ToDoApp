/*
 * Copyright 2019 The Android Open Source Project
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

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * ARCHIVO PRINCIPAL DE BASE DE DATOS: ToDoDatabase.kt
 * Propósito (Feature #1 y #3): Clase principal que configura e inicializa la base de datos
 * local SQLite mediante la librería Room de Android Jetpack.
 * Conecta las entidades (tablas) con los objetos de acceso a datos (DAO) para permitir
 * la persistencia de información en la memoria interna del dispositivo.
 */
@Database(
    entities = [LocalTask::class], // Registra las tablas que forman parte de la base de datos
    version = 1,                     // Versión del esquema de la base de datos (se incrementa si cambian las tablas)
    exportSchema = false             // Desactiva la exportación del historial de esquemas a archivos JSON
)
abstract class ToDoDatabase : RoomDatabase() {

    /**
     * Expone la interfaz TaskDao para que el repositorio (DefaultTaskRepository)
     * pueda ejecutar consultas SQL (insertar, leer, actualizar y eliminar tareas).
     * Room genera automáticamente la implementación de este método al compilar.
     */
    abstract fun taskDao(): TaskDao
}