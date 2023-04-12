package com.epifilabs.tako.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.epifilabs.tako.R
import com.epifilabs.tako.models.StudyCardModel
import com.epifilabs.tako.utlis.GradientConstant

class StudyCardsAdapter(val studyCardsList:ArrayList<StudyCardModel>):RecyclerView.Adapter<StudyCardsAdapter.StudyCardsHolder>() {

    lateinit var context:Context

    class StudyCardsHolder(val item: View):RecyclerView.ViewHolder(item) {

        val learningLanguage = item.findViewById<TextView>(R.id.TvLearningLanguage)
        val mainLanguage = item.findViewById<TextView>(R.id.TvMainLanguage)
        val pronunciation = item.findViewById<TextView>(R.id.TvPronunciation)
        val cardView = item.findViewById<RelativeLayout>(R.id.RlCellWord)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyCardsHolder {
        context = parent.context
        val item = LayoutInflater.from(context).inflate(R.layout.cell_word,parent,false)

        return StudyCardsHolder(item)

    }

    override fun getItemCount(): Int {
        return studyCardsList.size
    }

    override fun onBindViewHolder(holder: StudyCardsHolder, position: Int) {
        val currentItem = studyCardsList[position]
        holder.learningLanguage.text = currentItem.learningLanguage
        holder.mainLanguage.text = currentItem.mainLanguage
        holder.pronunciation.text = currentItem.pronunciation
        holder.cardView.background   =   GradientConstant.goldGradient(context)



    }
}