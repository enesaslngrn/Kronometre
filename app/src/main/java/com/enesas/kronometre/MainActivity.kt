package com.enesas.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.enesas.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var saniye = 0
    var dakika = 0
    var saat = 0
    var turSayisi: Int = 0
    var runnable: Runnable = Runnable {  } // bu da bir interface yani class değil. Aynı Abstract class gibi. Yani obje oluşturamayız.
    var handler: Handler = Handler()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        var view = binding.root
        setContentView(view)

        binding.textView.text = "00 : 00 : 00"

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val turBaslatFragment = TurBaslatFragment()
        fragmentTransaction.replace(R.id.frameLayout,turBaslatFragment).commit()
    }

    fun baslat(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        runnable = object: Runnable{
            override fun run() {
                saniye += 1
                if (saniye == 60){
                    saniye = 0
                    dakika += 1
                    if (dakika == 60){
                        dakika = 0
                        saat += 1
                    }
                }
                val time = String.format("%02d : %02d : %02d",saat,dakika,saniye)
                handler.postDelayed(runnable,1)
                binding.textView.text = time
            }
        }
        handler.post(runnable)

        val turDurFragment = TurDurFragment()
        fragmentTransaction.replace(R.id.frameLayout,turDurFragment).commit()
    }

    fun dur(view:View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        handler.removeCallbacks(runnable)

        val sifirlaSurdurFragment = SifirlaSurdurFragment()
        fragmentTransaction.replace(R.id.frameLayout,sifirlaSurdurFragment).commit()
    }
    fun surdur(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        runnable = object: Runnable{
            override fun run() {
                saniye += 1
                if (saniye == 60){
                    saniye = 0
                    dakika += 1
                    if (dakika == 60){
                        dakika = 0
                        saat += 1
                    }
                }
                val time = String.format("%02d : %02d : %02d",saat,dakika,saniye)
                handler.postDelayed(runnable,1)
                binding.textView.text = time
            }
        }

        handler.post(runnable)

        val turDurFragment = TurDurFragment()
        fragmentTransaction.replace(R.id.frameLayout,turDurFragment).commit()
    }
    fun sifirla(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        saniye = 0
        dakika = 0
        saat = 0
        binding.textView.text = "00 : 00 : 00"

        val turBaslatFragment = TurBaslatFragment()
        fragmentTransaction.replace(R.id.frameLayout,turBaslatFragment).commit()
    }

    fun tur(view:View){


        turSayisi += 1
        var turSayisiString = String.format("%02d",turSayisi)
        val time = String.format("%02d : %02d : %02d",saat,dakika,saniye)

        binding.textView2.text = "Tur: $turSayisiString        Toplam Süre: $time"



    }
}