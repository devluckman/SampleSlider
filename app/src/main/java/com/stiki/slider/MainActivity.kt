package com.stiki.slider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.stiki.slider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            val adapter = SliderAdapter(dataSlider())
            viewPager.adapter = adapter
            viewPager.isUserInputEnabled = false
            btnNext.setOnClickListener {
                if (viewPager.currentItem < adapter.itemCount - 1) {
                    val position = viewPager.currentItem + 1
                    viewPager.setCurrentItem(position, true)
                }
            }

            btnPrev.setOnClickListener {
                // Check dulu apakah ini Item pertama atau bukan
                if (viewPager.currentItem > 0) {
                    val position = viewPager.currentItem - 1
                    viewPager.setCurrentItem(position, true)
                }
            }
        }

    }


    private fun dataSlider() : List<String> {
        return listOf(
            "A", "B","C", "D"
        )
    }
}