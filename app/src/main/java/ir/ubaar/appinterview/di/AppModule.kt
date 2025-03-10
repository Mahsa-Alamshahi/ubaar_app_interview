package ir.ubaar.appinterview.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.ubaar.appinterview.data.data_source.remote.ApiService
import ir.ubaar.appinterview.data.repository.ApiRepositoryImpl
import ir.ubaar.appinterview.domain.repository.ApiRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiRepository(apiService: ApiService): ApiRepository =
        ApiRepositoryImpl(apiService)

}