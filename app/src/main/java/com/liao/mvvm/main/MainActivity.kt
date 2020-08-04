package com.liao.mvvm.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.liao.mvvm.R
import com.liao.mvvm.adapter.AdapterRecyclerView
import com.liao.mvvm.adapter.GithubRepoAdapter
import com.liao.mvvm.databinding.ActivityMainBinding
import com.liao.mvvm.model.GithubRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_row.view.*

class MainActivity : AppCompatActivity()//, AdapterRecyclerView.AdapterInteraction
{
    private lateinit var viewModel: MainViewModel
    //lateinit var adapterRecyclerView: AdapterRecyclerView
    //private var mList: List<GithubRepository> = ArrayList()
    val mAdapter: GithubRepoAdapter = GithubRepoAdapter(this)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        observerData()
        initList()

        init()
    }

    private fun initList(){
        binding.recyclerView.apply {
            adapter = mAdapter

        }

        binding.refreshLayout.setOnRefreshListener {
            viewModel.onButtonClicked()
        }

    }

    private fun observerData() {
        viewModel.getGithubRepositoryObserver().observe(this, Observer {
            binding.refreshLayout.isRefreshing = false
            if (it != null) {
                mAdapter.setData(it)
                //mList = it
                //adapterRecyclerView.setList(it)
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun init() {
//        button.setOnClickListener {
//            viewModel.onButtonClicked()
//        }

//        recycler_view.layoutManager = LinearLayoutManager(this)
//        adapterRecyclerView = AdapterRecyclerView(this, mList)
//        adapterRecyclerView.setMyListener(this)
//        recycler_view.adapter = adapterRecyclerView
//        recycler_view.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                DividerItemDecoration.VERTICAL
//            )
//        )

    }

//    override fun clickedHandler(itemView: View, githubRepository: GithubRepository) {
//        itemView.textView.text = "author: " + githubRepository.author
//        itemView.textView2.text = "avatar: " + githubRepository.avatar
////        itemView.textView3.text = "name: " + githubRepository.name
////        itemView.textView4.text = "url: " + githubRepository.url
////        itemView.textView5.text = "description: " + githubRepository.description
//    }
}