package com.magicworld.avantic.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.magicworld.avantic.R
import com.magicworld.avantic.databinding.ListFragmentBinding
import com.magicworld.avantic.model.LugaresItem
import com.magicworld.avantic.ui.main.MainActivity

class ListFragment : Fragment() {

    private lateinit var listBinding: ListFragmentBinding
    private lateinit var lugaresAdapter: LugaresAdapter
    private var listLugares : ArrayList<LugaresItem> = arrayListOf()
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity?)?.hideIcon()
        listBinding = ListFragmentBinding.inflate(inflater,container, false)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.loadMocklugaresFromJson(context?.assets?.open("pois.json"))
        viewModel.getLugaresFromServer()

        lugaresAdapter= LugaresAdapter(listLugares, onItemCliked = {onLugarCliked(it)})

        listBinding.avanticRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
        viewModel.onLugaresLoaded.observe(viewLifecycleOwner,{result->
            onLugaresLoadedSubcribe(result)
        })
    }
    private fun onLugaresLoadedSubcribe(result: ArrayList<LugaresItem>?) {
        result?.let { listLugares->
            lugaresAdapter.appendItems(listLugares)
        }
    }

    private fun onLugarCliked(lugar: LugaresItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar=lugar))
    }

}