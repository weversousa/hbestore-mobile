package br.com.hbestore

import android.app.Application
import android.view.View
import java.lang.IllegalStateException

class LMSAplication() : Application() {


    override fun onCreate(){
        super.onCreate()
        appInstance = this
    }

    companion object{
        private var appInstance: LMSAplication? = null
        fun getInstance(): LMSAplication{
            if (appInstance == null){
                throw IllegalStateException("Configurar application no Manifest")
            }
            return appInstance!!
        }
    }

}