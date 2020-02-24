package net.mercacentromovil.retrofit.Interfaces

import net.mercacentromovil.retrofit.pojo.BodyDisp
import net.mercacentromovil.retrofit.pojo.Dispositivos
import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @FormUrlEncoded
    @POST("./")
    fun obtenerDispositivos(@FieldMap body: Map<String, String>): Call<Dispositivos>
}