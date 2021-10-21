package com.example.elsol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar3)
        toolbar.inflateMenu(R.menu.menu_arriba)
        setSupportActionBar(toolbar)

        val recView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
        val itemsFotos = ArrayList<TarjetaFotos>()
        itemsFotos.add(TarjetaFotos(R.drawable.corona_solar , R.string.coronasolar))
        itemsFotos.add(TarjetaFotos(R.drawable.erupcionsolar , R.string.erupcionsolar))
        itemsFotos.add(TarjetaFotos(R.drawable.espiculas , R.string.espiculas))
        itemsFotos.add(TarjetaFotos(R.drawable.filamentos , R.string.filamentos))
        itemsFotos.add(TarjetaFotos(R.drawable.magnetosfera , R.string.magnetoesfera))
        itemsFotos.add(TarjetaFotos(R.drawable.manchasolar , R.string.manchasolar))
        itemsFotos.add(TarjetaFotos(R.drawable.corona_solar , R.string.coronasolar))
        itemsFotos.add(TarjetaFotos(R.drawable.erupcionsolar , R.string.erupcionsolar))


        val adaptador = CardsAdapterFotos(itemsFotos)

        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(this, 2)
        recView.itemAnimator = DefaultItemAnimator()

        adaptador.onClick = {
            Toast.makeText(this, " ", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_comparar)
            lanzarComparacion()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_arriba, menu)
        return true
    }

    fun lanzarComparacion(){
        val i = Intent(this, Comparacion::class.java)
        startActivity(i)
    }
}


/*fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here.
            val id = item.getItemId()

            if (id == R.id.action_uno) {
                Toast.makeText(this, "Item One Clicked", Toast.LENGTH_LONG).show()
                return true
            }
            if (id == R.id.action_dos) {
                Toast.makeText(this, "Item Two Clicked", Toast.LENGTH_LONG).show()
                return true
            }
            if (id == R.id.action_tres) {
                Toast.makeText(this, "Item Three Clicked", Toast.LENGTH_LONG).show()
                return true
            }
            if (id == R.id.action_cuatro) {
                Toast.makeText(this, "Item Three Clicked", Toast.LENGTH_LONG).show()
                return true
            }
            if (id == R.id.action_cinco) {
                Toast.makeText(this, "Item Three Clicked", Toast.LENGTH_LONG).show()
                return true
            }

            return super.onOptionsItemSelected(item)

        }*/