package saf.moham.mammadshop.utilities

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import saf.moham.mammadshop.home.*
import saf.moham.mammadshop.retrofit.getClient

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        val myModules = module {
            single { getClient() }
            factory<BannerRepository> { BannerRepositoryImp(LocalBannerDataSource(),RemoteBannerDataSource(get())) }
            viewModel { HomeViewModel(get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }

    }
}