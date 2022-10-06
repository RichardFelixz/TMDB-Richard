package br.com.richardfelix.imdbrichard.di

import br.com.richardfelix.imdbrichard.service.repository.remote.TheMovieDatabaseService
import br.com.richardfelix.imdbrichard.view_model.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    factory<Interceptor> {
        HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger.DEFAULT
        ).setLevel(
            HttpLoggingInterceptor.Level.HEADERS
        )
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(
                interceptor = get()
            ).build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(TheMovieDatabaseService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(TheMovieDatabaseService::class.java)
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}