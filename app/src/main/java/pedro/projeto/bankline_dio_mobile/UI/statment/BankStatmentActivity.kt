package pedro.projeto.bankline_dio_mobile.UI.statment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import pedro.projeto.bankline_dio_mobile.R
import pedro.projeto.bankline_dio_mobile.data.remote.State
import pedro.projeto.bankline_dio_mobile.databinding.ActivityBankStatmentBinding
import pedro.projeto.bankline_dio_mobile.databinding.ActivityWelcomeBinding
import pedro.projeto.bankline_dio_mobile.domain.Correntista
import pedro.projeto.bankline_dio_mobile.domain.Movimentacao
import pedro.projeto.bankline_dio_mobile.domain.TipoMovimentacao
import java.lang.IllegalArgumentException

class BankStatmentActivity : AppCompatActivity() {

    companion object{
        const val  EXTRA_ACCOUNT_HOLDER = "pedro.projeto.bankline_dio_mobile.UI.statment.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding  by lazy {
        ActivityBankStatmentBinding.inflate(layoutInflater)
    }

    private  val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER)?:throw IllegalArgumentException(        )
    }

    private val viewModel  by viewModels<BankStatmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()



    }

    private fun findBankStatement(){

        viewModel.findBankStatement(accountHolder.id )
            .observe(this){
                when(it){
                    is State.Sucess -> {
                        binding.rvBankStatement.adapter = it.data?.let { it1 ->
                            BankStatmentAdapter(
                                it1
                            )
                        }
                      binding.srlBankStatement.isRefreshing = false
                    }
                    is State.Error -> {
                        it.messenge?.let { it1 ->
                            Snackbar.make(binding.rvBankStatement, it1,Snackbar.LENGTH_LONG)
                                .show()
                        }
                        binding.srlBankStatement.isRefreshing = false
                    }
                    State.Wait -> binding.srlBankStatement.isRefreshing = true
                }
            }


    }
}