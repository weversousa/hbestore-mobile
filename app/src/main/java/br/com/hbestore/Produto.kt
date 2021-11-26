package br.com.hbestore

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "produto")
class Produto: Serializable{

    @PrimaryKey
    var id: Long? = null
    var nome = ""
    var valor = ""
    var url = ""
}