package com.example.volutariadoappv0.di

import android.app.Application
import androidx.room.Room
import com.example.volutariadoappv0.areas.proyectos.data.repository.ProyectoRepositoryImp
import com.example.volutariadoappv0.areas.proyectos.data.source.local.ProyectoDatabase
import com.example.volutariadoappv0.areas.proyectos.domain.repository.ProyectoRepository
import com.example.volutariadoappv0.utils.DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideProyectoDatabase(app: Application) = Room.databaseBuilder(
        app,
        ProyectoDatabase::class.java,
        DATABASE
    ).build()

    @Provides
    @Singleton
    fun provideRepository(db: ProyectoDatabase): ProyectoRepository {
        return ProyectoRepositoryImp(db.proyectoDao)
    }
}