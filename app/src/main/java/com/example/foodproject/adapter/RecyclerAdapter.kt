package com.example.foodproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodproject.R
import com.example.foodproject.model.Recipe
import com.example.foodproject.model.requestdata
import com.example.foodproject.utils.ConstandVar.food
import com.example.foodproject.viewmodel.FoodViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

// дристанутый адаптер. Тебе, скорее всего прийдется мучится в нем и в мейн активити
class RecyclerAdapter(
    private val dataset: List<Recipe>
)
    : RecyclerView.Adapter<RecyclerAdapter.FoodHolder>() {
    class FoodHolder(view: View) : RecyclerView.ViewHolder(view) {
        // тут, думаю ясно всё
      fun bindRecipe(recipe: Recipe){
            itemView.textView.text = recipe.title
            itemView.textView3.text = recipe.publisher
            itemView.imageView.load(recipe.image_url) {
                // placeholder image is the image used
                // when our image url fails to load.
                placeholder(R.drawable.ic_baseline_error_24)
            }
      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.FoodHolder {
        // шаблонный код, который 100% правильный
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_row, parent, false)

        return FoodHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.FoodHolder, position: Int) {
       holder.bindRecipe(dataset.get(position))
    }
    override fun getItemCount(): Int = dataset.size
}
