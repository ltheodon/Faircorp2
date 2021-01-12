package com.example.faircorp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

open class BasicActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_windows -> startActivity(
                Intent(this, BuildingWindows::class.java)
            )
            R.id.menu_website -> startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse("http://www.leotheodon.com/"))
            )
            R.id.menu_email -> startActivity(
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:leo.theodon@gmail.com"))
            )

        }
        return super.onContextItemSelected(item)
    }
}