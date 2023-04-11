package com.epifilabs.tako

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.epifilabs.tako.adapters.SectionAdapter
import com.epifilabs.tako.adapters.StudyCardsAdapter
import com.epifilabs.tako.databinding.ActivityMainBinding
import com.epifilabs.tako.models.StudyCardModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //Lists
    lateinit var sectionList:ArrayList<String>
    lateinit var studyCardsList:ArrayList<StudyCardModel>
    //Adapters
    lateinit var sectionAdapter:SectionAdapter
    lateinit var studyCardsAdapter: StudyCardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sectionList = arrayListOf<String>()
        sectionList.add("Learn")
        sectionList.add("Tests")

        initSections()
        initLearn()


    }

    private fun initLearn() {

        studyCardsAdapter = StudyCardsAdapter()



    }

    private fun initSections() {

        sectionAdapter = SectionAdapter(sectionList)
        binding.RvSections.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.RvSections.setHasFixedSize(true)
        binding.RvSections.adapter = sectionAdapter

    }


}