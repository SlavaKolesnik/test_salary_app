package android.example.myapplication

import android.example.myapplication.constance.Constance
import android.example.myapplication.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(bindingClass.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingClass.btResult.setOnClickListener {
            Log.d("MyLog", "ID dula = ${R.drawable.nm}")
            val resultValue = (bindingClass.edValue.text).toString()
            bindingClass.tvResult.visibility = View.VISIBLE
            bindingClass.imPhoto.visibility = View.VISIBLE
            when (resultValue) {
                Constance.DVORNIK -> {
                    val tempText = "Отримайте вашу ${Constance.DVORNIK_SUELDO} грн"

                    if(bindingClass.edPassword.text.toString() == Constance.DVORNIK_PASSWORD) {
                        bindingClass.tvResult.text = tempText

                        bindingClass.imPhoto.setImageResource(R.drawable.egor)
                    }
                    else
                        bindingClass.tvResult.text = "Невірний пароль"
                }

                Constance.INGENER -> {
                    val tempText = "Отримайте вашу ${Constance.INGENER_SUELDO} грн"

                    if(bindingClass.edPassword.text.toString() == Constance.INGENER_PASSWORD) {
                        bindingClass.tvResult.text = tempText

                        bindingClass.imPhoto.setImageResource(R.drawable.sergay)
                    }
                    else
                        bindingClass.tvResult.text = "Невірний пароль"
                }

                Constance.DIRECTOR -> {
                    val tempText = "Отримайте вашу ${Constance.DIRECTOR_SUELDO} грн"

                    if(bindingClass.edPassword.text.toString() == Constance.DIRECTOR_PASSWORD) {
                        bindingClass.tvResult.text = tempText

                        bindingClass.imPhoto.setImageResource(R.drawable.andrey)
                    }
                    else
                        bindingClass.tvResult.text = "Невірний пароль"
                }

                else -> {

                    bindingClass.imPhoto.setImageResource("2131165419".toInt())

                    bindingClass.tvResult.text = "Немає такого працівника"
                }
            }
            Log.d("LogSam", "написав текст: $resultValue")
        }
    }
}