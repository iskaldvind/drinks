package io.iskaldvind.drinks.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.iskaldvind.drinks.data.storage.Storage
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideStorage(context: Context): Storage =
        Room
            .databaseBuilder(context, Storage::class.java, "storage")
            .build()
}