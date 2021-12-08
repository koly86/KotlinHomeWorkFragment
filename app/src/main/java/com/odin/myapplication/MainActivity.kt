package com.odin.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottomNav)

        bottomNav.menu.getItem(0).isCheckable = true
        setFragment(frag1())

        bottomNav.setOnNavigationItemSelectedListener {menu ->

            when(menu.itemId){

                R.id.btn1 -> {
                    setFragment(frag1())
                    true
                }

                R.id.btn2 -> {
                    setFragment(frag2())
                    true
                }

                R.id.btn3 -> {
                    setFragment(frag3())
                    true
                }

                else -> false
            }
        }
        Log.i(TAG, "R.id.item2 - onStop")
    }



    fun setFragment(fr : Fragment){
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.fragment,fr)
        frag.commit()
    }
}