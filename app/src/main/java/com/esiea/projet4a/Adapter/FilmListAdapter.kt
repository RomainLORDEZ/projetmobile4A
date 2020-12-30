package com.esiea.projet4a.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esiea.projet4a.R
import com.esiea.projet4a.data.Model.Movy


class FilmListAdapter(
    private var context: Context,
    private var filmList:List<Movy>) :RecyclerView.Adapter<FilmListAdapter.MyViewHolder>() {


    inner class MyViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        internal var img_film:ImageView
        internal var txt_film:TextView
        init {
            img_film = itemView.findViewById(R.id.film_image) as ImageView
            txt_film = itemView.findViewById(R.id.film_name) as TextView
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.film_list_items,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(filmList[position].posterUrl).into(holder.img_film)
        holder.txt_film.text=filmList[position].title
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
}