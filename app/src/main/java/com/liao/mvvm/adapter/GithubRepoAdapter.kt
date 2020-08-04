package com.liao.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.liao.mvvm.databinding.NewRowBinding
import com.liao.mvvm.model.GithubRepository


class GithubRepoAdapter(private val context:Context) : RecyclerView.Adapter<GithubRepoAdapter.MyViewHolder>() {

    private var listItem = ArrayList<GithubRepository>()
    var isLoading = false

    fun setData(list: List<GithubRepository>) {
        listItem.clear()
        listItem.addAll(list)
        notifyDataSetChanged()

    }

    inner class MyViewHolder(private val binding: NewRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item:GithubRepository){
            binding.item = item
            binding.adapter = this@GithubRepoAdapter


            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = NewRowBinding.inflate(LayoutInflater.from(parent.context))
        var layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
        RecyclerView.LayoutParams.WRAP_CONTENT)
        binding.root.layoutParams= layoutParams
        return MyViewHolder(binding)
    }

    override fun getItemCount() = listItem.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listItem[position])


    }



    fun onItemClicked(item:GithubRepository){
        Toast.makeText(context,"${item.name}",Toast.LENGTH_SHORT).show()
        isLoading = !isLoading
        //notifyDataSetChanged()
        var posi = listItem.indexOf(item)
        notifyItemChanged(posi)


     


    }
}