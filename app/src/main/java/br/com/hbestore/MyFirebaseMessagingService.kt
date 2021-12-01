package br.com.hbestore

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.reflect.TypeToken

class MyFirebaseMessagingService: FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("firebase", "Novo token: $token")
        Prefs.setString("FB_TOKEN",token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage) {
        Log.d("firebase", "onMessageRecived")

        if (mensagemRemota?.notification != null){
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d("firebase", "Titulo: ${titulo}")
            Log.d("firebase", "Corpo: ${corpo}")

            val intent = Intent(this, ProdutoActivity::class.java)

            NotificationUtil.create(1, intent, titulo!!, corpo!!)
        }
    }



}