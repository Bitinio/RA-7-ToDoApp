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

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

/**
 * ARCHIVO PRINCIPAL DE BASE DE DATOS: TaskDao.kt
 * Propósito (Feature #1 y #3): Interfaz DAO (Data Access Object / Objeto de Acceso a Datos) de Room.
 * Define todas las consultas SQL y operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * que la aplicación ejecuta sobre la tabla local "task" en la memoria del dispositivo.
 */
@Dao
interface TaskDao {

    // ============================================================================
    // BLOQUE DE LECTURA REACTIVA (FLOW)
    // ============================================================================

    /**
     * Consulta reactiva que observa todos los registros de la tabla "task".
     * Al retornar un Flow, Room notifica automáticamente a la interfaz (Compose)
     * cada vez que se inserta, edita o elimina una tarea en la memoria local.
     *
     * @return Flujo continuo con la lista de tareas locales.
     */
    @Query("SELECT * FROM task")
    fun observeAll(): Flow<List<LocalTask>>

    /**
     * Observa una tarea específica en tiempo real filtrando por su identificador único.
     *
     * @param taskId El ID único de la tarea a consultar.
     * @return Flujo con el objeto LocalTask correspondiente.
     */
    @Query("SELECT * FROM task WHERE id = :taskId")
    fun observeById(taskId: String): Flow<LocalTask>

    // ============================================================================
    // BLOQUE DE CONSULTAS DIRECTAS (COROUTINES - SUSPEND)
    // ============================================================================

    /**
     * Obtiene una fotografía instantánea de todas las tareas guardadas en SQLite.
     * Usa 'suspend' para ejecutarse en un hilo secundario y no bloquear la pantalla.
     *
     * @return Lista completa de objetos LocalTask.
     */
    @Query("SELECT * FROM task")
    suspend fun getAll(): List<LocalTask>

    /**
     * Busca y devuelve una única tarea por su ID (o null si no existe en la base de datos).
     *
     * @param taskId El ID de la tarea buscada.
     * @return La tarea encontrada o null.
     */
    @Query("SELECT * FROM task WHERE id = :taskId")
    suspend fun getById(taskId: String): LocalTask?

    // ============================================================================
    // BLOQUE DE INSERCIÓN Y ACTUALIZACIÓN (UPSERT / UPDATE)
    // ============================================================================

    /**
     * Inserta una nueva tarea en la base de datos local; si el ID ya existe,
     * actualiza/reemplaza el registro existente automáticamente (@Upsert = Update + Insert).
     *
     * @param task Entidad LocalTask que se guardará en memoria.
     */
    @Upsert
    suspend fun upsert(task: LocalTask)

    /**
     * Inserta o actualiza una lista completa de tareas en una sola transacción.
     *
     * @param tasks Lista de entidades LocalTask a persistir.
     */
    @Upsert
    suspend fun upsertAll(tasks: List<LocalTask>)

    /**
     * Actualiza únicamente el estado de completado (checkbox) de una tarea específica
     * sin necesidad de reescribir el título ni la descripción.
     *
     * @param taskId ID de la tarea a modificar.
     * @param completed Nuevo estado booleano (true = completada, false = pendiente).
     */
    @Query("UPDATE task SET isCompleted = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: String, completed: Boolean)

    // ============================================================================
    // BLOQUE DE ELIMINACIÓN (DELETE)
    // ============================================================================

    /**
     * Elimina un registro específico de la tabla "task" usando su ID.
     *
     * @param taskId ID de la tarea a borrar.
     * @return Número de filas afectadas (debe ser 1 si se eliminó correctamente).
     */
    @Query("DELETE FROM task WHERE id = :taskId")
    suspend fun deleteById(taskId: String): Int

    /**
     * Vacía por completo la tabla "task" eliminando todos los registros locales.
     */
    @Query("DELETE FROM task")
    suspend fun deleteAll()

    /**
     * Elimina de la memoria local únicamente las tareas marcadas como completadas (isCompleted = 1).
     * Se ejecuta desde la opción "Limpiar completadas" del menú superior.
     *
     * @return Cantidad total de tareas completadas que fueron eliminadas.
     */
    @Query("DELETE FROM task WHERE isCompleted = 1")
    suspend fun deleteCompleted(): Int
}