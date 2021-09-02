package ua.javabegin.examples.lesson3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.constraint, BlankFragment2.newInstance())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var fragment: Fragment? = null // что бы не использовать lateinit чтбы не класть в него null

        when(item.itemId) {
            R.id.action_settings -> startActivity(Intent(this, MainActivity::class.java))
            R.id.save_settings -> fragment = BlankFragment1.newInstance("PARAM1", "param1")
            R.id.open_settings -> fragment = BlankFragment2.newInstance()
            else -> fragment = BlankFragment2.newInstance()
        }

        if(fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.constraint, fragment)
                .commit()
        }

        return super.onOptionsItemSelected(item)
    }
}

/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
// у каждого фрагмента должен быть свой ViewModel

        when(item.itemId) {
            R.id.action_settings -> startActivity(Intent(this, MainActivity::class.java))
            R.id.save_settings -> {
                var fragment: Fragment = BlankFragment1.newInstance()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.constraint, fragment)
                    .commit()
            }
            R.id.open_settings -> {
                var fragment: Fragment = BlankFragment2.newInstance()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.constraint, fragment)
                    .commit()
            }
        }


        return super.onOptionsItemSelected(item)
    }*/