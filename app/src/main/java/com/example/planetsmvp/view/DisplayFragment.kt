package com.example.planetsmvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.planetsmvp.R
import com.example.planetsmvp.model.Planet
import com.example.planetsmvp.network.PlanetAPI
import com.example.planetsmvp.network.PlanetRetrofit.instance
import com.example.planetsmvp.presenter.MainContract
import com.example.planetsmvp.presenter.MainContract.Presenter
import com.example.planetsmvp.presenter.MainPresenter
import com.example.planetsmvp.recyclerview.PlanetAdapter
import java.util.*

class DisplayFragment : Fragment(), MainContract.View {
    private var adapter: PlanetAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.planet_recyclerview)
        adapter = PlanetAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter!!.setAdapterList(ArrayList())
        recyclerView.adapter = adapter
        networkCall()
    }

    private fun networkCall() {
        val api = instance?.create(PlanetAPI::class.java)
        val presenter = MainPresenter(this, api)
        presenter.planets
    }

    override fun onSuccess(planetList: List<Planet?>?) {
        adapter!!.setAdapterList(planetList)
    }


    override fun onError(t: Throwable?) {
        Toast.makeText(requireContext(), "Info Not Available", Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(): DisplayFragment {
            return DisplayFragment()
        }
    }
}