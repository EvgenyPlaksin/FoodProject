package com.example.foodproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
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
    val true_food = listOf<String>("carrot",
                "broccoli",
                "asparagus",
                "cauliflower",
                "corn",
                "cucumber",
                "green pepper",
                "lettuce",
                "mushrooms",
                "onion",
                "potato",
                "pumpkin",
                "red pepper",
                "tomato",
                "beetroot",
                "brussel sprouts",
                "peas",
                "zucchini",
                "radish",
                "sweet potato",
                "artichoke",
                "leek",
                "cabbage",
                "celery",
                "chili",
                "garlic",
                "basil",
                "coriander",
                "parsley",
                "dill",
                "rosemary",
                "oregano",
                "cinnamon",
                "saffron",
                "green bean",
                "bean",
                "chickpea",
                "lentil",
                "apple",
                "apricot",
                "avocado",
                "banana",
                "blackberry",
                "blackcurrant",
                "blueberry",
                "boysenberry",
                "cherry",
                "coconut",
                "fig",
                "grape",
                "grapefruit",
                "kiwifruit",
                "lemon",
                "lime",
                "lychee",
                "mandarin",
                "mango",
                "melon",
                "nectarine",
                "orange",
                "papaya",
                "passion fruit",
                "peach",
                "pear",
                "pineapple",
                "plum",
                "pomegranate",
                "quince",
                "raspberry",
                "strawberry",
                "watermelon",
                "salad",
                "pizza",
                "pasta",
                "popcorn",
                "lobster",
                "steak",
                "bbq",
                "pudding",
                "hamburger",
                "pie",
                "cake",
                "sausage",
                "tacos",
                "kebab",
                "poutine",
                "seafood",
                "chips",
                "fries",
                "masala",
                "paella",
                "som tam",
                "chicken",
                "toast",
                "marzipan",
                "tofu",
                "ketchup",
                "hummus",
                "chili",
                "maple syrup",
                "parma ham",
                "fajitas",
                "champ",
                "lasagna",
                "poke",
                "chocolate",
                "croissant",
                "arepas",
                "bunny chow",
                "pierogi",
                "donuts",
                "rendang",
                "sushi",
                "ice cream",
                "duck",
                "curry",
                "beef",
                "goat",
                "lamb",
                "turkey",
                "pork",
                "fish",
                "crab",
                "bacon",
                "ham",
                "pepperoni",
                "salami",
                "ribs")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        cld = ConnectionCheck(application)

        cld.observe(this) { isConnected ->
            if (isConnected) {
                invisibletextview.visibility = View.INVISIBLE

                binding.button.setOnClickListener {
                    if (binding.edittext.text?.length != 0) {
                        if (true_or_not(binding.edittext.text.toString())) {
                            invisibletextview.visibility = View.INVISIBLE
//                тут я беру текст с эдиттекста и сую в конст енд вар, оттуда ретрофит берёт название еды
//                и добавляет к ссылке, потом запускается функция (или метод) в вьюмодели
                            ConstandVar.food = binding.edittext.text.toString()
                            recyclerView.layoutManager = LinearLayoutManager(this)
                            recyclerView.setHasFixedSize(true)

                            viewModel.getRecipe { food: List<Recipe> ->
                                recyclerView.adapter = RecyclerAdapter(food)
                            }

                        }else{
                            recyclerView.adapter = null
                            invisibletextview.text = "Nothing found("
                            invisibletextview.visibility = View.VISIBLE
                        }
                    }
                }
            } else {
                invisibletextview.text = "No Internet!"
                invisibletextview.visibility = View.VISIBLE
            }

        }


    }
    fun true_or_not(ures_request: String): Boolean {
     for(i in true_food){
           if(ures_request.equals(i)){
               return true
           }
       }
          return false
        }
}
