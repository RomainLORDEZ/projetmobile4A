package com.esiea.projet4a.presentation.film

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esiea.projet4a.Adapter.FilmListAdapter
import com.esiea.projet4a.Common.ItemOffsetDecoration
import com.esiea.projet4a.R
import kotlinx.android.synthetic.main.fragment_film_list.*
import org.koin.android.ext.android.inject

class FilmListFragment : Fragment() {

    private val filmViewModel: FilmViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        film_recyclerview.setHasFixedSize(true)
        film_recyclerview.layoutManager = GridLayoutManager(activity,2)
        val itemDecoration = ItemOffsetDecoration(requireActivity(), R.dimen.spacing)
        film_recyclerview.addItemDecoration(itemDecoration)

        filmViewModel.listFilmLiveData.observe(viewLifecycleOwner, Observer { list ->
            val adapter = FilmListAdapter(requireContext(), list)
            film_recyclerview.adapter = adapter
        })
    }

}