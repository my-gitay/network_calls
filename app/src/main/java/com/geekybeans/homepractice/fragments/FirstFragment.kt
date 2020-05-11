package com.geekybeans.homepractice.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geekybeans.homepractice.activities.LocalJsonActivity
import com.geekybeans.homepractice.R
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fetch_remote_button.setOnClickListener { fetchRemote() }
        fetch_local_button.setOnClickListener { fetchLocal() }
    }

    private fun fetchRemote()
    {
        parentFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            SecondFragment(),"tag2").commit()
    }

    private fun fetchLocal()
    {
        startActivity(Intent(requireContext(), LocalJsonActivity::class.java))
    }
}
