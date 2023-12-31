package saf.moham.mammadshop.utilities

import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import saf.moham.mammadshop.MainActivityViewModel
import saf.moham.mammadshop.classification.ClassificationRWAdapter
import saf.moham.mammadshop.classification.ClassificationViewModel
import saf.moham.mammadshop.classification.repository.ClassificationRepository
import saf.moham.mammadshop.classification.repository.ClassificationRepositoryImp
import saf.moham.mammadshop.classification.source.RemoteClassificationDataSource
import saf.moham.mammadshop.data.*
import saf.moham.mammadshop.detail.adapter.ComparableProductsRWAdapter
import saf.moham.mammadshop.detail.adapter.CompareRWAdapter
import saf.moham.mammadshop.detail.adapter.PropertyRWAdapter
import saf.moham.mammadshop.detail.adapter.RatingItemRWAdapter
import saf.moham.mammadshop.detail.repository.*
import saf.moham.mammadshop.detail.source.RemoteComparableProductsDataSource
import saf.moham.mammadshop.detail.source.RemoteDetailProductDataSource
import saf.moham.mammadshop.detail.source.RemoteGraphDataSource
import saf.moham.mammadshop.detail.source.RemotePropertiesDataSource
import saf.moham.mammadshop.detail.viewModel.*
import saf.moham.mammadshop.home.*
import saf.moham.mammadshop.home.adapter.AmazingProductRWAdapter
import saf.moham.mammadshop.home.adapter.CatRWAdapter
import saf.moham.mammadshop.home.repository.*
import saf.moham.mammadshop.home.source.*
import saf.moham.mammadshop.pay.PayViewModel
import saf.moham.mammadshop.pay.repository.PayRepository
import saf.moham.mammadshop.pay.repository.PayRepositoryImp
import saf.moham.mammadshop.pay.source.RemotePayDataSource
import saf.moham.mammadshop.register_and_login.RegisterAndLoginViewModel
import saf.moham.mammadshop.register_and_login.repository.RegisterAndLoginRepository
import saf.moham.mammadshop.register_and_login.repository.RegisterAndLoginRepositoryImp
import saf.moham.mammadshop.register_and_login.source.LocalRegisterAndLoginDataSource
import saf.moham.mammadshop.register_and_login.source.RemoteRegisterAndLoginDataSource
import saf.moham.mammadshop.retrofit.getClient
import saf.moham.mammadshop.shop.ShopBasketRWAdapter
import saf.moham.mammadshop.shop.ShopViewModel
import saf.moham.mammadshop.shop.repository.ShopRepository
import saf.moham.mammadshop.shop.repository.ShopRepositoryImp
import saf.moham.mammadshop.shop.source.RemoteShopDataSource

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        val myModules = module {
            single { getClient() }

            single<ImageLoading> { ImageLoadingImp() }

            single<SharedPreferences> { this@App.getSharedPreferences("user_data", MODE_PRIVATE) }

            factory<BannerRepository> { BannerRepositoryImp(LocalBannerDataSource(get()), RemoteBannerDataSource(get())) }
            factory<CatRepository> { CatRepositoryImp(RemoteCatDataSource(get())) }
            factory<AmazingProductRepository> { AmazingProductRepositoryImp(RemoteAmazingProductDataSource(get())) }
            factory<RegisterAndLoginRepository> { RegisterAndLoginRepositoryImp(RemoteRegisterAndLoginDataSource(get()),LocalRegisterAndLoginDataSource(get())) }
            factory<DetailProductRepository> { DetailProductRepositoryImp(RemoteDetailProductDataSource(get())) }
            factory<PropertiesRepository> { PropertiesRepositoryImp(RemotePropertiesDataSource(get())) }
            factory<GraphRepository> { GraphRepositoryImp(RemoteGraphDataSource(get())) }
            factory<ComparableProductsRepository> { ComparableProductsRepositoryImp(RemoteComparableProductsDataSource(get())) }
            factory<ClassificationRepository> { ClassificationRepositoryImp(RemoteClassificationDataSource(get())) }
            factory<ShopRepository> { ShopRepositoryImp(RemoteShopDataSource(get())) }
            factory<PayRepository> { PayRepositoryImp(RemotePayDataSource(get())) }

            factory { (cats:List<Cat>)-> CatRWAdapter(cats,get()) }
            factory { (amazingProducts:List<AmazingProduct>)-> AmazingProductRWAdapter(amazingProducts,get()) }
            factory { (properties:List<Property>)-> PropertyRWAdapter(properties) }
            factory { (rating:List<RatingItem>)-> RatingItemRWAdapter(rating) }
            factory { (comparableProducts:List<ComparableProductData>, id:String)-> ComparableProductsRWAdapter(comparableProducts, id, get()) }
            factory { (firstList:List<Property>,secondList:List<Property>)-> CompareRWAdapter(firstList,secondList) }
            factory { (cats:List<CatProduct>)-> ClassificationRWAdapter(cats, get()) }
            factory { (shopBasket:ShopResponse)-> ShopBasketRWAdapter(shopBasket,get()) }

            viewModel { HomeViewModel(get(), get(), get()) }
            viewModel { (id:String)-> DetailProductViewModel(id, get(), get()) }
            viewModel { PropertyViewModel(get()) }
            viewModel { (id:String)-> GraphViewModel(id, get()) }
            viewModel { (bundle:Bundle)-> ComparableProductsViewModel(bundle, get()) }
            viewModel { (bundle:Bundle)-> CompareViewModel(bundle,get(), get()) }
            viewModel { RegisterAndLoginViewModel(get()) }
            viewModel { ClassificationViewModel(get()) }
            viewModel { ShopViewModel(get()) }
            viewModel { MainActivityViewModel(get()) }
            viewModel { (orderId: String)-> PayViewModel(get(), orderId) }

        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }

        val registerAndLoginRepository:RegisterAndLoginRepository = get()
        registerAndLoginRepository.loadToken()

    }
}