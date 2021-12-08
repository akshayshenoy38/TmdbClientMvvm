package com.akshay.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.akshay.tmdbclient.data.db.ArtistDao
import com.akshay.tmdbclient.data.db.MovieDao
import com.akshay.tmdbclient.data.db.TMDBDatabase
import com.akshay.tmdbclient.data.db.TvDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context):TMDBDatabase {
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) : TvDao{
        return tmdbDatabase.tvDao()
    }


    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }
}