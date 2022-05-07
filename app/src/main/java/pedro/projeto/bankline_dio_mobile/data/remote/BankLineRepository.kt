package pedro.projeto.bankline_dio_mobile.data.remote

import android.util.Log
import androidx.lifecycle.liveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception

object BankLineRepository {

    private val TAG = javaClass.simpleName

    private  val restApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://pedro1-dio-bankline-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BankLineApi::class.java)
    }

    fun findBankStatement(accountHolderId : Int) = liveData {
        emit(State.Wait)
        try {
           emit(State.Sucess(data = restApi.findBankStatement(accountHolderId)))


        } catch (e:Exception){
            Log.e(TAG,e.message,e)
            emit(State.Error(e.message))
        }

    }

    }
