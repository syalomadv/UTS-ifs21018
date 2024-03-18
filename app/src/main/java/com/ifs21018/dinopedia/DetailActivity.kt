package com.ifs21018.dinopedia

import android.R
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ifs21018.dinopedia.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var dino: Dino? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dino = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DINO,
                Dino::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DINO)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (dino != null) {
            supportActionBar?.title = "Hewan ${dino!!.name}"
            loadData(dino!!)
        } else {
            finish()
        }
    }


    private fun loadData(dino: Dino) {
        binding.ivDetailIcon.setImageResource(dino.icon)
        binding.tvDetailName.text = dino.name
        binding.tvDetailDescription.text = dino.description
        binding.tvDetailCharacteristic.text = dino.characteristic
        binding.tvDetailGroup.text = dino.group
        binding.tvDetailHabitat.text = dino.habitat
        binding.tvDetailFood.text = dino.food
        binding.tvDetailLength.text = dino.length
        binding.tvDetailHeight.text = dino.height
        binding.tvDetailWeight.text = dino.weight
        binding.tvDetailWeakness.text = dino.weakness

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    companion object {
        const val EXTRA_DINO = "extra_dino"
    }
}