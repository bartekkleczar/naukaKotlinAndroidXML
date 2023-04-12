package pl.klenczi.hindustlumaczyrecyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyRvAdapter: RecyclerView.Adapter<MyVHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVHolder {

    }

    override fun onBindViewHolder(holder: MyVHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 5
    }

}

class MyVHolder(val view: View):RecyclerView.ViewHolder(view){

}