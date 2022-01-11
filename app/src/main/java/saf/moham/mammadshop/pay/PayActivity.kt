package saf.moham.mammadshop.pay

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.MainActivity
import saf.moham.mammadshop.R
import saf.moham.mammadshop.utilities.MyActivity

class PayActivity : MyActivity() {
    val payViewModel: PayViewModel by viewModel{
        val uri: Uri?= intent.data
        if (uri!=null)
            parametersOf(uri.getQueryParameter("order_id"))
        else
            parametersOf("0")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        val txt_message = findViewById<TextView>(R.id.txt_pay_message)
        val txt_orderId = findViewById<TextView>(R.id.txt_pay_orderId)
        val btn_backHome = findViewById<Button>(R.id.pay_back_home)
        payViewModel.payLiveData.observe(this){
            if (it.status == "success"){
                txt_message.text = "خرید با موفقیت انجام شد"
                txt_orderId.text = it.message
            }else{
                txt_message.text = "خطا در تراکنش"
                txt_orderId.text = "-"
            }
        }
        payViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

        btn_backHome.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

    }
}