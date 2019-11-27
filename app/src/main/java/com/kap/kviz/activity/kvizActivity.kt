package com.kap.kviz.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kap.kviz.R
import com.kap.kviz.krajActivity
import com.kap.kviz.model.Kviz
import kotlinx.android.synthetic.main.activity_kviz.*

class kvizActivity : AppCompatActivity() {


        val NEXT: Int = 1
        val PREVIUS: Int = -1
        var kviz = Kviz()
        var trenutniIndexPitanja = 0
        var rezultat: Int = 0
        var trenutnopitanje = kviz.PItanja[trenutniIndexPitanja]



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kviz)


        textView_pitanje.text = trenutnopitanje.textPitanja
        textView_brojPitanja.text = "Pitanje: ${trenutniIndexPitanja + 1} / ${kviz.PItanja.size}"
        textView_rezultat.text = "Rezultat> $rezultat"

        button_dalje.isEnabled = true
        button_nazad.isEnabled = false
        button_kraj.isEnabled = false

        //Buttons

        button_da.setOnClickListener {
           odgovori(true)

        }


        button_ne.setOnClickListener {
           odgovori(false)
        }


        button_dalje.setOnClickListener {
            updatetrenutnoPianje (NEXT)

        }

        button_nazad.setOnClickListener {
            updatetrenutnoPianje(PREVIUS)


        }
        button_kraj.setOnClickListener {
            val intent = Intent(this, krajActivity::class.java)
            val bundle= Bundle()
            bundle.putInt(krajActivity.REZULTAT)
            startActivity(intent)
        }


    }


    fun updatetrenutnoPianje (index: Int) {
        if (index == NEXT) {
            trenutniIndexPitanja += 1
        } else if (index == PREVIUS) {
            trenutniIndexPitanja -= 1
        }

        if (trenutniIndexPitanja == 0) {
            button_dalje.isEnabled = true
            button_nazad.isEnabled = false
            button_kraj.isEnabled = false
        } else if (trenutniIndexPitanja == kviz.PItanja.size - 1){
            button_dalje.isEnabled = false
            button_nazad.isEnabled = true
            button_kraj.isEnabled = true
    }
        else {
            button_dalje.isEnabled = true
            button_nazad.isEnabled = true
            button_kraj.isEnabled = false
        }

        trenutnopitanje=kviz.PItanja [trenutniIndexPitanja]
        textView_pitanje.text=trenutnopitanje.textPitanja
        textView_brojPitanja.text= "Pitanje: ${trenutniIndexPitanja +1}/${kviz.PItanja.size}"

        updateDANE()

    }

    private fun updateDANE(){
        if (trenutnopitanje.daLiJeOdgovoreno){
            button_da.isEnabled =false
            button_ne.isEnabled=false
        } else {
            button_da.isEnabled=true
            button_ne.isEnabled=true
        }
    }

    private fun odgovori(odgovor: Boolean){
        trenutnopitanje.daLiJeOdgovoreno = true

        if(trenutnopitanje.daLiJeTacno == odgovor){
            Toast.makeText(this, "Vaš odgovor je tačan", Toast.LENGTH_SHORT).show()
            rezultat+=10
            textView_rezultat.text="Rezultat: $rezultat"
        } else {
            Toast.makeText(this, "Vaš odgovor je netačan", Toast.LENGTH_SHORT).show()
        }
        updateDANE()
    }

}

