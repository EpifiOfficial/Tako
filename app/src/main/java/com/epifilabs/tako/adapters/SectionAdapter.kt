package com.epifilabs.tako.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.epifilabs.tako.R

class SectionAdapter(val sectionList:ArrayList<String>): RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    lateinit var context:Context

    class SectionViewHolder(val item: View):RecyclerView.ViewHolder(item){
        val name = item.findViewById<Button>(R.id.BtnSection)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        context = parent.context
        val item = LayoutInflater.from(context).inflate(R.layout.cell_section,parent,false)

        return SectionViewHolder(item)

    }

    override fun getItemCount(): Int {
        return sectionList.size
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val currentItem = sectionList[position]
        holder.name.text = currentItem

    }
}