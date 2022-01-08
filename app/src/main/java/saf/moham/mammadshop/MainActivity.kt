package saf.moham.mammadshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import saf.moham.mammadshop.classification.ClassificationFragment
import saf.moham.mammadshop.home.HomeFragment
import saf.moham.mammadshop.profile.ProfileFragment
import saf.moham.mammadshop.shop.ShopFragment
import saf.moham.mammadshop.utilities.homeOrBasket

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)

            bottomNavigationView.setOnItemSelectedListener{
                val id = it.itemId
                when (id) {
                    R.id.menu_home -> {
                        val fragment = HomeFragment()
                        val transaction1 = supportFragmentManager.beginTransaction()
                        transaction1.replace(R.id.main_frameLayout, fragment)
                        transaction1.commit()
                    }
                    R.id.menu_classification -> {
                        val fragment = ClassificationFragment()
                        val transaction2 = supportFragmentManager.beginTransaction()
                        transaction2.replace(R.id.main_frameLayout, fragment)
                        transaction2.commit()
                    }
                    R.id.menu_shopping -> {
                        val fragment = ShopFragment()
                        val transaction3 = supportFragmentManager.beginTransaction()
                        transaction3.replace(R.id.main_frameLayout, fragment)
                        transaction3.commit()
                    }
                    R.id.menu_profile -> {
                        val fragment = ProfileFragment()
                        val transaction4 = supportFragmentManager.beginTransaction()
                        transaction4.replace(R.id.main_frameLayout, fragment)
                        transaction4.commit()
                    }
                }
                return@setOnItemSelectedListener true
            }

            if (homeOrBasket==0)
                bottomNavigationView.selectedItemId = R.id.menu_home
            else {
                bottomNavigationView.selectedItemId = R.id.menu_shopping
                homeOrBasket=1
            }

        }
}



