package com.faezolfp.miniprojekxl

import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faezolfp.miniprojekxl.databinding.ItemLayoutBinding
import com.faezolfp.miniprojekxl.domain.domain.Datas

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val listDataGempa = ArrayList<Datas>()
    fun setDataGempaTerkini(data: List<Datas>) {
        listDataGempa.clear()
        listDataGempa.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Datas) {
           binding.txtNama.setText(data.nama)
           binding.txtGenere.setText(if (data.genre!!.size > 0) data.genre?.get(0) ?: "" else "Nothing")
           binding.txtRatinr.setText(if (data.rating != null) data.rating else "0.0")
            Glide.with(itemView.context)
                .load(data.gambar)
                .into(binding.imgGambar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listDataGempa.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDataGempa[position])
    }
}