package com.smartapp.allinoneapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartapp.allinoneapp.adapters.GridAdapter

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_category, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)

        val position = arguments?.getInt("pos") ?: 0
        val apps = getAppsByCategory(position)

        recyclerView.adapter = GridAdapter(apps)

        return view
    }


    private fun getAppsByCategory(position: Int): List<AppItem> {
        return when (position) {

            // 🔵 SOCIAL
            0 -> listOf(
                AppItem("Instagram", R.drawable.instagram, "https://www.instagram.com"),
                AppItem("Facebook", R.drawable.facebook, "https://m.facebook.com"),
                AppItem("Twitter (X)", R.drawable.twitter, "https://mobile.twitter.com"),
                AppItem("LinkedIn", R.drawable.linkedin, "https://www.linkedin.com"),
                AppItem("Reddit", R.drawable.reddit, "https://www.reddit.com"),
                AppItem("Quora", R.drawable.quora, "https://www.quora.com"),
                AppItem("Pinterest", R.drawable.pinterest, "https://www.pinterest.com")
            )

            // 🛒 SHOPPING
            1 -> listOf(
                AppItem("Amazon", R.drawable.amazon, "https://www.amazon.in"),
                AppItem("Flipkart", R.drawable.flipkart, "https://www.flipkart.com"),
                AppItem("Myntra", R.drawable.myntra, "https://www.myntra.com"),
                AppItem("Meesho", R.drawable.meesho, "https://www.meesho.com"),
                AppItem("Ajio", R.drawable.ajio, "https://www.ajio.com"),
                AppItem("Snapdeal", R.drawable.snapdeal, "https://www.snapdeal.com"),
                AppItem("TataCliq", R.drawable.tatacliq, "https://www.tatacliq.com")
            )

            // 🍔 FOOD
            2 -> listOf(
                AppItem("Zomato", R.drawable.zomato, "https://www.zomato.com"),
                AppItem("Swiggy", R.drawable.swiggy, "https://www.swiggy.com"),
                AppItem("Domino's", R.drawable.dominos, "https://www.dominos.co.in"),
                AppItem("Pizza Hut", R.drawable.pizzahut, "https://www.pizzahut.co.in"),
                AppItem("Uber Eats", R.drawable.ubereats, "https://www.ubereats.com")
            )

            // 🎬 ENTERTAINMENT
            else -> listOf(
                AppItem("YouTube", R.drawable.youtube, "https://m.youtube.com"),
                AppItem("Netflix", R.drawable.netflix, "https://www.netflix.com"),
                AppItem("Amazon Prime", R.drawable.amazonprime, "https://www.primevideo.com"),
                AppItem("Hotstar", R.drawable.hotstar, "https://www.hotstar.com"),
                AppItem("Spotify", R.drawable.spotify, "https://open.spotify.com"),
                AppItem("JioCinema", R.drawable.jiocinema, "https://www.jiocinema.com"),
                AppItem("SonyLIV", R.drawable.sonyliv, "https://www.sonyliv.com")
            )
        }
    }

    companion object {
        fun newInstance(position: Int): CategoryFragment {
            val fragment = CategoryFragment()
            val bundle = Bundle()
            bundle.putInt("pos", position)
            fragment.arguments = bundle
            return fragment
        }
    }
}



