package pedro.projeto.bankline_dio_mobile.data.remote

import pedro.projeto.bankline_dio_mobile.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.Path

interface BankLineApi {
    @GET("/movimentacoes/{id}")
   suspend fun findBankStatement(@Path("id") accountHounderId : Int):List<Movimentacao>

}