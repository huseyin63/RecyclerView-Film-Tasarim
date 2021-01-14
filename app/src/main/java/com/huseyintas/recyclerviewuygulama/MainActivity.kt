package com.huseyintas.recyclerviewuygulama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  lateinit var filmlerArrayList:ArrayList<Filmler>
    private  lateinit var  adapter: filmler_adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerview.setHasFixedSize(true) // tasarımın ekranda güzel durması için yaptık
        recyclerview.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) // cardviewlerin nasıl duracağını belirledik

        val f1 = Filmler(1,"Django","django",14.99)
        val f2 = Filmler(2,"Inception","inception",18.99)
        val f3 = Filmler(3,"Interstellar","interstellar",20.99)
        val f4 = Filmler(4,"The Hateful Eight","thehatefuleight",40.99)
        val f5 = Filmler(5,"The Pianist","thepianist",25.99)
        val f6 = Filmler(6,"Bir Zamanlar Anadoluda","birzamanlaranadoluda",4.99)


        filmlerArrayList = ArrayList<Filmler>()
        filmlerArrayList.add(f1)
        filmlerArrayList.add(f2)
        filmlerArrayList.add(f3)
        filmlerArrayList.add(f4)
        filmlerArrayList.add(f5)
        filmlerArrayList.add(f6)

        adapter = filmler_adapter(this@MainActivity,filmlerArrayList)
        recyclerview.adapter = adapter

    }
}