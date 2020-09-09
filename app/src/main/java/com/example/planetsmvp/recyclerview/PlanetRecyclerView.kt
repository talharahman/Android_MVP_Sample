package com.example.planetsmvp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.planetsmvp.R
import com.example.planetsmvp.model.Planet
import com.squareup.picasso.Picasso

class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val planetName: TextView = itemView.findViewById(R.id.planet_name)
    private val planetNumber: TextView = itemView.findViewById(R.id.planet_number)
    private val planetImage: ImageView = itemView.findViewById(R.id.planet_image)

    fun onBind(planet: Planet) {
        planetName.text = planet.name
        planetNumber.text = planet.number.toString()
        Picasso.get()
                .load(planet.image)
                .into(planetImage)
    }

}

class PlanetAdapter : RecyclerView.Adapter<PlanetViewHolder>() {
    private var planets: List<Planet>? = null

    fun setAdapterList(planets: List<Planet?>?) {
        this.planets = planets as List<Planet>?
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        return PlanetViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.planets_itemview, parent, false))
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.onBind(planets!![position])
    }

    override fun getItemCount(): Int {
        return planets!!.size
    }
}