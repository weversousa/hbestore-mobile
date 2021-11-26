package br.com.hbestore

import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseManager {
    private var dbInstance: LMSDatabase

    init {
        val context = LMSAplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            LMSDatabase::class.java,
            "lms.sqlite"
        ).build()
    }

    fun getProdutoDAO(): ProdutoDAO{
        return dbInstance.produtoDAO()
    }
}