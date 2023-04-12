package pl.klenczi.hindustlumaczyrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRvAdapter: RecyclerView.Adapter<MyVHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVHolder {
        // tego nie tykasz w zasadzie bo po co, wazne ze dziala
        val layoutInflater = LayoutInflater.from(parent.context) // rozwiewanie layoutu, tak jak w przypadku bindingu nie mam pojecia po co ale tak trzeba zeby dzialalo
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false) // tu w pierwszym argumencie funkcji dajesz po "R.id" nazwe xmla w ktorym jest to co chcesz wyswietlic
        return MyVHolder(listItem) // zwraca to co chcesz wyswietlic w recyclerView
    }

    override fun onBindViewHolder(holder: MyVHolder, position: Int) {
        // tu dawaj to co chcesz wyswietlic
        holder.myTv.text = "Hello from india $position"
    }

    override fun getItemCount(): Int {
        // tu ustalasz ilosc elementow
        return 5
    }

}

class MyVHolder(val view: View):RecyclerView.ViewHolder(view){
        // nw po co to jest ale ma byc zeby dzialalo - "myTv" uzywasz potem w "onBindViewHolder" do wyswietlania rzeczy
        val myTv = view.findViewById<TextView>(R.id.tvName)
}