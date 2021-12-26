package saf.moham.mammadshop.utilities

import android.app.Application
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import saf.moham.mammadshop.data.*
import saf.moham.mammadshop.detail.adapter.ComparableProductsRWAdapter
import saf.moham.mammadshop.detail.adapter.PropertyRWAdapter
import saf.moham.mammadshop.detail.adapter.RatingItemRWAdapter
import saf.moham.mammadshop.detail.repository.*
import saf.moham.mammadshop.detail.source.RemoteComparableProductsDataSource
import saf.moham.mammadshop.detail.viewModel.DetailProductViewModel
import saf.moham.mammadshop.detail.viewModel.PropertyViewModel
import saf.moham.mammadshop.detail.source.RemoteDetailProductDataSource
import saf.moham.mammadshop.detail.source.RemoteGraphDataSource
import saf.moham.mammadshop.detail.source.RemotePropertiesDataSource
import saf.moham.mammadshop.detail.viewModel.ComparableProductsViewModel
import saf.moham.mammadshop.detail.viewModel.GraphViewModel
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

            factory { (cats:List<Cat>)-> CatRWAdapter(cats,get()) }
            factory { (amazingProducts:List<AmazingProduct>)-> AmazingProductRWAdapter(amazingProducts,get()) }
            factory { (properties:List<Property>)-> PropertyRWAdapter(properties) }
            factory { (rating:List<RatingItem>)-> RatingItemRWAdapter(rating) }
            factory { (comparableProducts:List<ComparableProductData>, id:String)-> ComparableProductsRWAdapter(comparableProducts, id, get()) }

            factory<DetailProductRepository> { DetailProductRepositoryImp(RemoteDetailProductDataSource(get())) }
            viewModel { (id:String)-> DetailProductViewModel(id,get()) }

            factory<PropertiesRepository> { PropertiesRepositoryImp(RemotePropertiesDataSource(get())) }
            viewModel { PropertyViewModel(get()) }

            factory<GraphRepository> { GraphRepositoryImp(RemoteGraphDataSource(get())) }
            viewModel { (id:String)-> GraphViewModel(id,get()) }

            factory<ComparableProductsRepository> { ComparableProductsRepositoryImp(RemoteComparableProductsDataSource(get())) }
            viewModel { (bundle:Bundle)-> ComparableProductsViewModel(bundle,get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }

    }
}