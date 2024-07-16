package com.example.pharmacyapp.presentation.di

import com.example.pharmacyapp.data.remote.Api
import com.example.pharmacyapp.data.repo.AddItemRequest
import com.example.pharmacyapp.data.repo.AddItemRequestImpl
import com.example.pharmacyapp.data.repo.CreateRequest
import com.example.pharmacyapp.data.repo.CreateRequestImpl
import com.example.pharmacyapp.data.repo.HomeRequstes
import com.example.pharmacyapp.data.repo.HomeRequstesimpl
import com.example.pharmacyapp.data.repo.UserLogin
import com.example.pharmacyapp.data.repo.UserLoginImpl
import com.example.pharmacyapp.data.repo.pharmacydetails
import com.example.pharmacyapp.data.repo.pharmacydetailsimpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    @Provides
    @Singleton
    fun provideretrofit():Api{
        return Retrofit.Builder().baseUrl("https://portal-test.rxmaxreturns.com/rxmax/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)


    }

    @Provides
    @Singleton
    fun provideuserloginrepo(api: Api): UserLogin {
        return UserLoginImpl(api)

    }

    @Provides
    @Singleton
    fun provideHomeRequestrepo(api: Api): HomeRequstes {
        return HomeRequstesimpl(api)

    }

    @Provides
    @Singleton
    fun provideReturnRequestdretails(api: Api): pharmacydetails {
        return pharmacydetailsimpl(api)

    }

    @Provides
    @Singleton
    fun provideCreateReques(api: Api): CreateRequest {
        return CreateRequestImpl(api)

    }


    @Provides
    @Singleton
    fun provideItemRequest(api: Api):AddItemRequest {
        return AddItemRequestImpl(api)

    }









}