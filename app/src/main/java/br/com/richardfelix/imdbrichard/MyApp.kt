package br.com.richardfelix.imdbrichard

import android.app.Application
import br.com.richardfelix.imdbrichard.di.apiModule
import br.com.richardfelix.imdbrichard.di.retrofitModule
import br.com.richardfelix.imdbrichard.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(
                retrofitModule,
                apiModule,
                viewModelModule
            )
        }
    }
}