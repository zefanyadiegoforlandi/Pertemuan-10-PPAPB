package com.example.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan10.databinding.ItemRestaurantBinding

typealias OnClickRestaurant = (Restaurant) -> Unit

class RestaurantAdapter(private val listRestaurant: List<Restaurant>,
    private val onClickRestaurant: OnClickRestaurant) :

    RecyclerView.Adapter<RestaurantAdapter.ItemRestaurantViewHolder>(){
    inner class  ItemRestaurantViewHolder
        (private val binding:ItemRestaurantBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun bind(data :Restaurant){
                    with(binding) {
                        restoNameTxt.text = data.name
                        restoTypeTxt.text= data.type
                        itemView.setOnClickListener {
                            onClickRestaurant(data)
                        }
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ItemRestaurantViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  listRestaurant.size
    }

    override fun onBindViewHolder(holder: ItemRestaurantViewHolder, position: Int) {
        holder.bind(listRestaurant[position])
    }
}