package com.liao.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liao.mvvm.R
import com.liao.mvvm.model.GithubRepository

class AdapterRecyclerView(var mContext: Context, var mList: List<GithubRepository>) :
    RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>() {
    var adapterListener : AdapterInteraction? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.new_row, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var githubRepository = mList[position]
        holder.bind(githubRepository)
    }

    fun setList(list: List<GithubRepository>) {
        mList = list
        notifyDataSetChanged()
    }

    fun setMyListener(adapterInteraction: AdapterInteraction){
        adapterListener = adapterInteraction

    }

    interface AdapterInteraction{
        fun clickedHandler(itemView: View, githubRepository: GithubRepository)
    }



    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(githubRepository: GithubRepository) {

            adapterListener!!.clickedHandler(itemView,githubRepository)

        }
    }

}