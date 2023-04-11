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
    var studyCardsList:ArrayList<StudyCardModel> = arrayListOf<StudyCardModel>()
    //Adapters
    lateinit var sectionAdapter:SectionAdapter
    lateinit var studyCardsAdapter: StudyCardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adding elements to section list
        sectionList = arrayListOf<String>()
        sectionList.add("Learn")
        sectionList.add("Tests")

        //adding elements to study/learn list
        addingElementsStudy()


        //initialization of classes
        initSections()
        initLearn()


    }

    private fun addingElementsStudy() {
        createElementsStudyList("такой", "takoy", "tal", "Russian", "Spanish")
        createElementsStudyList("тоже", "tozhe", "también", "Russian", "Spanish")
        createElementsStudyList("больше", "bol'she", "más", "Russian", "Spanish")
        createElementsStudyList("один", "odin", "uno", "Russian", "Spanish")
        createElementsStudyList("надо", "nado", "es necesario", "Russian", "Spanish")
        createElementsStudyList("сам", "sam", "mismo", "Russian", "Spanish")
        createElementsStudyList("мне", "mne", "me", "Russian", "Spanish")
        createElementsStudyList("чем", "chem", "que / que", "Russian", "Spanish")
        createElementsStudyList("после", "posle", "después de", "Russian", "Spanish")
        createElementsStudyList("наш", "nash", "nuestro", "Russian", "Spanish")
        createElementsStudyList("тут", "tut", "aquí", "Russian", "Spanish")
        createElementsStudyList("год", "god", "año", "Russian", "Spanish")
        createElementsStudyList("него", "nego", "su / de él", "Russian", "Spanish")
        createElementsStudyList("тебя", "tebya", "tú", "Russian", "Spanish")
        createElementsStudyList("очень", "ochen'", "realmente", "Russian", "Spanish")
        createElementsStudyList("две", "dve", "dos", "Russian", "Spanish")
        createElementsStudyList("уже", "uzhe", "ya", "Russian", "Spanish")
        createElementsStudyList("другой", "drugoy", "otro", "Russian", "Spanish")
        createElementsStudyList("вот", "vot", "aquí está / aquí tienes", "Russian", "Spanish")
        createElementsStudyList("здесь", "zdes'", "aquí", "Russian", "Spanish")
        createElementsStudyList("раз", "raz", "vez", "Russian", "Spanish")
        createElementsStudyList("двух", "dvukh", "dos", "Russian", "Spanish")
        createElementsStudyList("свою", "sovuyu", "su / de ella", "Russian", "Spanish")
        createElementsStudyList("всё", "vsyo", "todo", "Russian", "Spanish")
        createElementsStudyList("были", "byli", "fueron", "Russian", "Spanish")
        createElementsStudyList("этой", "etoy", "esta", "Russian", "Spanish")
        createElementsStudyList("тоже самое", "tozhe samoye", "lo mismo", "Russian", "Spanish")
        createElementsStudyList("немного", "nemnogo", "un poco", "Russian", "Spanish")
        createElementsStudyList("ведь", "ved'", "pues", "Russian", "Spanish")






    }


    private fun initLearn() {

        studyCardsAdapter = StudyCardsAdapter(studyCardsList)
        binding.RvLearn.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.RvLearn.setHasFixedSize(true)
        binding.RvLearn.adapter = studyCardsAdapter



    }

    private fun initSections() {

        sectionAdapter = SectionAdapter(sectionList)
        binding.RvSections.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.RvSections.setHasFixedSize(true)
        binding.RvSections.adapter = sectionAdapter

    }

    private fun createElementsStudyList(learningLanguage:String,mainLanguage:String,pronunciation:String,nameLL:String,nameML:String){
        val studyCardModel = StudyCardModel(learningLanguage,mainLanguage,pronunciation,nameLL,nameML)
        studyCardsList.add(studyCardModel)


    }

}