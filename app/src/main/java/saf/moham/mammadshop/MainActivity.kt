package saf.moham.mammadshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import saf.moham.mammadshop.home.HomeFragment
import saf.moham.mammadshop.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener{
            var id = it.itemId
            when (id) {
                R.id.menu_home -> {
                    val fragment = HomeFragment()
                    val transaction1 = supportFragmentManager.beginTransaction();
                    transaction1.replace(R.id.main_frameLayout, fragment)
                    transaction1.commit()
                }
                R.id.menu_classification -> {

                }
                R.id.menu_shopping -> {

                }
                R.id.menu_profile -> {
                    val fragment = ProfileFragment()
                    val transaction2 = supportFragmentManager.beginTransaction();
                    transaction2.replace(R.id.main_frameLayout, fragment)
                    transaction2.commit()
                }
            }
            return@setOnItemSelectedListener true
        }

        bottomNavigationView.selectedItemId = R.id.menu_home

    }

}

