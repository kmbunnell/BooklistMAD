package com.bonehill.booklistmad.di

import com.bonehill.booklistmad.data.api.BookLookUpService
import com.bonehill.booklistmad.data.datasource.BookDao
import com.bonehill.booklistmad.data.repository.BookRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(api:BookLookUpService, dao:BookDao)=BookRepository(api, dao)

}