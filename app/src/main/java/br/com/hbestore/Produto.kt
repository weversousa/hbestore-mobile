package br.com.hbestore

import java.io.Serializable

class Produto: Serializable {
    var id: Long? = null
    var nome = ""
    var valor = ""
    var url = ""
}