package com.bonehill.booklistmad.di

import android.content.Context
import androidx.room.Room
import com.bonehill.booklistmad.data.datasource.BooksTaggedDatabase
import com.bonehill.booklistmad.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideBooksTaggedDatabase( @ApplicationContext context: Context)=
        Room.databaseBuilder(
            context,
            BooksTaggedDatabase::class.java,
            Constants.DB_NAME
        ).createFromAsset("database/BooksTaggedDB.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideBookDao(db: BooksTaggedDatabase)=db.getBookDao()
}