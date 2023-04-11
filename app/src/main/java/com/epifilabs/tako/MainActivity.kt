package com.epifilabs.tako

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.epifilabs.tako.adapters.SectionAdapter
import com.epifilabs.tako.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    lateinit var sectionList:ArrayList<String>
    lateinit var sectionAdapter:SectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sectionList = arrayListOf<String>()
        sectionList.add("Learn")
        sectionList.add("Tests")

        initRecyclerView()
        initLearn()


    }

    private fun initLearn() {

    }

    private fun initRecyclerView() {

        sectionAdapter = SectionAdapter(sectionList)
        binding.Rv1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.Rv1.setHasFixedSize(true)
        binding.Rv1.adapter = sectionAdapter

    }


}