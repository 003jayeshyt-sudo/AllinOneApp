package com.smartapp.allinoneapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smartapp.allinoneapp.AppItem
import com.smartapp.allinoneapp.R
import com.smartapp.allinoneapp.WebViewActivity

class GridAdapter(
    private val items: List<AppItem>
) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.appIcon)
        val name: TextView = view.findViewById(R.id.appName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.icon.setImageResource(item.icon)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", item.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
