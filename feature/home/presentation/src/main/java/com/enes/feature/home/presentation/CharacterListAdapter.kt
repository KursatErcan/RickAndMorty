package com.enes.feature.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.enes.feature.home.domain.entity.ResultEntity
import com.enes.feature.home.presentation.databinding.ItemCharacterBinding

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.ViewRickAndMortyHolder>() {

    private var list: List<ResultEntity> = emptyList()
    private var setItemClickListener: (ResultEntity) -> Unit = {}

    inner class ViewRickAndMortyHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResultEntity) = with(binding) {
            species.text = item.species.orEmpty()
            status.text = item.status.orEmpty()
            name.text = item.name
            profilePhoto.load(item.image)
            root.setOnClickListener { setItemClickListener.invoke(item) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewRickAndMortyHolder {
        return ViewRickAndMortyHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewRickAndMortyHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun submitList(newList: List<ResultEntity>) {
        list = newList
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener: (ResultEntity) -> Unit) {
        setItemClickListener = listener
    }


}