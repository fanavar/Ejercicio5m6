package cl.awakelab.ejercicio5m6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TerrenoDao {

    @Insert
    suspend fun insertarTerreno (terrenoEntity: TerrenoEntity)

    @Insert
    suspend fun insertarTerrenos(terrenoEntity: List<TerrenoEntity>)

    @Query("Select * from tabla_terreno order by id asc")
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>
}