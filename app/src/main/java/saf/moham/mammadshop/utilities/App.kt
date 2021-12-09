package saf.moham.mammadshop.utilities

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import saf.moham.mammadshop.data.Cat
import saf.moham.mammadshop.home.*
import saf.moham.mammadshop.home.adapter.CatRWAdapter
import saf.moham.mammadshop.home.repository.BannerRepository
import saf.moham.mammadshop.home.repository.BannerRepositoryImp
import saf.moham.mammadshop.home.repository.CatRepository
import saf.moham.mammadshop.home.repository.CatRepositoryImp
import saf.moham.mammadshop.home.source.LocalBannerDataSource
import saf.moham.mammadshop.home.source.RemoteBannerDataSource
import saf.moham.mammadshop.home.source.RemoteCatDataSource
import saf.moham.mammadshop.retrofit.getClient

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        val myModules = module {
            single { getClient() }
            factory<BannerRepository> { BannerRepositoryImp(LocalBannerDataSource(get()),
                RemoteBannerDataSource(get())
            ) }
            factory<CatRepository> { CatRepositoryImp(RemoteCatDataSource(get())) }
            viewModel { HomeViewModel(get(),get()) }

            single<ImageLoading> { ImageLoadingImp() }

            factory {(cats:List<Cat>)-> CatRWAdapter(cats,get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }

    }
}