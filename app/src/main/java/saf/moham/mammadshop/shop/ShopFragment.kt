package saf.moham.mammadshop.shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.register_and_login.LoginActivity
import saf.moham.mammadshop.register_and_login.RegisterAndLoginViewModel
import saf.moham.mammadshop.utilities.MyFragment


class ShopFragment : MyFragment() {
    val shopViewModel: ShopViewModel by viewModel()
    val registerAndLoginViewModel: RegisterAndLoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val basketRecyclerView = view.findViewById<RecyclerView>(R.id.basket_rw)
        basketRecyclerView.layoutManager = LinearLayoutManager(context)

        shopViewModel.shopItemsLiveData.observe(viewLifecycleOwner){
            val rwAdapter: ShopBasketRWAdapter by inject { parametersOf(it) }
            basketRecyclerView.adapter = rwAdapter
        }

        shopViewModel.showProgressBarLiveData.observe(viewLifecycleOwner){
            showProgressBar(it)
        }

        val btn_login = view.findViewById<Button>(R.id.profile_login_btn)
        val loginLayout = view.findViewById<ConstraintLayout>(R.id.shop_login_layout)
        val basketLayout = view.findViewById<ConstraintLayout>(R.id.shop_basket_layout)

        registerAndLoginViewModel.checkLogin()

        registerAndLoginViewModel.checkLoginLiveData.observe(viewLifecycleOwner){
            if (it){
                loginLayout.visibility = View.GONE
                basketLayout.visibility = View.VISIBLE
            }else{
                showProgressBar(false)
                loginLayout.visibility = View.VISIBLE
                basketLayout.visibility = View.GONE
            }
        }

        btn_login.setOnClickListener {
            startActivity(Intent(context, LoginActivity::class.java))
        }

    }

}