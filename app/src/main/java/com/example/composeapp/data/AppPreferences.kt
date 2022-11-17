package com.example.composeapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreferences(private val context: Context) {


    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userEmail")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
        val IS_LOGGED_IN = booleanPreferencesKey("isLoggedIn")
    }

    val getLoggedInStatus: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[IS_LOGGED_IN]?: false
        }

    suspend fun setLoggedInStatus( isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = isLoggedIn
        }
    }

    //get the saved email
    val getEmail: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: "FirstLast@gmail.com"
        }

    //save email into datastore
    suspend fun saveEmail( name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = name
        }
    }








    /*fun <T> getData(key: String, type: Class<T>): Flow<Any?>{

       return when(type){
           Int::class.java-> {
               context.dataStore.data
                   .map { preferences ->
                       preferences[intPreferencesKey(key)] ?: 0
                   }
           }
           String::class.java-> {
               context.dataStore.data
                   .map { preferences ->
                       preferences[stringPreferencesKey(key)] ?: ""
                   }
           }

           else -> {
               flow<Any?> { emit(null) }
           }
       }



   }*/


}