package net.mercacentromovil.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class Dispositivo(@SerializedName("id_disp") var id_disp:String,
                       @SerializedName("codigo") var codigo:String,
                       @SerializedName("nombre_dis") var nombre_dis:String,
                       @SerializedName("id_sucu") var id_sucu:String,
                       @SerializedName("tipo") var tipo:String,
                       @SerializedName("ubicacion") var ubicacion:String,
                       @SerializedName("disponible") var disponible:String
                       )