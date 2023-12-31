package saf.moham.mammadshop.shop

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.data.Message
import saf.moham.mammadshop.register_and_login.LoginActivity
import saf.moham.mammadshop.register_and_login.RegisterAndLoginViewModel
import saf.moham.mammadshop.utilities.MyFragment
import saf.moham.mammadshop.utilities.MySingleObserver
import saf.moham.mammadshop.utilities.singleHelper


class ShopFragment : MyFragment(),ShopBasketRWAdapter.ShopItemClickListener {
    val shopViewModel: ShopViewModel by viewModel()
    val registerAndLoginViewModel: RegisterAndLoginViewModel by viewModel()
    val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_login = view.findViewById<Button>(R.id.profile_login_btn)
        val loginLayout = view.findViewById<ConstraintLayout>(R.id.shop_login_layout)
        val basketLayout = view.findViewById<ConstraintLayout>(R.id.shop_basket_layout)
        val emptyBasketLayout = view.findViewById<ConstraintLayout>(R.id.empty_basket_layout)
        val btn_pay = view.findViewById<Button>(R.id.shop_pay_btn)

        val basketRecyclerView = view.findViewById<RecyclerView>(R.id.basket_rw)
        basketRecyclerView.layoutManager = LinearLayoutManager(context)

        shopViewModel.shopItemsLiveData.observe(viewLifecycleOwner){
            if (it.message.isNotEmpty()) {
                basketLayout.visibility = View.VISIBLE
                emptyBasketLayout.visibility = View.GONE
                val rwAdapter: ShopBasketRWAdapter by inject { parametersOf(it) }
                basketRecyclerView.adapter = rwAdapter
                rwAdapter.setShopItemListener(this)
            }else{
                basketLayout.visibility = View.GONE
                emptyBasketLayout.visibility = View.VISIBLE
            }
        }

        shopViewModel.showProgressBarLiveData.observe(viewLifecycleOwner){
            showProgressBar(it)
        }

        registerAndLoginViewModel.checkLogin()

        registerAndLoginViewModel.checkLoginLiveData.observe(viewLifecycleOwner){
            if (it){
                loginLayout.visibility = View.GONE
                emptyBasketLayout.visibility = View.VISIBLE
                basketLayout.visibility = View.GONE
            }else{
                showProgressBar(false)
                loginLayout.visibility = View.VISIBLE
                emptyBasketLayout.visibility = View.GONE
                basketLayout.visibility = View.GONE
            }
        }

        btn_login.setOnClickListener {
            startActivity(Intent(context, LoginActivity::class.java))
        }

        btn_pay.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://clicksite.org/app_digi_mellat/example.php"))
            startActivity(intent)
        }

    }

    override fun deleteItemClickListened(id: String) {
        shopViewModel.removeItemFromBasket(id)
            .singleHelper()
            .subscribe(object: MySingleObserver<Message>(compositeDisposable){
                override fun onSuccess(t: Message) {
                    if (t.status == "success") {
                        Toast.makeText(context, "محصول مورد نظر از سبد خرید حذف شد", Toast.LENGTH_SHORT).show()
                        shopViewModel.getItems()
                    }
                }
            })
    }

    override fun changeItemCount(id: String, count: Int) {
        if (count>0) {
            shopViewModel.changeItemCount(id, count)
                .singleHelper()
                .subscribe(object : MySingleObserver<Message>(compositeDisposable) {
                    override fun onSuccess(t: Message) {
                        shopViewModel.getItems()
                    }
                })
        }else{
            shopViewModel.removeItemFromBasket(id)
                .singleHelper()
                .subscribe(object: MySingleObserver<Message>(compositeDisposable){
                    override fun onSuccess(t: Message) {
                        if (t.status == "success") {
                            Toast.makeText(context, "محصول مورد نظر از سبد خرید حذف شد", Toast.LENGTH_SHORT).show()
                            shopViewModel.getItems()
                        }
                    }
                })
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}