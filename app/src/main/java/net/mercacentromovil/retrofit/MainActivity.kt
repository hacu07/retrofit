package net.mercacentromovil.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import net.mercacentromovil.retrofit.Interfaces.APIService
import net.mercacentromovil.retrofit.pojo.BodyDisp
import net.mercacentromovil.retrofit.pojo.Dispositivo
import net.mercacentromovil.retrofit.pojo.Dispositivos

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        obtenerDispositivos()
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://10.140.10.8/consultor/api.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun obtenerDispositivos(){
        var params  = HashMap<String,String>()
        params.put("opcion","obtenerDispositivos")
        params.put("api_key","3f7d841acd74f7e66aaf6a9f8392204e")
        params.put("usuario_id_permiso","28")
        params.put("cod_permiso","3")



        val service = getRetrofit().create<APIService>(APIService::class.java)

        service.obtenerDispositivos(params).enqueue(object : Callback<Dispositivos>{
            override fun onResponse(call: Call<Dispositivos>, response: Response<Dispositivos>) {
                val dispo = response?.body()
                Log.i("Dispositivos", Gson().toJson(dispo))
            }

            override fun onFailure(call: Call<Dispositivos>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }

    private fun mostrarMsj(msj: String) {
        Toast.makeText(this,msj.trim(),Toast.LENGTH_LONG).show()
    }

    private fun mostrarDispositivos(dispositivos: List<Dispositivo>) {
        dispositivos.forEach {
            tvMsj.append(it.codigo)
        }
    }
}
