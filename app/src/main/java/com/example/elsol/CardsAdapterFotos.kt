package com.example.elsol

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_fotos.*
import kotlinx.android.synthetic.main.item_fotos.view.*
import java.util.*
import kotlin.collections.ArrayList

class CardsAdapterFotos(var items: ArrayList<TarjetaFotos>) : RecyclerView.Adapter<CardsAdapterFotos.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var fotoSol : ImageView
        public var toolbarMenu : Toolbar


        init {
            fotoSol = itemView.findViewById(R.id.imageView)
            toolbarMenu = itemView.findViewById(R.id.toolbar)
            toolbarMenu.inflateMenu(R.menu.menu)
        }

        fun bindTarjeta(t: TarjetaFotos, onClick: (View) -> Unit) = with(itemView) {
            fotoSol.setImageResource(t.imagenesSol)
            toolbarMenu.setTitle(t.toolbar)

            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_fotos, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val itemCard = items.get(pos)
        viewHolder.bindTarjeta(itemCard, onClick)

        viewHolder.toolbarMenu.setOnMenuItemClickListener (object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                    when (item.itemId){
                        R.id.action_uno -> {
                            items.add(viewHolder.adapterPosition, TarjetaFotos(itemCard.imagenesSol , itemCard.toolbar))
                            notifyItemInserted(viewHolder.adapterPosition)
                        }
                        R.id.action_dos -> {
                            items.removeAt(viewHolder.adapterPosition)
                            notifyItemRemoved(viewHolder.adapterPosition)
                        }
                    }
                    return true
            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}