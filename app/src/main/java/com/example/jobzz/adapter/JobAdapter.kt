package com.example.jobzz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jobzz.R
import com.example.jobzz.activity.DetailJobActivity
import com.example.jobzz.databinding.ViewholderJobBinding
import com.example.jobzz.model.JobModel

class JobAdapter(private val items: List<JobModel>) : RecyclerView.Adapter<JobAdapter.Viewholder>() {

    private lateinit var context: Context

    inner class Viewholder(val binding: ViewholderJobBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: JobAdapter.Viewholder, position: Int) {
        val item = items[position]
        holder.binding.titletxt.text = item.title
        holder.binding.companytxt.text = item.company
        holder.binding.locationtxt.text = item.location
        holder.binding.timetxt.text = item.time
        holder.binding.modeltxt.text = item.model
        holder.binding.leveltxt.text = item.level
        holder.binding.salarytxt.text = item.salary

        val drawableResourceId = holder.itemView.resources
            .getIdentifier(item.picUrl,"drawable",holder.itemView.context.packageName)


        // Load the image using Glide with the retrieved resource ID
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.binding.pic)

        holder.itemView.setOnClickListener{
            val intent = Intent(context, DetailJobActivity::class.java)
            intent.putExtra("object",item)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
