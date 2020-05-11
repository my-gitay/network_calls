package com.geekybeans.homepractice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekybeans.homepractice.R
import com.geekybeans.homepractice.models.RemoteDataEntity
import com.geekybeans.homepractice.adapters.RemoteItemsRecyclerAdapter
import com.geekybeans.homepractice.viewmodels.RemoteViewModel
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment()
{
    /** get the activity's view model (use the same view model for activity and both fragments) **/
    private val viewModel: RemoteViewModel by activityViewModels()
    private var itemList: MutableList<RemoteDataEntity> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        /** set recycler view **/
        sec_fragment_recycler.apply {
            adapter =
                RemoteItemsRecyclerAdapter(
                    itemList
                )
            layoutManager = LinearLayoutManager(requireContext())
        }

        /** call to start fetching Json from URL **/
        viewModel.getDataFromService()

        /** observe the live data change - the Json converted to list and assign this object **/
        viewModel.listFromResponse.observe(viewLifecycleOwner, Observer {
            itemList.addAll(it)
            sec_fragment_recycler.adapter?.notifyDataSetChanged()
        })
    }
}
