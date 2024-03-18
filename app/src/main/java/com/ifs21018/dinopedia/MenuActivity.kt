package com.ifs21018.dinopedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21018.dinopedia.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private val dataDinos = ArrayList<Dino>() // Menyimpan data dinosaurus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        // Inisialisasi RecyclerView
        val recyclerView = binding.rvTwoDinos
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mendapatkan informasi dinosaurus yang dipilih dari MainActivity
        val selectedDino = intent.getStringExtra("selectedDino")

        // Menampilkan dua jenis dinosaurus berdasarkan dinosaurus yang dipilih
        dataDinos.addAll(getTwoDinos(selectedDino))
        val adapter = ListDinoAdapter(dataDinos)
        recyclerView.adapter = adapter
    }

    private fun getTwoDinos(selectedDino: String?): List<Dino> {
        // Mengembalikan dua jenis dinosaurus berdasarkan dinosaurus yang dipilih
        return when (selectedDino) {
            "Theropoda" -> listOf(
                Dino("Tyrannosaurus rex", R.drawable.tyrannosaurusrex, "Deskripsi Dino 2", "Karakteristik Dino 2", "", "", "", "", "", "", ""),
                Dino("Allosaurus", R.drawable.allosaurus, "Deskripsi Dino 3", "Karakteristik Dino 3", "", "", "", "", "", "", "")
            )
            "Sauropodomorpha" -> listOf(
                Dino("Brachiosaurus", R.drawable.brachiosaurus, "Deskripsi Dino 4", "Karakteristik Dino 4", "", "", "", "", "", "", ""),
                Dino("Diplodocus", R.drawable.diplodocus, "Deskripsi Dino 5", "Karakteristik Dino 5", "", "", "", "", "", "", "")
            )
            "Ornithischia" -> listOf(
                Dino("Ankylosaurus", R.drawable.ankylosaurus, "Deskripsi Dino 2", "Karakteristik Dino 2", "", "", "", "", "", "", ""),
                Dino("Stegosaurus", R.drawable.stegosaurus, "Deskripsi Dino 3", "Karakteristik Dino 3", "", "", "", "", "", "", "")
            )
            "Ceratopsidae" -> listOf(
                Dino("Styracosaurus", R.drawable.styracosaurus, "Deskripsi Dino 4", "Karakteristik Dino 4", "", "", "", "", "", "", ""),
                Dino("Triceratops", R.drawable.triceratops, "Deskripsi Dino 5", "Karakteristik Dino 5", "", "", "", "", "", "", "")
            )
            "Hadrosauridae" -> listOf(
                Dino("Parasaurolophus", R.drawable.parasaurolophus, "Deskripsi Dino 2", "Karakteristik Dino 2", "", "", "", "", "", "", ""),
                Dino("Edmontosaurus", R.drawable.edmontosaurus, "Deskripsi Dino 3", "Karakteristik Dino 3", "", "", "", "", "", "", "")
            )
            "Stegosauridae" -> listOf(
                Dino("Kentrosaurus", R.drawable.kentrosaurus, "Deskripsi Dino 4", "Karakteristik Dino 4", "", "", "", "", "", "", ""),
                Dino("Huayangosaurus", R.drawable.huayangosaurus, "Deskripsi Dino 5", "Karakteristik Dino 5", "", "", "", "", "", "", "")
            )
            "Tyrannosauridae" -> listOf(
                Dino("Daspletosaurus", R.drawable.daspletosaurus, "Deskripsi Dino 2", "Karakteristik Dino 2", "", "", "", "", "", "", ""),
                Dino("Albertosaurus", R.drawable.albertosaurus, "Deskripsi Dino 3", "Karakteristik Dino 3", "", "", "", "", "", "", "")
            )
            "Velociraptoridae" -> listOf(
                Dino("Velociraptor", R.drawable.velociraptor, "Deskripsi Dino 4", "Karakteristik Dino 4", "", "", "", "", "", "", ""),
            )
            else -> emptyList()
        }
    }
}
