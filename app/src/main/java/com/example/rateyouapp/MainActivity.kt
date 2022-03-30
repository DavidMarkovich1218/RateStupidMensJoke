package com.example.rateyouapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rateyouapp.databinding.ActivityMainBinding
import com.mashape.unirest.http.Unirest
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.json.JSONObject


lateinit var bindingClass: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    bindingClass = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)
        doAsync {
            var respose =
                Unirest.get("https://random-stuff-api.p.rapidapi.com/joke?tag=men")
                    .header("Authorization", "NwfxFeImQg9p")
                    .header("X-RapidAPI-Host", "random-stuff-api.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "dfd13661dbmsh0610c2e8200745dp19acd2jsn8894c165bbc9")
                    .asString();
            var all = respose.body
            var allres = JSONObject(all).getString("joke")

            activityUiThread {
                bindingClass.textView.text = allres.toString()
            }
        }
       bindingClass.button.setOnClickListener() {
           val i = 5
           val resultInput = bindingClass.inputResult.text.toString().toInt()
           when (resultInput) {
               in 0..1 -> {
                   bindingClass.textView2.visibility = View.VISIBLE
                   bindingClass.textView2.text = "Try another one. Your rate is " + resultInput
               }
               in 2..3 -> {
                   bindingClass.textView2.visibility = View.VISIBLE
                   bindingClass.textView2.text = "I think it's not bad. Your rate is " + resultInput
               }
               in 4..5 -> {
                   bindingClass.textView2.visibility = View.VISIBLE
                   bindingClass.textView2.text = "Perfectoo. Your rate is " + resultInput
               }
               in 6..1000 -> {
                   bindingClass.textView2.visibility = View.VISIBLE
                   bindingClass.textView2.text = "Avocados are a fruit, not a vegetable. Your rate is " + resultInput
               }
           }
       }
        bindingClass.button3.setOnClickListener(){
            doAsync {
                var respose =
                    Unirest.get("https://random-stuff-api.p.rapidapi.com/joke?tag=men")
                        .header("Authorization", "NwfxFeImQg9p")
                        .header("X-RapidAPI-Host", "random-stuff-api.p.rapidapi.com")
                        .header("X-RapidAPI-Key", "dfd13661dbmsh0610c2e8200745dp19acd2jsn8894c165bbc9")
                        .asString();
                var all = respose.body
                var allres = JSONObject(all).getString("joke")

                activityUiThread {
                    bindingClass.textView.text = allres.toString()
                }
            }
        }
    }
}

