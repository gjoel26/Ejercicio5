package mx.edu.tecmm.tequila.ejercicio5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    lateinit var txTitulo: TextView
    lateinit var spLenguaje: Spinner
    lateinit var txDescripcion: TextView
    val lenguajes = arrayOf("PHP", "JAVA", "KOTLIN", "JAVASCRIPT", "RUBY", "C" , "SWIFT")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txTitulo = findViewById(R.id.txTitulo)
        spLenguaje = findViewById(R.id.spLenguaje)
        txDescripcion = findViewById(R.id.txDescripcion)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lenguajes )

        spLenguaje.adapter = adaptador
        spLenguaje.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, id : Long) {
        Log.v("App Spinner", "Seleccionaste uno $p2")
        val lenguaje = lenguajes[p2]
       txTitulo.text = lenguaje
        val descripcion = when(lenguaje){
            "PHP" -> "Es un lenguaje para el backed de las paginas"
            "JAVA" -> "Es un lenguaje de programacion orientado a objetos"
            "KOTLIN" -> "Es un lenguaje para el desarrollo de aplicaciones moviles"
            "JAVASCRIPT" -> " Es Un lenguaje para paginas web del lado del cliente"
            "RUBY" -> "Es un lenguaje para el desarrollo de aplicaciones agiles"
            "C" -> "Es un lenguaje para desarrollar aplicaciones y sistemas operativos"
            "SWIFT" -> "Es un lenguaje de programacion que trabaja con codigo abierto e infraestructuras"

            else -> "No se ha definido"
        }
        txDescripcion.text = descripcion

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}