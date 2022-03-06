package com.example.foodproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.foodproject.R
import com.example.foodproject.model.Recipe
import com.example.foodproject.model.requestdata
import com.example.foodproject.utils.ConstandVar.food
import com.example.foodproject.viewmodel.FoodViewModel
import com.squareup.picasso.Picasso
// дристанутый адаптер. Тебе, скорее всего прийдется мучится в нем и в мейн активити
class RecyclerAdapter()
    : RecyclerView.Adapter<RecyclerAdapter.FoodHolder>() {
    class FoodHolder(view: View) : RecyclerView.ViewHolder(view) {
        // тут, думаю ясно всё
       val imageView: ImageView
       val textView1: TextView
       val textView2: TextView
       val textView3: TextView

       init{
           imageView = view.findViewById(R.id.imageView)
           textView1 = view.findViewById(R.id.textView)
           textView2 = view.findViewById(R.id.textView2)
           textView3 = view.findViewById(R.id.textView3)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.FoodHolder {
        // шаблонный код, который 100% правильный
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_row, parent, false)

        return FoodHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.FoodHolder, position: Int) {
        // сую данные вьюшки, для этого и указывал всё налл, и тут могут быль приколы, возможно
        holder.textView1.text = Recipe().title
        holder.textView2.text = Recipe().source_url
        holder.textView3.text = Recipe().publisher
        Picasso.get()
            .load(Recipe().image_url)
            .into(holder.imageView)
    }
    override fun getItemCount(): Int {
        // тоже опасная дичь, тут должно быль количество рецептов (элементов в ресайклере)
        // по дефолту 1, но я надеюсь, что оно изменится перед тем, как юзатся, типа ретрофит возьмет истинное кол-во
        return requestdata().count
    }
}
