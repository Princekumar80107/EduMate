package com.edumate.learnmate.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edumate.learnmate.R
import com.edumate.learnmate.activities.NotesActivity
import com.edumate.learnmate.models.Subject

class SubjectAdapter(private var context: Context, private val subject: List<Subject>) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectViewTitle: TextView = itemView.findViewById(R.id.subjectTitle)
        val iconView: ImageView = itemView.findViewById(R.id.subjectIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.subject_item, parent, false)
        return SubjectViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subject.size
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.subjectViewTitle.text = subject[position].subjectName

        Glide.with(context)
            .load(subject[position].iconUrl)
            .into(holder.iconView)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, NotesActivity::class.java)
            intent.putExtra("TITLE", subject[position].subjectName)
            intent.putExtra("SEMESTER", subject[position].semester)
            intent.putExtra("DEPARTMENT", subject[position].department)
            context.startActivity(intent)
        }
    }
}