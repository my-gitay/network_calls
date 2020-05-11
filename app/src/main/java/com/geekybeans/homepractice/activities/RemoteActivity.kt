package com.geekybeans.homepractice.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.geekybeans.homepractice.R
import com.geekybeans.homepractice.fragments.FirstFragment
import com.geekybeans.homepractice.viewmodels.RemoteViewModel


/** This is an home assignment that I created for practice **/
/** The following todo's needs to be implemented: **/

//TODO: fetch a json object from URL
//TODO: parse that json object into a list
//TODO: put that list inside a recycler view
//TODO: the recycler view should have 2 view holders according to the data of an item
//TODO: the recycler view should be in a fragment
//TODO: on item click you should navigate to another fragment for presenting the data pressed
//TODO: the app should handle orientation change
//TODO: use MVVM pattern in your code
//TODO: use Coroutines and LiveData
//TODO: create a singleton

class RemoteActivity : AppCompatActivity()
{
    private val viewModel: RemoteViewModel by viewModels()
    private val stringToShow = "Stringgg"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remote)

        /** check if after orientation change the second fragment is currently visible **/
        if (supportFragmentManager.findFragmentByTag("tag2") == null)
        {
            supportFragmentManager.beginTransaction().add(
                R.id.fragment_container,
                FirstFragment()
            ).commit()
        }
    }

    /** Example for using on saved instance state on configuration change **/
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle)
    {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("key", stringToShow)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString("key")
    }
}


