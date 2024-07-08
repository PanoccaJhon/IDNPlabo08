package com.example.idnplab08

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.idnplab08.model.database.AppDatabase
import com.example.idnplab08.model.database.dao.SalaDao
import com.example.idnplab08.model.database.entity.AutorEntity
import com.example.idnplab08.model.database.entity.PinturaEntity
import com.example.idnplab08.model.database.entity.SalaEntity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "galeria_db"
        ).allowMainThreadQueries().build()

        val salaDao = db.salaDao()
        //insertar datos de prueba a sala entity
        val salas = listOf(
            SalaEntity(1,"Sala 1","Esta es la sala 1"),
            SalaEntity(2, "Sala 2","Esta es la sala 2"),
            SalaEntity(3,"Sala 3", "Esta es la sala 3")
        )
        for (sala in salas ){
            salaDao.insert(sala)
        }

        //insertar datos de prueba a autor entity
        val autorDao = db.autorDao()
        val autores = listOf(
            AutorEntity(1,"Pablo","Picasso"),
            AutorEntity(2,"Vincent","Van Gogh"),
            AutorEntity(3,"Leonardo","Da Vinci")
        )
        for (autor in autores){
            autorDao.insert(autor)
        }

        //insertar datos de prueba a pintura entity
        val pinturaDao = db.pinturaDao()
        val pinturas = listOf(
            PinturaEntity(1,"Guernica",1,1,"Acuarela","Bodegon","Que bonita pintura",2023,"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Mural_del_Gernika.jpg/640px-Mural_del_Gernika.jpg"),
            PinturaEntity(2,"La noche estrellada",2,2,"Oleo","Paisaje","Que bonita pintura",2023,"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/1280px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg"),
            PinturaEntity(3,"La Mona Lisa",3,3,"Oleo","Retrato","Que bonita pintura",2023,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Mona_Lisa.jpg/1200px-Mona_Lisa.jpg")
        )

        for (pintura in pinturas){
            pinturaDao.insert(pintura)
        }
        //Consultar datos de pintura usando PinturaEnSalaDao
        val pinturaEnSalaDao = db.pinturaEnSalaDao()
        val pinturasEnSala = pinturaEnSalaDao.getPinturaEnSalaPorId(1)
        Log.d("MainActivity", "Pinturas en sala: $pinturasEnSala")

        //consultar datos usando DescripcionPinturaDao
        val descriptionPinturaDao = db.descriptionPinturaDao()
        val descriptionPintura = descriptionPinturaDao.getPinturaDescriptionById(1)
        Log.d("MainActivity", "Descripcion de pintura: $descriptionPintura")

        //mostrar en UI los datos de descriocion de pintura
        val textTile = findViewById<EditText>(R.id.editTextTitulo)
        textTile.setText(descriptionPintura.title)
        val textAutor = findViewById<EditText>(R.id.editTextNombre)
        textAutor.setText(descriptionPintura.autorNombre)
        val textTecnica = findViewById<EditText>(R.id.editTextTecnica)
        textTecnica.setText(descriptionPintura.tecnique)
        val textCategoria = findViewById<EditText>(R.id.editTextCategoria)
        textCategoria.setText(descriptionPintura.category)
        val textDescripcion = findViewById<EditText>(R.id.editTextDescripcion)
        textDescripcion.setText(descriptionPintura.description)
        val textAnio = findViewById<EditText>(R.id.editTextAnio)
        textAnio.setText(descriptionPintura.year.toString())
        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this)
            .load(descriptionPintura.imageUrl)
            .into(imageView)




    }



}