package com.studyfork.sfoide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studyfork.sfoide.adapter.PersonInfoAdapter

import com.studyfork.sfoide.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /**
     * 이렇게 해야 무조건 성공한다.
     * 코틀린 확장함수.
     */
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Storeadapter = PersonInfoAdapter(this@MainActivity)


        recyclerview.apply {
            layoutManager = LinearLayoutManager( this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = Storeadapter
        }

        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer {
                Storeadapter.updateItems(it)
            })
            loadingLiveData.observe(this@MainActivity, Observer {
                progressBar.visibility = if(it) View.VISIBLE else View.GONE
            })
        }

    }
}