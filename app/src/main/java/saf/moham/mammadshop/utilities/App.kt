package saf.moham.mammadshop.utilities

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import saf.moham.mammadshop.data.AmazingProduct
import saf.moham.mammadshop.data.Cat
import saf.moham.mammadshop.detail.DetailProductViewModel
import saf.moham.mammadshop.detail.repository.DetailProductRepository
import saf.moham.mammadshop.detail.repository.DetailProductRepositoryImp
import saf.moham.mammadshop.detail.source.RemoteDetailProductDataSource
import saf.moham.mammadshop.home.*
import saf.moham.mammadshop.home.adapter.AmazingProductRWAdapter
import saf.moham.mammadshop.home.adapter.CatRWAdapter
import saf.moham.mammadshop.home.repository.*
import saf.moham.mammadshop.home.source.*
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
            factory<AmazingProductRepository> { AmazingProductRepositoryImp(RemoteAmazingProductDataSource(get())) }
            viewModel { HomeViewModel(get(),get(),get()) }

            single<ImageLoading> { ImageLoadingImp() }

            factory {(cats:List<Cat>)-> CatRWAdapter(cats,get()) }
            factory {(amazingProducts:List<AmazingProduct>)-> AmazingProductRWAdapter(amazingProducts,get()) }

            factory<DetailProductRepository> { DetailProductRepositoryImp(RemoteDetailProductDataSource(get())) }
            viewModel {(id:String)-> DetailProductViewModel(id,get()) }

        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }

    }
}