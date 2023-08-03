package cl.awakelab.ejercicio5m6.data

import cl.awakelab.ejercicio5m6.data.remote.Terreno
import cl.awakelab.ejercicio5m6.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {
    suspend fun cargarTerreno(): List<Terreno>{
        val respuesta = terrenoAPI.getData()
        if(respuesta.isSuccessful){
          val resp = respuesta.body()
          resp?.let{
              return it
          }
      }
        return emptyList()
    }
}