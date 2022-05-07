package pedro.projeto.bankline_dio_mobile.data.remote

sealed class State<out T>{
    data class Sucess<out R>(val data: R?=null) :State<R?>()

    data class Error(val messenge: String? = null) :State<Nothing>()

    object Wait :State<Nothing>()
}
