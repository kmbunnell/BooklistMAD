package com.bonehill.booklistmad.di

import com.bonehill.booklistmad.data.api.BookLookUpService
import com.bonehill.booklistmad.repository.BookRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(api:BookLookUpService)=BookRepository(api)

}