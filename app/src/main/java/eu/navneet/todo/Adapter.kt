package eu.navneet.todo

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import java.util.*

class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var priority = itemView.priority
        var layout = itemView.my_layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        when (data[position].priority.lowercase(Locale.getDefault())) {

            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#EB1D36"))

            "low" -> holder.layout.setBackgroundColor(Color.parseColor("#5FD068"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#A2B5BB"))
        }

        holder.title.text = data[position].title
        holder.priority.text = data[position].priority
        holder.itemView.setOnClickListener{
            val intent =Intent(holder.itemView.context,EditTask::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}