package com.example.jobzz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.jobzz.R
import com.example.jobzz.databinding.ActivityMainBinding
import com.example.jobzz.databinding.ViewholderCategoryBinding

class Categoryadapter(private val items:List<String>,val clickListener: ClickListener):
    RecyclerView.Adapter<Categoryadapter.Viewholder>() {

    private var selectedPostion=-1
    private var lastSelectedPosition=-1
    private lateinit var context: Context
    inner class Viewholder(val binding:ViewholderCategoryBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Categoryadapter.Viewholder {
        context = parent.context
        val binding =
            ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Categoryadapter.Viewholder, position:Int) {
        val  item = items[position]
        holder.binding.cattxt.text= item
        holder.binding.root.setOnClickListener{
            lastSelectedPosition = selectedPostion
            selectedPostion = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPostion)
            clickListener.onClkick(position.toString())
        }
        if(selectedPostion==position){
            holder.binding.cattxt.setBackgroundResource(R.drawable.blue_full_corner)
            holder.binding.cattxt.setBackgroundResource(R.drawable.white_bg_full_stroke)
        } else{
            holder.binding.cattxt.setBackgroundResource(R.drawable.white_bg_full_stroke)
            holder.binding.cattxt.setTextColor(context.resources.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int =items.size
    interface ClickListener {
        fun onClkick(category:String)
    }


    }

