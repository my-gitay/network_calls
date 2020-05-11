package com.geekybeans.homepractice.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.geekybeans.homepractice.R
import com.geekybeans.homepractice.adapters.BooksAdapter
import com.geekybeans.homepractice.models.BookEntity
import com.geekybeans.homepractice.viewmodels.LocalJsonViewModel
import kotlinx.android.synthetic.main.activity_local.*


/************ Main Task ************/
//TODO: get Json locally
//TODO: parse to objects
//TODO: present objects as follows - show color according to RGB value, when the image loads show the image instead

class LocalJsonActivity : AppCompatActivity()
{
    private val viewModel: LocalJsonViewModel by viewModels()
    private var books: MutableList<BookEntity> = mutableListOf()

    companion object
    {
        const val NUM_OF_GRIDS = 2
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        //call to fetch data from json file
        val json: String = assets.open("books.json").bufferedReader().use { it.readText() }
        viewModel.fetchFromJson(json)

        //set the books recycler view
        setRecycler()
        //listen for the fetched data
        viewModel.booksFromJson.observe(this, Observer {
            if (books.size > 0) books.clear()
            books.addAll(viewModel.booksFromJson.value as MutableList)
            swipe_refresh.isRefreshing = false
        })

        swipe_refresh.setOnRefreshListener {
            viewModel.fetchFromJson(json)
        }
    }

    private fun setRecycler() {
        main_recycler.apply {
            adapter = BooksAdapter(books)
            layoutManager = GridLayoutManager(this@LocalJsonActivity, NUM_OF_GRIDS)
        }
    }
}
