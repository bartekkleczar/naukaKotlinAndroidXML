package pl.klenczi.hindustlumaczyrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRvAdapter: RecyclerView.Adapter<MyVHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyVHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyVHolder, position: Int) {
        holder.myTv.text = "Hello from india"
    }

    override fun getItemCount(): Int {
        return 5
    }

}

class MyVHolder(val view: View):RecyclerView.ViewHolder(view){
        val myTv = view.findViewById<TextView>(R.id.tvName)
}