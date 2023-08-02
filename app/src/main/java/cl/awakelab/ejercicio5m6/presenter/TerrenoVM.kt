package cl.awakelab.ejercicio5m6.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.ejercicio5m6.data.Repositorio
import cl.awakelab.ejercicio5m6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio


init {
    val api = TerrenoRetroFit.getRetrofitClient()
    repositorio = Repositorio(api)
}
    fun getAllTerrenos() = viewModelScope.launch{
        repositorio.cargarTerreno()
    }
}