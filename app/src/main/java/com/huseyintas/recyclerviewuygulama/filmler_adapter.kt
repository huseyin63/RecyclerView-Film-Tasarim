package com.huseyintas.recyclerviewuygulama

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// mContext:Context -> android'e özgü işlemleri(yapıları)kullanmamıza  yapmamızı sağlar. Örneğin Toast mesaj veya tasarima erişmek gibi..

class filmler_adapter(private val mContext:Context,private val filmler_listesi:List<Filmler>):RecyclerView.Adapter<filmler_adapter.CardviewTasarimNesneTutucu>(){


    inner class CardviewTasarimNesneTutucu(view:View):RecyclerView.ViewHolder(view){ //view sayesinde cardview'deki görsel nesnelere erişebileceğiz.

        var imageView_film_resmi:ImageView
        var textView_filmbaslik:TextView
        var textView_film_fiyat:TextView
        var buttonsepete_ekle:Button

        init {

            imageView_film_resmi = view.findViewById(R.id.imageView_film_resmi)
            textView_filmbaslik = view.findViewById(R.id.textView_filmbaslik)
            textView_film_fiyat = view.findViewById(R.id.textView_film_fiyat)
            buttonsepete_ekle = view.findViewById(R.id.buttonsepete_ekle)
        }
    }


    override fun getItemCount(): Int { // Bu metot bizden veri kümesinin boyutunu istiyor.Yani  kaç tane veri göstereceğini belirtiyoruz.
        return filmler_listesi.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardviewTasarimNesneTutucu { // tasarımı bağlayacağımız metot.
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.cardview_film_tasarim,parent,false) // görsel tasarımı yazılımsal tasarım(parent) ile birleştirdik.false ise bu tasarımı
        // başka tasarım eklemek istemediğimizi belirtik.

        return CardviewTasarimNesneTutucu(tasarim) // tasarima eriştik (cardview_film_tasarim'a eriştik)
    }

    override fun onBindViewHolder(holder: CardviewTasarimNesneTutucu, position: Int) { // holder nesnesi ile tasarimdaki görsel nesnelere erişebiliriz.
        //öncelikli olarak veri kümesinden verileri alıp bu görsel nesneler üzerine aktaracağız.

        val film = filmler_listesi[position]
        holder.textView_filmbaslik.text = film.film_adi
        holder.textView_film_fiyat.text = "${film.film_fiyat} $"

        // veri setindeki resimleri dinamik olarak almak için yani her seferinde farklı resimin gelmesi için bu şekilde kullandık.
        holder.imageView_film_resmi.setImageResource(mContext.resources.getIdentifier(film.film_resim_ad,"drawable",mContext.packageName))

        holder.buttonsepete_ekle.setOnClickListener{

            Toast.makeText(mContext,"${film.film_adi} sepete eklendi",Toast.LENGTH_SHORT).show()
        }
    }

}






















