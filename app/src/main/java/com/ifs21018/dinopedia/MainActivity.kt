package com.ifs21018.dinopedia

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21018.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataDinos = ArrayList<Dino>() // Mengubah nama variabel dari dataDino menjadi dataDinos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvDinos.setHasFixedSize(false)
        dataDinos.addAll(getListDinos()) // Mengubah nama dari getListDinos() menjadi getListDinos()
        showRecyclerList()
    }
    private fun getListDinos(): ArrayList<Dino> {
        val dataName = resources.getStringArray(R.array.dinos_name)
        val dataIcon = resources.obtainTypedArray(R.array.dinos_icon)
        val dataDescription = resources.getStringArray(R.array.dinos_description)
        val dataCharacteristic = resources.getStringArray(R.array.dinos_characteristic)
        val dataHabitat = resources.getStringArray(R.array.dinos_group)
        val dataProcess = resources.getStringArray(R.array.dinos_habitat)
        val dataFood = resources.getStringArray(R.array.dinos_food)
        val dataLength = resources.getStringArray(R.array.dinos_length) // Menggunakan getStringArray() untuk mendapatkan array string
        val dataHeight = resources.getStringArray(R.array.dinos_height)
        val dataWeight = resources.getStringArray(R.array.dinos_weight)
        val dataWeakness = resources.getStringArray(R.array.dinos_weakness)

        val listDino = ArrayList<Dino>()
        for (i in dataName.indices) {
            val dino = Dino(
                dataName[i],
                dataIcon.getResourceId(i, -1),
                dataDescription[i],
                dataCharacteristic[i],
                dataHabitat[i],
                dataProcess[i],
                dataFood[i],
                dataLength[i], // Mengambil data langsung dari array string
                dataHeight[i],
                dataWeight[i],
                dataWeakness[i]
            )
            listDino.add(dino)
        }

        // Release the TypedArray
        dataIcon.recycle()

        return listDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvDinos.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.rvDinos.layoutManager =
                LinearLayoutManager(this)
        }
        val listDinoAdapter = ListDinoAdapter(dataDinos)
        binding.rvDinos.adapter = listDinoAdapter
        listDinoAdapter.setOnItemClickCallback(object :
            ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                showSelectedDino(data) // Mengubah showSelectedFruit menjadi showSelectedDino
            }
        })
    }
    private fun showSelectedDino(dino: Dino) {
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("selectedDino", dino.name) // Mengirimkan nama dinosaurus yang dipilih
        startActivity(intent)
    }

}
