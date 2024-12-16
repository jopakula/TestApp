package com.example.testapp.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "settings")
    private val SELECTED_LESSONS_KEY = stringSetPreferencesKey("selected_lessons")

    suspend fun saveLessonId(id: Int) {
        context.dataStore.edit { preferences ->
            val currentIds = preferences[SELECTED_LESSONS_KEY]?.toMutableSet() ?: mutableSetOf()
            currentIds.add(id.toString())
            preferences[SELECTED_LESSONS_KEY] = currentIds
        }
    }

    fun getSelectedLessonsFlow(): Flow<Set<Int>> {
        return context.dataStore.data
            .map { preferences ->
                preferences[SELECTED_LESSONS_KEY]?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
            }
    }

    suspend fun clearSelectedLessons() {
        context.dataStore.edit { preferences ->
            preferences.remove(SELECTED_LESSONS_KEY)
        }
    }
}
