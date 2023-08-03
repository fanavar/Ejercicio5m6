package cl.awakelab.ejercicio5m6.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.ejercicio5m6.data.Repositorio
import cl.awakelab.ejercicio5m6.data.remote.Terreno
import cl.awakelab.ejercicio5m6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()
init {
    val api = TerrenoRetroFit.getRetrofitClient()
    repositorio = Repositorio(api)
}
    fun getAllTerrenos() = viewModelScope.launch{
        terrenosLiveData.value = repositorio.cargarTerreno()

    }
}