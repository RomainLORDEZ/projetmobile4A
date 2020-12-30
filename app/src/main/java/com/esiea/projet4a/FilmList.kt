package com.esiea.projet4a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.esiea.projet4a.Adapter.FilmListAdapter
import com.esiea.projet4a.Common.Common
import com.esiea.projet4a.Common.ItemOfDecoration
import com.esiea.projet4a.data.Retrofit.IFilmList
import com.esiea.projet4a.data.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_film_list.*

class FilmList : Fragment() {

    internal var compositeDisposable = CompositeDisposable()
    internal var iFilmList:IFilmList

    init{
        val retrofit =RetrofitClient.instance
        iFilmList = retrofit.create(IFilmList::class.java)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_film_list, container, false)

        film_recyclerview.setHasFixedSize(true)
        film_recyclerview.layoutManager = GridLayoutManager(activity,2)
        val itemDecoration = ItemOfDecoration(activity!!,R.dimen.spacing)
        film_recyclerview.addItemDecoration(itemDecoration)

        fetchData()

        return itemView
    }

    private fun fetchData() {
        compositeDisposable.add(iFilmList.listfilm)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ filmDex ->
                Common.filmList = filmDex.film!!
                val adapter = FilmListAdapter(activity!!,Common.filmList)

                film_recyclerview.adapter = adapter
            }
        
    }

}