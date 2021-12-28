package saf.moham.mammadshop.register_and_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import saf.moham.mammadshop.MainActivity
import saf.moham.mammadshop.R
import saf.moham.mammadshop.utilities.MyActivity

class LoginActivity : MyActivity() {
    val registerAndLoginViewModel: RegisterAndLoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.login_mail)
        val edtPass = findViewById<EditText>(R.id.login_pass)
        val btnLogin = findViewById<Button>(R.id.login_btn)
        val txtGoRegister = findViewById<TextView>(R.id.login_goRegister)



        registerAndLoginViewModel.loginLiveData.observe(this){
            Toast.makeText(applicationContext, "ورود با موفقیت انجام شد", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }

        registerAndLoginViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        btnLogin.setOnClickListener {
            registerAndLoginViewModel.login(edtEmail.text.toString(), edtPass.text.toString())
        }

        txtGoRegister.setOnClickListener {
            startActivity(Intent(applicationContext,RegisterActivity::class.java))
        }

    }
}