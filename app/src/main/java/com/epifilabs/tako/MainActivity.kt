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
        val input = """
        такой (takoy) - tal
        тоже (tozhe) - también
        больше (bol'she) - más
        один (odin) - uno
        надо (nado) - es necesario
        сам (sam) - mismo
        мне (mne) - me
        чем (chem) - que / que
        после (posle) - después de
        наш (nash) - nuestro
        тут (tut) - aquí
        год (god) - año
        него (nego) - su / de él
        тебя (tebya) - tú
        очень (ochen') - realmente
        две (dve) - dos
        уже (uzhe) - ya
        другой (drugoy) - otro
        вот (vot) - aquí está / aquí tienes
        здесь (zdes') - aquí
        раз (raz) - vez
        двух (dvukh) - dos
        свою (sovuyu) - su / de ella
        всё (vsyo) - todo
        были (byli) - fueron
        этой (etoy) - esta
        тоже самое (tozhe samoye) - lo mismo
        немного (nemnogo) - un poco
        ведь (ved') - pues
        тогда (togda) - entonces
        какой (kakoy) - qué tipo de
        дело (delo) - asunto / negocio
        пока (poka) - mientras
        сейчас (seychas) - en este momento
        тебе (tebe) - a ti
        понимаю (ponimayu) - entiendo
        сказал (skazal) - dijo
        самый (samy) - el más
        идти (idti) - ir
        знаю (znayu) - sé
        своей (svoey) - su / de ella
        всем (vsem) - todos
        надеюсь (nadeyus') - espero
        три (tri) - tres
        когда (kogda) - cuando
        конечно (konechno) - por supuesto
        чего (chego) - qué
        понятно (ponyatno) - claro
        вместе (vmeste) - juntos
        место (mesto) - lugar
    """.trimIndent()

        val items = input.split("\n")
        val result = items.map {
            val parts = it.split(" - ")
            Triple(parts[0].trim(), parts[1].trim(), parts[2].trim())
        }
        result.forEach {
            createElementsStudyList( it.first, it.second,it.third,"Russian","Spanish")
        }


        //initialization of classes
        initSections()
        initLearn()


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