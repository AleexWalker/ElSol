package com.example.elsol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_comparacion.*

class Comparacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparacion)

        val planetas = arrayOf("Mercurio", "Venus", "La Tierra", "Marte", "Jupiter", "Saturno" , "Urano" , "Neptuno" , " Pluton")
        val arrayDiametros = arrayListOf<Double>(0.382 , 0.949 , 1.00 , 0.53 , 11.2 , 9.41 , 3.38 , 3.81 , 0.186)
        val arrayDistanciasAlSol = arrayListOf<Double>(0.387 , 0.723 , 1.00 , 1.542 , 5.203 , 9.539 , 19.81 , 30.07 , 39.44)
        val arrayDensidades = arrayListOf<Int>(5400 , 5250 , 5520 , 3960 , 1350 , 700 , 1200 , 1500 , 500)

        val adaptador = ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, planetas)

        val listaPlanetasPrimero = findViewById(R.id.autoCompleteTextView) as AutoCompleteTextView
        listaPlanetasPrimero.setAdapter(adaptador)
        listaPlanetasPrimero.threshold = 1

        val listaPlanetasSegundo = findViewById(R.id.autoCompleteTextView2) as AutoCompleteTextView
        listaPlanetasSegundo.setAdapter(adaptador)
        listaPlanetasSegundo.threshold = 1

        listaPlanetasPrimero.onItemClickListener = AdapterView.OnItemClickListener{
                parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()
            var seleccion : Int = 0
            // Display the clicked item using toast

            for (i in planetas.indices)
                if (selectedItem == planetas[i])
                    seleccion = i
            textView3.text = arrayDiametros[seleccion].toString()
            textView5.text = arrayDistanciasAlSol[seleccion].toString()
            textView8.text = arrayDensidades[seleccion].toString()

            Toast.makeText(applicationContext,"Selected : $selectedItem",Toast.LENGTH_SHORT).show()
        }

        listaPlanetasSegundo.onItemClickListener = AdapterView.OnItemClickListener{
                parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()
            var seleccion : Int = 0
            // Display the clicked item using toast

            for (i in planetas.indices)
                if (selectedItem == planetas[i])
                    seleccion = i
            textView4.text = arrayDiametros[seleccion].toString()
            textView6.text = arrayDistanciasAlSol[seleccion].toString()
            textView10.text = arrayDensidades[seleccion].toString()

            Toast.makeText(applicationContext,"Selected : $selectedItem",Toast.LENGTH_SHORT).show()
        }
    }
}