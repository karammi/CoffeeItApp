//package com.asad.coffeeitapp.core.di.module
//
//import com.asad.coffeeitapp.BuildConfig
//import com.asad.coffeeitapp.core.ApiErrorBody
//import com.asad.coffeeitapp.core.di.Util
//import com.squareup.moshi.Moshi
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import okhttp3.ResponseBody
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Converter
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//import java.util.concurrent.TimeUnit
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModuleTest {
//
//    @Provides
//    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().apply {
//            level = if (BuildConfig.DEBUG)
//                HttpLoggingInterceptor.Level.BODY
//            else
//                HttpLoggingInterceptor.Level.NONE
//        }
//    }
//
//    @Provides
//    fun provideMoshi(): Moshi = Moshi.Builder().build()
//
//    @Provides
//    fun provideMoshiConvertor(moshi: Moshi): MoshiConverterFactory =
//        MoshiConverterFactory.create(moshi)
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(
//        httpLoggingInterceptor: HttpLoggingInterceptor,
//    ): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .connectTimeout(20, TimeUnit.SECONDS)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(
//        client: OkHttpClient,
//        moshiConverterFactory: MoshiConverterFactory,
//    ): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(Util.BASE_URL_TEST)
//            .client(client)
//            .addConverterFactory(moshiConverterFactory)
//            .build()
//    }
//
//    @Provides
//    fun provideRetrofitConvertor(retrofit: Retrofit): Converter<ResponseBody, ApiErrorBody> {
//        return retrofit.responseBodyConverter(ApiErrorBody::class.java, arrayOf())
//    }
//}
