package saf.moham.mammadshop.register_and_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import saf.moham.mammadshop.MainActivity
import saf.moham.mammadshop.R
import saf.moham.mammadshop.utilities.MyActivity

class RegisterActivity : MyActivity() {
    val registerAndLoginViewModel:RegisterAndLoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val edtEmail = findViewById<EditText>(R.id.register_mail)
        val edtPass = findViewById<EditText>(R.id.register_pass)
        val btnLogin = findViewById<Button>(R.id.register_btn)
        val txtGoRegister = findViewById<TextView>(R.id.register_goLogin)

        registerAndLoginViewModel.registerLiveData.observe(this){
            Toast.makeText(applicationContext, "ثبت نام با موفقیت انجام شد", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        registerAndLoginViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        btnLogin.setOnClickListener {
            registerAndLoginViewModel.register(edtEmail.text.toString(),edtPass.text.toString())
        }

        txtGoRegister.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }


    }
}