package saf.moham.mammadshop.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import saf.moham.mammadshop.R
import saf.moham.mammadshop.detail.DetailProductActivity
import saf.moham.mammadshop.register_and_login.LoginActivity
import saf.moham.mammadshop.register_and_login.RegisterAndLoginViewModel
import saf.moham.mammadshop.utilities.MyFragment

class ProfileFragment : MyFragment() {
    val registerAndLoginViewModel:RegisterAndLoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerAndLoginViewModel.checkLogin()

        val btn_login = view.findViewById<Button>(R.id.profile_login_btn)
        val loginLayout = view.findViewById<ConstraintLayout>(R.id.profile_login_layout)
        val profileLayout = view.findViewById<ConstraintLayout>(R.id.profile_profile_layout)

        registerAndLoginViewModel.checkLoginLiveData.observe(viewLifecycleOwner){
            if (it){
                loginLayout.visibility = View.GONE
                profileLayout.visibility = View.VISIBLE
            }else{
                loginLayout.visibility = View.VISIBLE
                profileLayout.visibility = View.GONE
            }
        }

        btn_login.setOnClickListener {
            startActivity(Intent(context, LoginActivity::class.java))
        }


    }

}