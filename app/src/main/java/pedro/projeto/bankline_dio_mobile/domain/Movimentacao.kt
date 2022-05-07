package pedro.projeto.bankline_dio_mobile.domain

import com.google.gson.annotations.SerializedName

data class Movimentacao(
    val id:Int,
    val dataHora:String,
    val descricao:String,
    val valor : Double,
    val tipo: TipoMovimentacao,
    //TODO Mapear id Conta ->id correntista

    @SerializedName("idConta")
    val idCorrentista:Int

)
