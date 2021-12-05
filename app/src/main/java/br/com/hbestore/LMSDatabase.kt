package br.com.hbestore

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Produto::class), version = 1)
abstract class LMSDatabase: RoomDatabase() {
    abstract fun produtoDAO(): ProdutoDAO
}