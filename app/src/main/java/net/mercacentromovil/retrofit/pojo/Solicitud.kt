package net.mercacentromovil.retrofit.pojo

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Dispositivos(@SerializedName("error") var error:Boolean,
                        @SerializedName("dispositivos") var dispositivos: List<Dispositivo>,
                        @SerializedName("msj") var msj: String)