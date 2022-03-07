package com.example.foodproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodproject.adapter.RecyclerAdapter
import com.example.foodproject.databinding.ActivityMainBinding
import com.example.foodproject.viewmodel.FoodViewModel
import com.example.foodproject.ckeck.ConnectionCheck
import com.example.foodproject.di.AppModule
import com.example.foodproject.model.Recipe
import com.example.foodproject.model.requestdata
import com.example.foodproject.utils.ConstandVar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//у меня тут юзается и биндинг и плагин зависимостей. Второй во фрагменте. Аннотации все к даггер хилт,
//он облегчает ппц всё, погугли ели не шаришь.
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: FoodViewModel by viewModels()
    lateinit var cld: ConnectionCheck


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)

        binding.button.setOnClickListener {
            if(binding.edittext.text != null){
//                тут я беру текст с эдиттекста и сую в конст енд вар, оттуда ретрофит берёт название еды
//                и добавляет к ссылке, потом запускается функция (или метод) в вьюмодели
                ConstandVar.food = binding.edittext.text.toString()
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.setHasFixedSize(true)

                    viewModel.getRecipe{food: List<Recipe> ->
                    recyclerView.adapter = RecyclerAdapter(food)
                }

            }
        }

    }

}